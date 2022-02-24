package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText user = findViewById(R.id.user);
        EditText pass = findViewById(R.id.pass);
        Button signin = findViewById(R.id.signin);
        TextView register = findViewById(R.id.register);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usertext = user.getText().toString();
                String passtext = pass.getText().toString();

                if(usertext.isEmpty() || passtext.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "please enter your username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));

            }
        });
    }
}