package com.example.foundmynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

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

    }
}