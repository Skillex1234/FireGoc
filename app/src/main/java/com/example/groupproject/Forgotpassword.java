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

public class Forgotpassword extends AppCompatActivity
{

    EditText user, answer;
    Button submit;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        answer = findViewById(R.id.security);
        submit = findViewById(R.id.submit);
        user = findViewById(R.id.usertext);

        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                String userTxt = user.getText().toString();
                String answerTxt = answer.getText().toString();

                if(userTxt.equals("") | answerTxt.equals(""))
                {
                    Toast.makeText(Forgotpassword.this, "Please enter your username", Toast.LENGTH_SHORT).show();
                }
                else {


                    databaseReference = FirebaseDatabase.getInstance().getReference("Users");
                    Query usercheck = databaseReference.orderByChild("Username").equalTo(userTxt);
                    usercheck.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                String securityfromdatabase = snapshot.child(userTxt).child("Security Question").getValue(String.class);
                                if (securityfromdatabase.equals(answerTxt)) {
                                    Toast.makeText(Forgotpassword.this, "Information Confirmed", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Forgotpassword.this, PasswordReset.class));
                                }
                                else
                                {
                                    Toast.makeText(Forgotpassword.this, "Incorrect answer", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(Forgotpassword.this, "Incorrect username", Toast.LENGTH_SHORT).show();
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