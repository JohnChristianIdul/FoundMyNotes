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

            imageView = findViewById(R.id.imageView);
            imageView.setOnClickListener(this);

            btnReport= findViewById(R.id.btnReport);
            btnReport.setOnClickListener(this);

            createNotebtn = findViewById(R.id.create_note);
            createNotebtn.setOnClickListener(this);

            createReminderbtn = findViewById(R.id.create_reminder);
            createReminderbtn.setOnClickListener(this);

            quizbtn = findViewById(R.id.quiz)
                    browseQuotebtn
                    createTaskbtn
        }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnReport:
                Intent login = new Intent(this, lostfoundreport.class);
                startActivity(login);
                break;
            case R.id.imageView:
                Intent a = new Intent(this, lostfoundreports.class);
                startActivity(a);
                break;
            case R.id.imgNotes:
            case R.id.imageOver:
                Intent notes = new Intent(this, studyPage.class);
                startActivity(notes);
                break;

        }
    }
}
