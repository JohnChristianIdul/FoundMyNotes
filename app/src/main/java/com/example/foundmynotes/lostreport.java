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

public class lostreport extends AppCompatActivity implements View.OnClickListener{

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
    Button a1,b1,c1,d1,Image1;
    private static final int PICK_IMAGE_REQUEST = 1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createlostreport);

        a1= findViewById(R.id.a1);
        a1.setOnClickListener(this);
        b1= findViewById(R.id.b1);
        b1.setOnClickListener(this);
        c1= findViewById(R.id.c1);
        c1.setOnClickListener(this);
//        btnProfile2= findViewById(R.id.d);
//        btnProfile2.setOnClickListener(this);
        Image1 = findViewById(R.id.Image1);
        Image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent1, PICK_IMAGE_REQUEST);
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.a1:
                Intent intent = new Intent (this, Home.class);
                startActivity(intent);
                break;
            case R.id.b1:
                Intent i = new Intent (this, studyPage.class);
                startActivity(i);
                break;
            case R.id.c1:
                Intent a = new Intent (this, lostfoundreport.class);
                startActivity(a);
                break;
            case R.id.d1:
                Intent b= new Intent (this, lostreport.class);
                startActivity(b);
                break;

        }
    }
}
