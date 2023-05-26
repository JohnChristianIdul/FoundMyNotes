package com.example.foundmynotes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView_Reminders extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RemindersAdapter remindersAdapter;
    private List<Reminder> reminderList;

    private FirebaseFirestore firestore;
    private CollectionReference remindersCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_reminders);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        reminderList = new ArrayList<>();

        firestore = FirebaseFirestore.getInstance();
        remindersCollection = firestore.collection("reminders");

        loadReminders();
    }

    private void loadReminders() {
        Query query = remindersCollection.orderBy("title", Query.Direction.ASCENDING);

        query.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot querySnapshot = task.getResult();
                if (querySnapshot != null) {
                    for (Reminder reminder : querySnapshot.toObjects(Reminder.class)) {
                        reminderList.add(reminder);
                    }
                }
                remindersAdapter = new RemindersAdapter(RecyclerView_Reminders.this, reminderList);
                recyclerView.setAdapter(remindersAdapter);
            } else {
                // Handle error
            }
        });
    }
}
