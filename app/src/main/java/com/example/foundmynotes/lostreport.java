//foundreport
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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class lostreport extends AppCompatActivity implements View.OnClickListener {
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

    Button  image, button;
    EditText number;
    String number1, description1;
    MultiAutoCompleteTextView description;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createlostreport);

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