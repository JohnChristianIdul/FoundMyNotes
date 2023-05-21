package com.example.foundmynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener {
    Button btnReport,Reports1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

            Reports1 = findViewById(R.id.Reports1);
             Reports1.setOnClickListener(this);
            btnReport= findViewById(R.id.btnReport);
            btnReport.setOnClickListener(this);
        }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnReport:
                Intent login = new Intent(getApplicationContext(), lostfoundreport.class);
                startActivity(login);
                break;
            case R.id.Reports1:
                Intent a = new Intent(getApplicationContext(), reports.class);
                startActivity(a);
                break;
        }
    }
}
