package com.example.foundmynotes;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChatBot extends AppCompatActivity {
    private RecyclerView rcChat;
    private EditText userMsgEdt;
    private FloatingActionButton sendMsgFab;
    private final String BOT_KEY = "bot";
    private final String USER_KEY = "user";
    private ArrayList<chatsModal> chatsModalArrayList;
    private ChatRVAdapter chatRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatbot);

        rcChat = findViewById(R.id.rcChat);
        userMsgEdt = findViewById(R.id.idText);
        sendMsgFab = findViewById(R.id.idButton);

        chatsModalArrayList = new ArrayList<>();
        chatRVAdapter = new ChatRVAdapter(chatsModalArrayList,this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rcChat.setLayoutManager(manager);
        rcChat.setAdapter(chatRVAdapter);

        sendMsgFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userMsgEdt.getText().toString().isEmpty()){
                    Toast.makeText(ChatBot.this, "Please enter your message", Toast.LENGTH_SHORT).show();
                    return;
                }
                getResponse(userMsgEdt.getText().toString());
                userMsgEdt.setText("");
            }
        });

    }
    private void getResponse(String message){
        chatsModalArrayList.add(new chatsModal(message,USER_KEY));
        chatRVAdapter.notifyDataSetChanged();
        String url = "http://api.brainshop.ai/get?bid=175658&key=ivUNj8YaDgSttwkY&uid=[uid]&msg="+message;
        String BASE_URL = "http://api.brainshop.ai/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitAPI retrofitAPI = retrofit.create(retrofitAPI.class);
        Call<msgModal> call = retrofitAPI.getMessage(url);
        call.enqueue(new Callback<msgModal>() {
            @Override
            public void onResponse(Call<msgModal> call, Response<msgModal> response) {
                if(response.isSuccessful()){
                    msgModal modal = response.body();
                    chatsModalArrayList.add( new chatsModal(modal.getCnt(), BOT_KEY));
                    chatRVAdapter.notifyDataSetChanged();
            }
    }

            @Override
            public void onFailure(Call<msgModal> call, Throwable t) {
                chatsModalArrayList.add(new chatsModal("Please revert your question", BOT_KEY));
                chatRVAdapter.notifyDataSetChanged();
            }
        });
}
}