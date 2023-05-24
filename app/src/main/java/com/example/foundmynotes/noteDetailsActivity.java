package com.example.foundmynotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class noteDetailsActivity extends AppCompatActivity {

    EditText titleEditText, contentEditText;
    ImageButton btnSaveNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        titleEditText = findViewById(R.id.notes_title_text);
        contentEditText = findViewById(R.id.notes_content_text);
        btnSaveNote = findViewById(R.id.btnSaveNote);

        btnSaveNote.setOnClickListener( (v)->saveNote());

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
    }

    private void saveNoteToFirebase(Note note) {
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForNotes().document();

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
        })
    }
}