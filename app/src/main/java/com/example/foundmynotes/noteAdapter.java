package com.example.foundmynotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class noteAdapter extends FirestoreRecyclerAdapter <Note, noteAdapter.NoteViewHolder>{
    notesPage context;

    public noteAdapter(@NonNull FirestoreRecyclerOptions<Note> options, notesPage context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteViewHolder holder, int position, @NonNull Note note) {
        holder.titleView.setText(note.title);
        holder.contentView.setText(note.content);
        holder.timestampView.setText(Utility.timestampToString(note.timestamp));
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_note_items, parent, false);
        return new NoteViewHolder(view);
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView titleView, contentView, timestampView;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.Title_Note);
            contentView = itemView.findViewById(R.id.Content_Notes);
            timestampView = itemView.findViewById(R.id.time_stamp);
        }
    }
}
