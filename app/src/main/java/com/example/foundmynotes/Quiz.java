package com.example.foundmynotes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Quiz extends AppCompatActivity {

    Button btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4, btnAnswer5, btnAnswer6, btnAnswer7, btnAnswer8;
    TextView a1, a2, a3, a4, a5, a6, a7, a8;
    ImageButton back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        
        btnAnswer1 = findViewById(R.id.btnanswer_1);
        a1 = findViewById(R.id.answer_1);
        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a1.setVisibility(View.VISIBLE);
            }
        });

        btnAnswer2 = findViewById(R.id.btnanswer_2);
        a2 = findViewById(R.id.answer_2);
        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a2.setVisibility(View.VISIBLE);
            }
        });

        btnAnswer3 = findViewById(R.id.btnanswer_3);
        a3 = findViewById(R.id.answer_3);
        btnAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a3.setVisibility(View.VISIBLE);
            }
        });

        btnAnswer4 = findViewById(R.id.btnanswer_4);
        a4 = findViewById(R.id.answer_4);
        btnAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a4.setVisibility(View.VISIBLE);
            }
        });

        btnAnswer5 = findViewById(R.id.btnanswer_5);
        a5 = findViewById(R.id.answer_5);
        btnAnswer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a5.setVisibility(View.VISIBLE);
            }
        });

        btnAnswer6 = findViewById(R.id.btnanswer_6);
        a6 = findViewById(R.id.answer_6);
        btnAnswer6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a6.setVisibility(View.VISIBLE);
            }
        });

        btnAnswer7 = findViewById(R.id.btnanswer_7);
        a7 = findViewById(R.id.answer_7);
        btnAnswer7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a7.setVisibility(View.VISIBLE);
            }
        });

        btnAnswer8 = findViewById(R.id.btnanswer_8);
        a8 = findViewById(R.id.answer_8);
        btnAnswer8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a8.setVisibility(View.VISIBLE);
            }
        });
        
        
    }
}