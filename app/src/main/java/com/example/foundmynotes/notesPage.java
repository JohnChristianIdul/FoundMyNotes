package com.example.foundmynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class notesPage extends AppCompatActivity {

    FloatingActionButton btnAddNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_page);

        btnAddNote = findViewById(R.id.btn_AddNote);
        btnAddNote.setOnClickListener((v)->startActivity(new Intent(notesPage.this, noteDetailsActivity.class)));
    }
}