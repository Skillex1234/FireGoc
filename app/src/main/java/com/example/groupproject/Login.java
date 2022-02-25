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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    Button signin;
    EditText user, pass;
    TextView register;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        signin = findViewById(R.id.signin);
        register = findViewById(R.id.register);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userTxt = user.getText().toString();
                String passwordTxt = pass.getText().toString();

                if(userTxt.equals("") | passwordTxt.equals("")){
                    Toast.makeText(Login.this, "Please enter your username or password", Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference = FirebaseDatabase.getInstance().getReference("Users");
                    Query usercheck = databaseReference.orderByChild("Username").equalTo(userTxt);
                    usercheck.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                String passfromdatabase = snapshot.child(userTxt).child("Password").getValue(String.class);
                                if(passfromdatabase.equals(passwordTxt)){
                                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Login.this, HomeScreen.class));


                                }
                                else{
                                    Toast.makeText(Login.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(Login.this, "User does not exists", Toast.LENGTH_SHORT).show();
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