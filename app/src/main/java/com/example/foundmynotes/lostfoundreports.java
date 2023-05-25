package com.example.foundmynotes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lostfoundreports extends AppCompatActivity implements View.OnClickListener {
    Button fReports,lReports,a,b,c,d;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lostfoundreports);

        fReports = findViewById(R.id.fReports);
        fReports.setOnClickListener(this);

        lReports= findViewById(R.id.lReports);
        lReports.setOnClickListener(this);

        a = findViewById(R.id.a);
        a.setOnClickListener(this);
        b = findViewById(R.id.b);
        b.setOnClickListener(this);
        c = findViewById(R.id.c);
        c.setOnClickListener(this);
        d = findViewById(R.id.d);
        d.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.a:
                Intent intent = new Intent(this, Home.class);
                startActivity(intent);
                break;
            case R.id.b:
                Intent i = new Intent(this, studyPage.class);
                startActivity(i);
                break;
            case R.id.c:
                Intent a = new Intent(this, lostfoundreport.class);
                startActivity(a);
                break;
            case R.id.d:
                Intent b = new Intent(this, lostreport.class);
                startActivity(b);
                break;
            case R.id.fReports:
                Intent lfreports = new Intent(this, reports.class);
                startActivity(lfreports);
                break;
            case R.id.lReports:
                Intent lfreporst = new Intent(this, lostReports.class);
                startActivity(lfreporst);
                break;
        }
    }
}
