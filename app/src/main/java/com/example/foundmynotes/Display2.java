package com.example.foundmynotes;

import static com.example.foundmynotes.R.id.textView4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Display2 extends AppCompatActivity{
TextView textView;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display2);

        textView = findViewById(textView4);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = (String)  textView.getText();
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", phoneNumber,null));
                startActivity(intent1);
            }
        });
    }


}
