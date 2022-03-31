package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class PasswordReset extends AppCompatActivity {

    EditText password, user;
    Button submit;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);

        submit = findViewById(R.id.submit);
        password = findViewById(R.id.newpassword);
        user = findViewById(R.id.usertext);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String passTxt = password.getText().toString();
                String userTxt = user.getText().toString();

                if(passTxt.equals("") | userTxt.equals("") ) {
                    Toast.makeText(PasswordReset.this, "Please enter the information", Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference = FirebaseDatabase.getInstance().getReference("Users");
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            databaseReference.child(userTxt).child("Password").setValue(passTxt).toString();

                            Toast.makeText(PasswordReset.this, "Password Reset Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(PasswordReset.this, Login.class));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
    }
}