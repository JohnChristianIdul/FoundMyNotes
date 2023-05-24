package com.example.foundmynotes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class reports extends AppCompatActivity implements View.OnClickListener {

    Button btnReport;
    private Uri imageUri;
    ImageView back;
    ArrayList<Uri> imageUriList;
    ArrayList<String> editTextsList;
    ArrayList<String> descriptionList;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.foundreports);

        linearLayout = findViewById(R.id.yourLinearLayoutId);
        int width = 500;
        int height = 500;
        int leftMargin = 0;
        int topMargin = 20;
        int rightMargin = 0;
        int bottomMargin = 0;

        back= findViewById(R.id.back);
        back.setOnClickListener(this);

        Intent intent = getIntent();
            imageUriList = intent.getParcelableArrayListExtra("imageUriList");
            editTextsList = intent.getStringArrayListExtra("Number");
            descriptionList = intent.getStringArrayListExtra("Description");
        if (imageUriList != null && editTextsList != null && descriptionList != null) {
            ImageView[] imageViews = new ImageView[imageUriList.size()];
            TextView[] editTexts = new TextView[imageUriList.size()];
            TextView[] description = new TextView[imageUriList.size()];

            for (int i = 0; i < imageUriList.size(); i++) {
                imageViews[i] = new ImageView(reports.this);
                editTexts[i] = new TextView(reports.this);
                description[i] = new TextView(reports.this);

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, height);
                layoutParams.gravity = Gravity.CENTER;
                layoutParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);

                imageViews[i].setLayoutParams(layoutParams);
                imageViews[i].setImageURI(imageUriList.get(i));


                editTexts[i].setText(editTextsList.get(i));
                editTexts[i].setGravity(Gravity.CENTER);

                description[i].setText(descriptionList.get(i));
                description[i].setGravity(Gravity.CENTER);

                linearLayout.addView(imageViews[i]);
                linearLayout.addView(editTexts[i]);
                linearLayout.addView(description[i]);
                saveData();
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.back:
                Intent intent = new Intent(this, Home.class);
                startActivity(intent);
                break;
        }
    }

    private void saveData() {
        // Save the image URIs and texts using SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        // Save image URIs
        Set<String> imageUriSet = new HashSet<>();
        for (Uri uri : imageUriList) {
            imageUriSet.add(uri.toString());
        }
        editor.putStringSet("ImageUris", imageUriSet);

        // Save texts
        Set<String> textsSet = new HashSet<>(editTextsList);
        editor.putStringSet("Texts", textsSet);

        // Save descriptions
        Set<String> descriptionsSet = new HashSet<>(descriptionList);
        editor.putStringSet("Descriptions", descriptionsSet);

        // Commit the changes
        editor.apply();
    }

}

