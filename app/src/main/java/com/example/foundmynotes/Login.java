package com.example.foundmynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText email, password;
    TextView signup;
    Button btnSignIn;
    CheckBox remember_me;
    DBConnect DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.tfemail_address_login);
        password = findViewById(R.id.tf_password_login);

        btnSignIn = findViewById(R.id.btnSignIn);
        signup = findViewById(R.id.tfSignUp);
        remember_me = findViewById(R.id.cbRemember);
        DB = new DBConnect(this);

//        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
//        String checkbox = preferences.getString("remember", "");
//
//        if (checkbox.equals(true)){
//            Intent i = new Intent(getApplicationContext(), splashScreen.class);
//            startActivity(i);
//        }else{
//            Toast.makeText(Login.this, "Please Sign In", Toast.LENGTH_SHORT).show();
//        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Create_Account = new Intent(getApplicationContext(), Signup.class);
                startActivity(Create_Account);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_login = email.getText().toString();
                String password_login = password.getText().toString();

                boolean check = DB.getUserData(email_login, password_login);
                Toast.makeText(Login.this, "" + check + "", Toast.LENGTH_SHORT).show();
                if(check){
                    Intent splash = new Intent(getApplicationContext(), splashScreen.class);
                    startActivity(splash);
                }
            }
        });

//        remember_me.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(remember_me.isChecked()){
//                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = preferences.edit();
//                    editor.putString("remember", "true");
//                    editor.apply();
//                    Toast.makeText(Login.this, "Checked", Toast.LENGTH_SHORT).show();
//                }else{
//                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = preferences.edit();
//                    editor.putString("remember", "false");
//                    editor.apply();
//                    Toast.makeText(Login.this, "Unchecked", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
}