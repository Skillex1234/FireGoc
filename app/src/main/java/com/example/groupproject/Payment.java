package com.example.groupproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Payment extends AppCompatActivity {
    TextView payment_tv, grandTotal;
    EditText cardHolderName, cvvNumber, cardNumber, expirationDate;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        //Setup firebase connection
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = firebaseDatabase.getReference();

        Bundle fromCart = getIntent().getExtras();
        String price = fromCart.getString("price");

        cardHolderName = findViewById(R.id.cardHolderName);
        cvvNumber = findViewById(R.id.cvvNumber);
        cardNumber = findViewById(R.id.cardNumber);
        expirationDate = findViewById(R.id.expirationDate);
        payment_tv = findViewById(R.id.payment_tv);
        submitButton = findViewById(R.id.submitButton);
        grandTotal = findViewById(R.id.textViewGrandTotal);

        expirationDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0 && (editable.length() % 3) == 0) {
                    final char c = editable.charAt(editable.length() - 1);
                    if ('/' == c) {
                        editable.delete(editable.length() - 1, editable.length());
                    }
                }
                if (editable.length() > 0 && (editable.length() % 3) == 0) {
                    char c = editable.charAt(editable.length() - 1);
                    if (Character.isDigit(c) && TextUtils.split(editable.toString(), String.valueOf("/")).length <= 2) {
                        editable.insert(editable.length() - 1, String.valueOf("/"));
                    }
                }
            }
        });

        grandTotal.setText("Grand Total: " + price);

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
            else if(userCardNum.length() != 16){
                Toast.makeText(Payment.this, "Please input valid card number", Toast.LENGTH_SHORT).show();
            }
            else if(userCVV.length() != 3){
                Toast.makeText(Payment.this, "Please input valid security code", Toast.LENGTH_SHORT).show();
            }
            else if(userexp.length() != 5 || Integer.valueOf(userexp.substring(0,2)) > 12 || Integer.valueOf(userexp.substring(3)) > 30
                        || Integer.valueOf(userexp.substring(3)) < 22 || (Integer.valueOf(userexp.substring(0,2)) < 5 && Integer.valueOf(userexp.substring(3)) == 22)){
                Toast.makeText(Payment.this, "Please input valid expiration date", Toast.LENGTH_SHORT).show();
            }
            else{
                AlertDialog alertDialog = new AlertDialog.Builder(Payment.this).create();
                alertDialog.setTitle("Checkout Successful");
                alertDialog.setMessage("Checkout success please check order history for details");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //Add to order history

                                DatabaseReference history = dbRef.child("Users").child(Login.username).child("Orders");

                                String orderNum = "Order" + (HomeScreen.orderList.size()+1);
                                String orderNameKey = history.push().getKey();

                                DatabaseReference historyItems = history.child(orderNum);
                                Map<String, Object> orderItems = new HashMap<>();
                                orderItems.put("Total", Double.valueOf(price.substring(1)));
                                historyItems.updateChildren(orderItems);
                                for(int i = 0; i < HomeScreen.ourList.getItemName().size(); i++){
                                    Map<String, Object> orderItemsLoop = new HashMap<>();
                                    String orderItemKey = historyItems.push().getKey();
                                    orderItemsLoop.put(orderItemKey, HomeScreen.ourList.getItemName().get(i) + ", " + HomeScreen.ourList.getItemQuantity().get(i));
                                    historyItems.updateChildren(orderItemsLoop);
                                }



                                HomeScreen.adapter.clearCart();

                                dialog.dismiss();
                                finish();
                            }
                        });
                alertDialog.show();
            }
        }
    });



    }

}