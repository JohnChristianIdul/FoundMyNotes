package com.example.foundmynotes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class foundreport extends AppCompatActivity implements View.OnClickListener {
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri imageUri;
    List<Uri> imageUriList = new ArrayList<>();
    List<String> stringList = new ArrayList<>();
    List<String> descriptionList = new ArrayList<>();

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            imageUriList.add(imageUri);
            ImageView image = findViewById(R.id.image);
            image.setImageURI(imageUri);
        }
    }

    Button a, b, c, d, image, button;
    EditText number;
    String number1, description1;
    MultiAutoCompleteTextView description;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createfoundreport);

        a = findViewById(R.id.a1);
        a.setOnClickListener(this);
        b = findViewById(R.id.b1);
        b.setOnClickListener(this);
        c = findViewById(R.id.c1);
        c.setOnClickListener(this);
        d = findViewById(R.id.d1);
        d.setOnClickListener(this); // Make sure to define the button with id "d1" in your layout file
        image = findViewById(R.id.Image1);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent1, PICK_IMAGE_REQUEST);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.a1:
                Intent intent = new Intent(this, Home.class);
                startActivity(intent);
                break;
            case R.id.b1:
                Intent i = new Intent(this, studyPage.class);
                startActivity(i);
                break;
            case R.id.c1:
                Intent a = new Intent(this, lostfoundreport.class);
                startActivity(a);
                break;
            case R.id.d1:
                Intent b = new Intent(this, lostreport.class);
                startActivity(b);
                break;
            case R.id.button:
                number = findViewById(R.id.number);
                number1 = number.getText().toString();
                description = findViewById(R.id.description);
                description1 = description.getText().toString();

                descriptionList.add(description1);
                stringList.add(number1);

                Intent z = new Intent(this, reports.class);
                z.putParcelableArrayListExtra("imageUriList", new ArrayList<>(imageUriList));
                z.putExtra("Number", new ArrayList<>(stringList));
                z.putExtra("Description", new ArrayList<>(descriptionList));
                startActivity(z);
                break;
        }
    }
}
