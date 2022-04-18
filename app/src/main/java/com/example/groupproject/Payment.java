package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {
    TextView payment_tv;
    EditText cardHolderName, cvvNumber, cardNumber, expirationDate;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        cardHolderName = findViewById(R.id.cardHolderName);
        cvvNumber = findViewById(R.id.cvvNumber);
        cardNumber = findViewById(R.id.cardNumber);
        expirationDate = findViewById(R.id.expirationDate);
        payment_tv = findViewById(R.id.payment_tv);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            String userCard = cardHolderName.getText().toString();
            String userCVV = cvvNumber.getText().toString();
            String userCardNum = cardNumber.getText().toString();
            String userexp = expirationDate.getText().toString();

            if (userCard.equals("") | userCVV.equals("") | userCardNum.equals("") | userexp.equals("")) {
                Toast.makeText(Payment.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(Payment.this, "Payment Successfully added!", Toast.LENGTH_SHORT).show();
            }

            finish();
        }
    });

    }
}