package com.example.foundmynotes;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class reports extends AppCompatActivity {

    Button btnReport;
    ImageView imageView1;
    private Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lostreports);
        Intent intent = getIntent();
        imageUri = intent.getData();
        if(imageUri != null){
            Toast.makeText(reports.this, "Im in", Toast.LENGTH_SHORT).show();
//            ImageView imageView = new ImageView(reports.this);
            imageView1.setImageURI(imageUri);
//            imageView1.setLayoutParams(new ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.WRAP_CONTENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT
//            ));
        }else{
            Toast.makeText(reports.this, "Im out", Toast.LENGTH_SHORT).show();
        }
    }
}
