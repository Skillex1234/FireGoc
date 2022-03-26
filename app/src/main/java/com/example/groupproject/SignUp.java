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
    
    EditText user, email, phone, password, firstname, lastname;
    Button signup;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        user = findViewById(R.id.user);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        signup = findViewById(R.id.signup);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userTxt = user.getText().toString();
                String emailTxt = email.getText().toString();
                String phoneTxt = phone.getText().toString();
                String passwordTxt = password.getText().toString();
                String firstnameTxt = firstname.getText().toString();
                String lastnameTxt = lastname.getText().toString();
                    
                if(userTxt.equals("") | passwordTxt.equals("") | phoneTxt.equals("") | emailTxt.equals("") | lastnameTxt.equals("")){
                    Toast.makeText(SignUp.this, "Please completely enter your information", Toast.LENGTH_SHORT).show();
                }

                else{

                    databaseReference = FirebaseDatabase.getInstance().getReference("Users");
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child(userTxt).child("Username").setValue(userTxt).toString();
                            databaseReference.child(userTxt).child("First Name").setValue(firstnameTxt).toString();
                            databaseReference.child(userTxt).child("Last Name").setValue(lastnameTxt).toString();
                            databaseReference.child(userTxt).child("Email").setValue(emailTxt).toString();
                            databaseReference.child(userTxt).child("Phone").setValue(phoneTxt).toString();
                            databaseReference.child(userTxt).child("Password").setValue(passwordTxt).toString();
                            Toast.makeText(SignUp.this, "Regristration Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUp.this, Login.class));
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