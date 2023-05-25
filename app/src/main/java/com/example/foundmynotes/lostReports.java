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

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class lostReports extends AppCompatActivity implements View.OnClickListener {

    Button btnReport;
    private Uri imageUri;
    ImageView back;
    ArrayList<Uri> imageUriList = null;
    ArrayList<String> editTextsList= null;
    ArrayList<String> descriptionList= null;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lostreports);

        linearLayout = findViewById(R.id.yourLinearLayoutId1);
        int width = 500;
        int height = 500;
        int leftMargin = 0;
        int topMargin = 20;
        int rightMargin = 0;
        int bottomMargin = 0;

        back = findViewById(R.id.buttons);
        back.setOnClickListener(this);

        if(imageUriList != null){
            retrieveData();
        }

        imageUriList = new ArrayList<>();
        editTextsList = new ArrayList<>();
        descriptionList = new ArrayList<>();


        Intent intent = getIntent();
//        imageUriList = intent.getParcelableArrayListExtra("imageUriList");
//        editTextsList = intent.getStringArrayListExtra("Number");
//        descriptionList = intent.getStringArrayListExtra("Description");
        imageUriList.addAll(intent.getParcelableArrayListExtra("imageUriList"));
        editTextsList.addAll(intent.getStringArrayListExtra("Number"));
        descriptionList.addAll(intent.getStringArrayListExtra("Description"));

        if (imageUriList != null && editTextsList != null && descriptionList != null) {
            ImageView[] imageViews = new ImageView[imageUriList.size()];
            TextView[] editTexts = new TextView[imageUriList.size()];
            TextView[] description = new TextView[imageUriList.size()];

            for (int i = 0; i < imageUriList.size(); i++) {
                imageViews[i] = new ImageView(lostReports.this);
                editTexts[i] = new TextView(lostReports.this);
                description[i] = new TextView(lostReports.this);

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

                editTexts[i].setClickable(true);
                final int finalI = i; // Required for accessing in the OnClickListener
                editTexts[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String phoneNumber = (String) editTexts[finalI].getText();
                        Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", phoneNumber,null));
                        startActivity(intent1);
                    }
                });
                saveData();
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttons:
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

    private void retrieveData() {
        // Retrieve the saved preferences from SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Retrieve image URIs
        Set<String> imageUriSet = preferences.getStringSet("ImageUris", null);
        ArrayList<Uri> retrievedImageUriList = new ArrayList<>();
        if (imageUriSet != null) {
            for (String uriString : imageUriSet) {
                Uri uri = Uri.parse(uriString);
                retrievedImageUriList.add(uri);
            }
        }

        // Retrieve texts
        Set<String> textsSet = preferences.getStringSet("Texts", null);
        ArrayList<String> retrievedTextsList = new ArrayList<>();
        if (textsSet != null) {
            retrievedTextsList.addAll(textsSet);
        }

        // Retrieve descriptions
        Set<String> descriptionsSet = preferences.getStringSet("Descriptions", null);
        ArrayList<String> retrievedDescriptionsList = new ArrayList<>();
        if (descriptionsSet != null) {
            retrievedDescriptionsList.addAll(descriptionsSet);
        }
        int width = 500;
        int height = 500;
        int leftMargin = 0;
        int topMargin = 20;
        int rightMargin = 0;
        int bottomMargin = 0;
        // Use the retrieved data as needed in your application
        // For example, you can display the images and text in your layout


        ImageView[] imageView = new ImageView[retrievedImageUriList.size()];
        TextView[] textView = new TextView[retrievedImageUriList.size()];
        TextView[] textViews = new TextView[retrievedImageUriList.size()];

        for (int i = 0; i < retrievedImageUriList.size(); i++) {
            // Retrieve and display the image
            imageView[i] = new ImageView(lostReports.this);
            textView[i] = new TextView(lostReports.this);
            textViews[i] = new TextView(lostReports.this);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(500, 500);
            layoutParams.gravity = Gravity.CENTER;
            layoutParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);

            imageView[i].setLayoutParams(layoutParams);
            imageView[i].setImageURI(retrievedImageUriList.get(i));
            linearLayout.addView(imageView[i]);

            // Retrieve and display the text

            textView[i].setText(retrievedTextsList.get(i));
            textView[i].setGravity(Gravity.CENTER);
            linearLayout.addView(textView[i]);

            // Retrieve and display the description
            textViews[i].setText(retrievedDescriptionsList.get(i));
            textViews[i].setGravity(Gravity.CENTER);
            linearLayout.addView(textViews[i]);
        }
    }
}
