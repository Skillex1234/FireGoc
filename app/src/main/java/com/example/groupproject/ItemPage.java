package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ItemPage extends AppCompatActivity {

    ImageView image;
    TextView itemName;
    TextView itemDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);

        Bundle itemPage = getIntent().getExtras();
        String itemLoc = itemPage.getString("item_name");

        image = findViewById(R.id.imageViewItem);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = firebaseDatabase.getReference();

        itemName = findViewById(R.id.textViewItemName);
        itemDesc = findViewById(R.id.textViewItemDescription);

        itemName.setText(itemPage.getString("item_name_with_spaces"));

        DatabaseReference getDesc = dbRef.child("Items").child(itemLoc).child("Description");
        getDesc.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    DataSnapshot snapshot = task.getResult();
                    String text = snapshot.getValue(String.class);
                    itemDesc.setText(text);
                } else {
                    Toast.makeText(ItemPage.this, "Error Retrieving Description", Toast.LENGTH_SHORT).show();
                }
            }
        });

        DatabaseReference getImage = dbRef.child("Items").child(itemLoc).child("image");
        getImage.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String link = dataSnapshot.getValue(String.class);


                Picasso.get().load(link).into(image);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // we are showing that error message in toast
                Toast.makeText(ItemPage.this, "Error Loading Image", Toast.LENGTH_SHORT).show();
            }
        });


    }


}