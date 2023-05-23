package com.example.foundmynotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signup extends AppCompatActivity {
    EditText email, password, confirm_password;
    TextView Login;
    Button SignUp;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        progressBar = findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.tfemail_address);
        password = findViewById(R.id.tfpassword);
        confirm_password = findViewById(R.id.tfconfirmpassword);

        SignUp = findViewById(R.id.btnSignUp);
        Login = findViewById(R.id.tfLogin);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email_text = email.getText().toString();
                String password_text = password.getText().toString();
                String confirm_password_text = confirm_password.getText().toString();

                if(!password_text.equals(confirm_password_text)){
                    Toast.makeText(Signup.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    confirm_password.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(email_text)){
                    Toast.makeText(Signup.this, "Email is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password_text)){
                    Toast.makeText(Signup.this, "Password is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(confirm_password_text)){
                    Toast.makeText(Signup.this, "Please confirm password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email_text, password_text)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(Signup.this, "Successfully created.",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Signup.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}