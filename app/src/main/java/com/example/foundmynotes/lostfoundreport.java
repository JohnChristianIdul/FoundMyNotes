package com.example.foundmynotes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lostfoundreport extends AppCompatActivity {

    Button btnHome,btnStudy2,btnReport2,btnProfile2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHome= findViewById(R.id.btnHome);
        btnStudy2= findViewById(R.id.btnStudy2);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), Login.class);
                startActivity(login);
            }
        });

        btnStudy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), studyPage.class);
                startActivity(login);
            }
        });

        btnReport2= findViewById(R.id.btnReport2);
        btnReport2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), lostfoundreport.class);
                startActivity(login);
            }
        });

        btnProfile2= findViewById(R.id.btnProfile2);
        btnProfile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), lostfoundreport.class);
                startActivity(login);
            }
        });
    }
}
