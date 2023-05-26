package com.example.foundmynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class studyPage extends AppCompatActivity {
    Button btnNoted, btnReminders;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_page);

        btnNoted = findViewById(R.id.btnNoted);
        btnNoted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), notesPage.class);
                startActivity(i);
            }
        });

        btnReminders = findViewById(R.id.btnReminders);
        btnReminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), reminder_activity.class);
                startActivity(i);
            }
        });

    }
}