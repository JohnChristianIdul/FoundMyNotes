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

public class foundreport extends AppCompatActivity implements View.OnClickListener{

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
        setContentView(R.layout.createfoundreport);

        btnHome= findViewById(R.id.btnHome3);
        btnStudy2= findViewById(R.id.btnStudy3);
        btnReport2= findViewById(R.id.btnReport3);
        btnProfile2= findViewById(R.id.btnProfile3);

        image = findViewById(R.id.Image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE_REQUEST);
            }
        });

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
            case R.id.Profile2:
                Intent b= new Intent (this, lostreport.class);
                startActivity(b);
                break;
            case R.id.image:
                Intent intent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent1, PICK_IMAGE_REQUEST);
                break;
        }
    }
}
