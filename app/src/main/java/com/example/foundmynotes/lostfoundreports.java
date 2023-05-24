package com.example.foundmynotes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lostfoundreports extends AppCompatActivity implements View.OnClickListener {
    Button fReports,lReports;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lostfoundreports);

        fReports = findViewById(R.id.fReports);
        fReports.setOnClickListener(this);

        lReports= findViewById(R.id.lReports);
        lReports.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
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
