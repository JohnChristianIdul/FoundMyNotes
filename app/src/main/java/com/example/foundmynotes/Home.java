package com.example.foundmynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Home extends AppCompatActivity implements View.OnClickListener {
    ImageButton createNotebtn, createReminderbtn, quizbtn, browseQuotebtn,found_report, createTaskbtn,lost_report, create_lostReport, create_foundReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

            createNotebtn = findViewById(R.id.create_note);
            createNotebtn.setOnClickListener(this);

            createReminderbtn = findViewById(R.id.create_reminder);
            createReminderbtn.setOnClickListener(this);

//            quizbtn = findViewById(R.id.open_quiz);
//            quizbtn.setOnClickListener(this);

            browseQuotebtn = findViewById(R.id.open_quote);
            browseQuotebtn.setOnClickListener(this);

            createTaskbtn = findViewById(R.id.create_task);
            createTaskbtn.setOnClickListener(this);

        create_lostReport = findViewById(R.id.create_lostReport);
        create_lostReport.setOnClickListener(this);

        create_foundReport = findViewById(R.id.create_foundReport);
        create_foundReport.setOnClickListener(this);

        lost_report = findViewById(R.id.lost_report);
        lost_report.setOnClickListener(this);

        found_report = findViewById(R.id.found_report);
        found_report.setOnClickListener(this);
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
            case R.id.found_report:
                Intent found_report = new Intent(this, reports.class);
                startActivity(found_report);
                break;
            case R.id.lost_report:
                Intent lost_report = new Intent(this, lostReports.class);
                startActivity(lost_report);
                break;
            case R.id.create_foundReport:
                Intent create_foundReport = new Intent(this, foundreport.class);
                startActivity(create_foundReport);
                break;
            case R.id.create_lostReport:
                Intent create_lostReport = new Intent(this, lostreport.class);
                startActivity(create_lostReport);
                break;
//            case R.id.open_quiz:
//                Intent quiz = new Intent(this, Quiz.class);
//                startActivity(quiz);
//                break;
        }
    }
}
