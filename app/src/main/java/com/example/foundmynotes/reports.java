package com.example.foundmynotes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class reports extends AppCompatActivity implements View.OnClickListener {

    Button btnReport;
//    ImageView imageView4;
    private Uri imageUri;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lostreports);

        back= findViewById(R.id.back);
        back.setOnClickListener(this);
        Intent intent = getIntent();
        ArrayList<Uri> imageUriList = intent.getParcelableArrayListExtra("imageUriList");

        ImageView[] imageViews = new ImageView[imageUriList.size()];

        LinearLayout yourLinearLayoutId = findViewById(R.id.yourLinearLayoutId);
        int width = 500;
        int height = 500;
        int leftMargin = 0; // Adjust as needed
        int topMargin = 20; // Adjust as needed
        int rightMargin = 0; // Adjust as needed
        int bottomMargin = 0; // Adjust as needed


        for(int i=0; i< imageUriList.size(); i++){
            imageViews[i] = new ImageView(reports.this);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width,height);
            imageViews[i].setLayoutParams(layoutParams);
            layoutParams.gravity = Gravity.CENTER;
            layoutParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);
            imageViews[i].setImageURI(imageUriList.get(i));
            yourLinearLayoutId.addView(imageViews[i]);
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
}
