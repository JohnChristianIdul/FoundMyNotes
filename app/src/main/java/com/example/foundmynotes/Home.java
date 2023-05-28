package com.example.foundmynotes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity implements View.OnClickListener {
    ImageButton  createNotebtn, createReminderbtn, quizbtn, browseQuotebtn,found_report, createTaskbtn,lost_report, create_lostReport, create_foundReport;
    Button deleteAccountbtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

            createNotebtn = findViewById(R.id.create_note);
            createNotebtn.setOnClickListener(this);

            deleteAccountbtn = findViewById(R.id.delete_account);
            deleteAccountbtn.setOnClickListener(this);

            createReminderbtn = findViewById(R.id.create_reminder);
            createReminderbtn.setOnClickListener(this);

            quizbtn = findViewById(R.id.open_quiz);
            quizbtn.setOnClickListener(this);

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
                Intent reminders = new Intent(this, Reminder.class);
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
            case R.id.open_quiz:
                Intent quiz = new Intent(this, Quiz.class);
                startActivity(quiz);
                break;
            case R.id.delete_account:
                deleteAccount();
                break;
        }
    }

    private void deleteAccount(){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        if (user != null) {
            user.delete()
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            // User account deleted successfully
                            Toast.makeText(Home.this, "Account deleted successfully", Toast.LENGTH_SHORT).show();
                            Intent delAccount= new Intent(Home.this, Login.class);
                            startActivity(delAccount);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Failed to delete user account
                        }
                    });
        }
    }

}
