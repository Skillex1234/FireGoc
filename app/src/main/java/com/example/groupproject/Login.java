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

public class Login extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fire-groceries-514d0-default-rtdb.firebaseio.com/");
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
                else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(usertext)){
                                final String getpassword = snapshot.child(usertext).child("password").getValue(String.class);

                                if(getpassword.equals(usertext)){
                                    Toast.makeText(Login.this, "Successfully logged in", Toast.LENGTH_SHORT).show();

                                    startActivity(new Intent(Login.this, HomeScreen.class));
                                    finish();
                                }
                                else{
                                    Toast.makeText(Login.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(Login.this, "Wrong username", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, SignUp.class));

            }
        });
    }
}