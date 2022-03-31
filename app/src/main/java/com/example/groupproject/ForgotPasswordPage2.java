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

public class ForgotPasswordPage2 extends AppCompatActivity {

    EditText answer;
    Button submit;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_page2);

        answer = findViewById(R.id.security);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String answerTxt = answer.getText().toString();

                if(answerTxt.equals("")) {
                    Toast.makeText(ForgotPasswordPage2.this, "Please enter your answer", Toast.LENGTH_SHORT).show();
                }
                else {

                    databaseReference = FirebaseDatabase.getInstance().getReference("Users");
                    Query securitycheck = databaseReference.orderByChild("Security Question").equalTo(answerTxt);
                    securitycheck.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                Toast.makeText(ForgotPasswordPage2.this, "Answer confirmed", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(ForgotPasswordPage2.this, PasswordReset.class));
                            }
                            else{
                                Toast.makeText(ForgotPasswordPage2.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();
                            }
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