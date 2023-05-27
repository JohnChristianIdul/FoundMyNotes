//lostReports
package com.example.foundmynotes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lostReports extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private imageAdapter mAdapter;

    private DatabaseReference mDatabaseRef;
    private List<Upload> mUploads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagesactivity);

            mRecycleView = findViewById(R.id.recycler_View);
            mRecycleView.setHasFixedSize(true);
            mRecycleView.setLayoutManager(new LinearLayoutManager(this));

            mUploads = new ArrayList<>();

            mDatabaseRef = FirebaseDatabase.getInstance().getReference("Uploads");

            mDatabaseRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot postSnapshot : snapshot.getChildren()){
                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }
                    mAdapter = new imageAdapter(lostReports.this, mUploads);
                    mRecycleView.setAdapter(mAdapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(lostReports.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
            }
        }
