package com.example.foundmynotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class noteDetailsActivity extends AppCompatActivity {

    EditText titleEditText, contentEditText;
    ImageButton btnSaveNote;
    TextView btnDeleteNote, pageTitleTextView;
    String title, content, docId;
    boolean isEditMode = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        titleEditText = findViewById(R.id.notes_title_text);
        contentEditText = findViewById(R.id.notes_content_text);
        btnSaveNote = findViewById(R.id.btnSaveNote);
        btnDeleteNote = findViewById(R.id.delete_note);
        pageTitleTextView = findViewById(R.id.page_Title);

        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        docId = getIntent().getStringExtra("docId");

        if(docId!=null && !docId.isEmpty()){
            isEditMode = true;
        }

        titleEditText.setText(title);
        contentEditText.setText(content);

        if(isEditMode){
            pageTitleTextView.setText("Edit your note");
            btnDeleteNote.setVisibility(View.VISIBLE);
        }

        btnSaveNote.setOnClickListener( (v)->saveNote());
        btnDeleteNote.setOnClickListener( (v)->deleteNoteFromFirebase());
    }

    private void deleteNoteFromFirebase() {
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForNotes().document(docId);

        documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    //note is deleted
                    Utility.showToast(noteDetailsActivity.this, "Note deleted successfully!");
                    finish();
                }else{
                    Utility.showToast(noteDetailsActivity.this, "Failed to delete the note!");
                }
            }
        });
        finish();
    }



    void saveNote(){
        String note_Title = titleEditText.getText().toString();
        String note_Content = contentEditText.getText().toString();

        if(note_Title == null || note_Title.isEmpty()){
            titleEditText.setError("Please input a title!");
            return;
        }

        Note note = new Note();
        note.setTitle(note_Title);
        note.setContent(note_Content);
        note.setTimestamp(Timestamp.now());

        saveNoteToFirebase(note);
        finish();
    }

    private void saveNoteToFirebase(Note note) {
        DocumentReference documentReference;
        if(isEditMode){
            //update the note
            documentReference = Utility.getCollectionReferenceForNotes().document(docId);
        }else{
            //create new note
            documentReference = Utility.getCollectionReferenceForNotes().document();
        }

        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    //notes is added
                    Utility.showToast(noteDetailsActivity.this, "Note added successfully!");
                    finish();
                }else{
                    Utility.showToast(noteDetailsActivity.this, "Failed while adding the note!");
                }
            }
        });
    }


}