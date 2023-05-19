package com.example.foundmynotes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class lostfoundreport extends AppCompatActivity implements View.OnClickListener{

    Button Home2,Study2,Report2,Profile2,btnLost,btnFound;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lostfoundreport);

        Home2= findViewById(R.id.Home2);
        Home2.setOnClickListener(this);
        Study2= findViewById(R.id.Study2);
        Study2.setOnClickListener(this);
        Report2= findViewById(R.id.Report2);
        Report2.setOnClickListener(this);
        btnLost= findViewById(R.id.btnLost);
        btnLost.setOnClickListener(this);
        btnFound= findViewById(R.id.btnFound);
        btnFound.setOnClickListener(this);
//        Profile2= findViewById(R.id.Profile2);
//        Profile2.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnHome:
                Intent intent = new Intent (this, Home.class);
                startActivity(intent);
                break;
            case R.id.Study2:
                Intent i = new Intent (this, studyPage.class);
                startActivity(i);
                break;
            case R.id.Report2:
                Intent a = new Intent (this, lostfoundreport.class);
                startActivity(a);
                break;
//            case R.id.btnProfile2:
//                Intent b= new Intent (this, lostreport.class);
//                startActivity(b);
//                break;
            case R.id.btnLost:
                Intent ab= new Intent (this, lostreport.class);
                startActivity(ab);
                break;
            case R.id.btnFound:
                Intent abc= new Intent (this, foundreport.class);
                startActivity(abc);
                break;
        }
    }
}
