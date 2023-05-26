package com.example.foundmynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Home extends AppCompatActivity implements View.OnClickListener {
    ImageButton createNotebtn, createReminderbtn, quizbtn, browseQuotebtn, createTaskbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

            createNotebtn = findViewById(R.id.create_note);
            createNotebtn.setOnClickListener(this);

            createReminderbtn = findViewById(R.id.create_reminder);
            createReminderbtn.setOnClickListener(this);

            quizbtn = findViewById(R.id.open_quiz);
            quizbtn.setOnClickListener(this);

            browseQuotebtn = findViewById(R.id.open_quote);
            browseQuotebtn.setOnClickListener(this);

            createTaskbtn = findViewById(R.id.create_task);
            createTaskbtn.setOnClickListener(this);
        }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.create_note:
                Intent notes = new Intent(this, notesPage.class);
                startActivity(notes);
                break;
            case R.id.create_reminder:
                Intent reminders = new Intent(this, RecyclerView_Reminders.class);
                startActivity(reminders);
                break;
            case R.id.open_quiz:
                Intent quiz = new Intent(this, Quiz.class);
                startActivity(quiz);
                break;
        }
    }
}
