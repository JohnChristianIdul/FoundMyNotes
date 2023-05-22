package com.example.foundmynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText name, email, password, confirm_password;
    TextView Login;
    Button SignUp;
    DBConnect DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.tfname);
        email = findViewById(R.id.tfemail_address);
        password = findViewById(R.id.tfpassword);
        confirm_password = findViewById(R.id.tfconfirmpassword);

        SignUp = findViewById(R.id.btnSignUp);
        Login = findViewById(R.id.tfLogin);
        DB = new DBConnect(this);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_text = name.getText().toString();
                String email_text = email.getText().toString();
                String password_text = password.getText().toString();
                String confirm_password_text = confirm_password.getText().toString();

                if(!password_text.equals(confirm_password_text)){
                    Toast.makeText(Signup.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    confirm_password.requestFocus();
                    return;
                }

                boolean checkInserted = DB.insertUserData(name_text, email_text, password_text);
                if(checkInserted){
                    Toast.makeText(Signup.this, "Successful", Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(getApplicationContext(), Login.class);
                    startActivity(login);
                }else{
                    Toast.makeText(Signup.this, "Check your input", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}