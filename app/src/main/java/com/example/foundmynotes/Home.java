package com.example.foundmynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Home extends AppCompatActivity implements View.OnClickListener {
    Button btnReport;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

            imageView = findViewById(R.id.imageView);
            imageView.setOnClickListener(this);

            btnReport= findViewById(R.id.btnReport);
            btnReport.setOnClickListener(this);
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
        }
    }
}
