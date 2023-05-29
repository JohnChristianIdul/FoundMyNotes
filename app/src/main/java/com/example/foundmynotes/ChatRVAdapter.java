package com.example.foundmynotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

public class ChatRVAdapter extends RecyclerView.Adapter{
    private ArrayList<chatsModal> chatsModalsArrayList;
    private Context context;

    public ChatRVAdapter(ArrayList<chatsModal> chatsModalsArrayList, Context context) {
        this.chatsModalsArrayList = chatsModalsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch(viewType){
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_msg_rv,parent,false);
                return new UserViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_msg_rv,parent,false);
                return new BotViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        chatsModal chatsModal = chatsModalsArrayList.get(position);
        switch ((chatsModal.getSender())){
            case "user":
                ((UserViewHolder)holder).userTV.setText(chatsModal.getMessage());
                break;
            case "bot":
                ((BotViewHolder)holder).botmsgTV.setText((chatsModal.getMessage()));
                break;
        }
    }

    @Override
    public int getItemCount() {

        return chatsModalsArrayList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{
        TextView userTV;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userTV = itemView.findViewById(R.id.idUserMessage);
        }
    }

    public static class BotViewHolder extends RecyclerView.ViewHolder{
        TextView botmsgTV;
        public BotViewHolder(@NonNull View itemView) {
            super(itemView);
            botmsgTV = itemView.findViewById(R.id.idBotMessage);
        }
    }
}
