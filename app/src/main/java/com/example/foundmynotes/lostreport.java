package com.example.foundmynotes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class lostreport extends AppCompatActivity {

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            // Perform further processing or upload operations with the selected image URI
            // For example, you can display the image in an ImageView or upload it to a server.
            ImageView image = findViewById(R.id.image);
            image.setImageURI(imageUri);
        }
    }
    Button btnHome,btnStudy2,btnReport2,btnProfile2,image;
    private static final int PICK_IMAGE_REQUEST = 1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createlostreport);

        btnHome= findViewById(R.id.btnHome3);
        btnStudy2= findViewById(R.id.btnStudy3);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), Login.class);
                startActivity(login);
            }
        });

        btnStudy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), studyPage.class);
                startActivity(login);
            }
        });

        btnReport2= findViewById(R.id.btnReport3);
        btnReport2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), lostfoundreport.class);
                startActivity(login);
            }
        });

        btnProfile2= findViewById(R.id.btnProfile3);
        btnProfile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), lostfoundreport.class);
                startActivity(login);
            }
        });

        image = findViewById(R.id.Image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE_REQUEST);
            }
        });



    }
}
