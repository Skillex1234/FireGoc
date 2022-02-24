package com.example.groupproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText user = findViewById(R.id.user);
        final EditText email = findViewById(R.id.email);
        final EditText phone = findViewById(R.id.phone);
        final EditText password = findViewById(R.id.password);
        final EditText confirm_password = findViewById(R.id.confirm_pass);

        final Button signup = findViewById(R.id.signup);


            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String userTxt = user.getText().toString();
                    final String emailTxt = email.getText().toString();
                    final String phoneTxt = phone.getText().toString();
                    final String passwordTxt = password.getText().toString();
                    final String confirm_passwordTxt = confirm_password.getText().toString();

                    if(userTxt.isEmpty()||emailTxt.isEmpty()|| phoneTxt.isEmpty()||passwordTxt.isEmpty()||confirm_passwordTxt.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                    }
                    else if(!phoneTxt.equals(confirm_passwordTxt)){
                        Toast.makeText(getApplicationContext(), "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                    else {

                    }
                }
            });

    }
}