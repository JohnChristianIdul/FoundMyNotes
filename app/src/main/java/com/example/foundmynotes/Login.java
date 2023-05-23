package com.example.foundmynotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText email, password;
    TextView signup;
    Button btnSignIn;
    CheckBox remember_me;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.tfemail_address_login);
        password = findViewById(R.id.tf_password_login);

        progressBar = findViewById(R.id.progressBar);
        btnSignIn = findViewById(R.id.btnSignIn);
        signup = findViewById(R.id.tfSignUp);
        remember_me = findViewById(R.id.cbRemember);

        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember", "");
        boolean check = checkbox.equals(true);

        if (check) {
            Intent i = new Intent(getApplicationContext(), splashScreen.class);
            startActivity(i);
        } else {
            Toast.makeText(Login.this, "Please Sign In", Toast.LENGTH_SHORT).show();
        }

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

                mAuth.signInWithEmailAndPassword(email_login, password_login)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(Login.this, "Success!",
                                            Toast.LENGTH_SHORT).show();
                                    Intent Splash = new Intent(getApplicationContext(), splashScreen.class);
                                    startActivity(Splash);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        remember_me.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(remember_me.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                    Toast.makeText(Login.this, "Checked", Toast.LENGTH_SHORT).show();
                }else{
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                    Toast.makeText(Login.this, "Unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}