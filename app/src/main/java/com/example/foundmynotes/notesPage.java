package com.example.foundmynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.Query;


public class notesPage extends AppCompatActivity {

    FloatingActionButton btnAddNote;
    RecyclerView recyclerView;
    ImageButton btnMenu;
    noteAdapter noteAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_page);

        btnAddNote = findViewById(R.id.btn_AddNote);
        recyclerView = findViewById(R.id.recyclerView);
        btnMenu = findViewById(R.id.btnMenuNotes);

        btnAddNote.setOnClickListener((v)->startActivity(new Intent(notesPage.this, noteDetailsActivity.class)));
        btnMenu.setOnClickListener((v)->showMenu());
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        Query query = Utility.getCollectionReferenceForNotes().orderBy("timestamp", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<Note> options = new FirestoreRecyclerOptions.Builder<Note>()
                .setQuery(query, Note.class).build();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter = new noteAdapter(options, this);
        recyclerView.setAdapter(noteAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        noteAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        noteAdapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteAdapter.notifyDataSetChanged();
    }

    void showMenu(){
        // Display Menu
    }
}