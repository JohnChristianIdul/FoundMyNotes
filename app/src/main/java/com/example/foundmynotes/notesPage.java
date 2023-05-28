package com.example.foundmynotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.Collections;


public class notesPage extends AppCompatActivity {
    FloatingActionButton btnAddNote;
    RecyclerView recyclerView;
//    ImageButton btnMenu;
    noteAdapter noteAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_page);

        btnAddNote = findViewById(R.id.btn_AddNote);
        recyclerView = findViewById(R.id.recyclerView);
//        btnMenu = findViewById(R.id.btnMenuNotes);
        btnAddNote.setOnClickListener((v)->startActivity(new Intent(notesPage.this, noteDetailsActivity.class)));
//        btnMenu.setOnClickListener((v)->showMenu());
        setupRecyclerView();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                        ItemTouchHelper.LEFT |ItemTouchHelper.RIGHT
        ){

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                Collections.swap(noteAdapter.getSnapshots(), viewHolder.getAdapterPosition(),target.getAdapterPosition());
                noteAdapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;
            }
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                if (direction == ItemTouchHelper.LEFT) {
                    noteAdapter.deleteItem(position);
                }
//                else {
//                    // Get the item from the dataset at the swiped position
//                    Note swipedItem = noteAdapter.getSnapshots().get(position);
//
//                    // Remove the item from its current position
//                    ArrayList<Note> dataset = new ArrayList<>(noteAdapter.getSnapshots());
//                    dataset.remove(position);
//
//                    // Add the item back to the top of the list
//                    dataset.add(0, swipedItem);
//
//                    // Update the adapter with the modified dataset
//                    noteAdapter.updateDataset(dataset);
//
//                    // Notify the adapter about the item changes
//                    noteAdapter.notifyItemMoved(position, 0);
//                } // crashes

            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void setupRecyclerView() {
        Query query = Utility.getCollectionReferenceForNotes().orderBy("timestamp", Query.Direction.DESCENDING);
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

//    void showMenu(){
//        // Display Menu
//        PopupMenu popupMenu  = new PopupMenu(notesPage.this,btnMenu);
//        popupMenu.getMenu().add("Logout");
//        popupMenu.show();
//        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                if(menuItem.getTitle()=="Logout"){
//                    FirebaseAuth.getInstance().signOut();
//                    startActivity(new Intent(notesPage.this,Login.class));
//                    finish();
//                    return true;
//                }
//                return false;
//            }
//        });
//    }
}