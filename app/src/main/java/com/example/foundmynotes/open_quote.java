package com.example.foundmynotes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class open_quote extends AppCompatActivity {

    private TextView textView;
    private Button generateButton;
    private String[] texts = {
            "\"The more that you read, the more things you will know. The more that you learn, the more places you'll go.\" - Dr. Seuss",
            "\"Education is the most powerful weapon which you can use to change the world.\" - Nelson Mandela",
            "\"The beautiful thing about learning is that no one can take it away from you.\" - B.B. King",
            "\"The capacity to learn is a gift; the ability to learn is a skill; the willingness to learn is a choice.\" - Brian Herbert",
            "\"Learning is not attained by chance, it must be sought for with ardor and attended to with diligence.\" - Abigail Adams",
            "\"The more I live, the more I learn. The more I learn, the more I realize, the less I know.\" - Michel Legrand"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_quote);

        textView = findViewById(R.id.quote_box);
        generateButton = findViewById(R.id.generate);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Generate and set new text
                String newText = generateText();
                textView.setText(newText);
            }
        });
    }

    private String generateText() {
        Random random = new Random();
        int index = random.nextInt(texts.length);

        // Return the randomly selected text
        return texts[index];
    }
}