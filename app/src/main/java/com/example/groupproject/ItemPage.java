package com.example.groupproject;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ItemPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] quantity = {"1","2","3","4","5","6","7","8","9"};

    ImageView image;
    TextView itemName;
    TextView price;
    TabLayout tabLayout;
    Spinner itemQuantity;
    Button addToCart;

    int itemAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);

        image = findViewById(R.id.imageViewItem);
        itemName = findViewById(R.id.textViewItemName);
        price = findViewById(R.id.textViewPrice);
        tabLayout = findViewById(R.id.tabLayout);
        itemQuantity = findViewById(R.id.spinnerQuantity);
        addToCart = findViewById(R.id.buttonAddToCart);

        //Set values for dropdown
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, quantity);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemQuantity.setAdapter(ad);
        itemQuantity.setOnItemSelectedListener(this);

        //Get info from bundle
        Bundle itemPage = getIntent().getExtras();
        String itemLoc = itemPage.getString("item_name");
        Bundle descriptionBundle = new Bundle();
        descriptionBundle.putString("itemLocation", itemLoc);
        Description desc = new Description();
        desc.setArguments(descriptionBundle);

        //Make the description tab content appear when the page is loaded
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutTabs, desc).commit();

        //show fragment based on what tab is selected
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String tabName = tab.getText().toString();
                switch(tabName){
                    case "Description" :
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutTabs, desc).commit();
                        break;
                    default :
                        getSupportFragmentManager().beginTransaction().remove(desc).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //Setup firebase connection
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = firebaseDatabase.getReference();

        //Set text for item name
        itemName.setText(itemPage.getString("item_name_with_spaces"));

        //Set text for price
        //price.setText(dbRef.child("Items").child(itemLoc).child("price").toString());

        //Get image from firebase
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

        //Add to cart button functionality
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cartPage = new Intent(ItemPage.this, Checkout.class);
                if(itemAmount > 0){
                    cartPage.putExtra("Amount", itemAmount);
                }
                startActivity(cartPage);
            }
        });

    }

    //store the value selected in a variable
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        String strAmt = parent.getItemAtPosition(position).toString();
        itemAmount = Integer.valueOf(strAmt);
    }

    public void onNothingSelected(AdapterView<?> parent){

    }



}