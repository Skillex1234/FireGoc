package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fire-groceries-514d0-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

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
                    else if(!passwordTxt.equals(confirm_passwordTxt)){
                        Toast.makeText(getApplicationContext(), "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                    else {

                        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.hasChild(userTxt)){
                                    Toast.makeText(SignUp.this, "this username is already used", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    databaseReference.child("users").child(userTxt).child("username").setValue(userTxt);
                                    databaseReference.child("users").child(userTxt).child("email").setValue(emailTxt);
                                    databaseReference.child("users").child(userTxt).child("password").setValue(passwordTxt);
                                    databaseReference.child("users").child(userTxt).child("phone").setValue(phoneTxt);

                                    Toast.makeText(SignUp.this, "user registered", Toast.LENGTH_SHORT).show();
                                    finish();
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                    }
                }
            });
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

    }
}