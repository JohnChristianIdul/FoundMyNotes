package com.example.foundmynotes;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;

public class splashScreen extends AppCompatActivity {

    private static final int SPLASH_DELAY = 1000; // 1 second delay

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Delay for 1 second and then start the main activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashScreen.this, Home.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DELAY);
    }
}