package com.example.foundmynotes;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Reminders extends AppCompatActivity {

    private EditText reminderTitleEditText;
    private EditText reminderContentEditText;
    private ImageButton saveReminderButton;
    private TextView deleteReminderTextView;

    private FirebaseFirestore firestore;

    private String reminderId;
    private boolean isEditable = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);

        reminderTitleEditText = findViewById(R.id.notes_title_text);
        reminderContentEditText = findViewById(R.id.notes_content_text);
        saveReminderButton = findViewById(R.id.btnSaveReminder);
        deleteReminderTextView = findViewById(R.id.delete_note);

        firestore = FirebaseFirestore.getInstance();

        // Get the reminder ID from the previous activity or wherever it is passed
        reminderId = getIntent().getStringExtra("reminderId");

        saveReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveReminder();
            }
        });

        deleteReminderTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteReminder();
            }
        });

        // Disable editing if the reminder is not editable
        if (!isEditable) {
            reminderTitleEditText.setEnabled(false);
            reminderContentEditText.setEnabled(false);
            saveReminderButton.setVisibility(View.GONE);
        }
    }

    private void saveReminder() {
        String title = reminderTitleEditText.getText().toString();
        String content = reminderContentEditText.getText().toString();

        if (title.isEmpty()) {
            reminderTitleEditText.setError("Please enter a title");
            return;
        }

        if (content.isEmpty()) {
            reminderContentEditText.setError("Please enter a description");
            return;
        }

        // Create a new reminder object
        Map<String, Object> reminder = new HashMap<>();
        reminder.put("title", title);
        reminder.put("content", content);
        reminder.put("editable", isEditable);

        // Add the reminder to Firebase Firestore or update it if already exists
        DocumentReference reminderRef = firestore.collection("reminders").document(reminderId);
        reminderRef.set(reminder)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Reminders.this, "Reminder saved successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(Reminders.this, "Failed to save reminder", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void deleteReminder() {
        firestore.collection("reminders").document(reminderId)
                .delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Reminders.this, "Reminder deleted successfully", Toast.LENGTH_SHORT).show();
                            playRingtone();
                            finish();
                        } else {
                            Toast.makeText(Reminders.this, "Failed to delete reminder", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void playRingtone() {
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), notification);
            ringtone.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
