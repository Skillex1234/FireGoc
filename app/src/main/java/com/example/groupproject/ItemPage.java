package com.example.groupproject;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
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

import java.util.ArrayList;
import java.util.List;

public class ItemPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] quantity = {"1","2","3","4","5","6","7","8","9"};

    ImageView image;
    TextView itemName;
    TextView price;
    TabLayout tabLayout;
    Spinner itemQuantity;
    Button addToCart;

    String itemAmount;
    int numItems;

    public static List<ReviewItem> revList = new ArrayList<>();
    public static DatabaseReference itemScore;
    public static DatabaseReference itemRevText;
    public static ArrayList<String> scores = new ArrayList<>();
    public static ArrayList<String> revs = new ArrayList<>();

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
        getReviewInfo(itemLoc);
        Bundle locationBundle = new Bundle();
        locationBundle.putString("itemLocation", itemLoc);
        Description desc = new Description();
        desc.setArguments(locationBundle);
        NutritionFacts nf = new NutritionFacts();
        nf.setArguments(locationBundle);
        Recipes rp = new Recipes();
        Reviews rv = new Reviews();
        rv.setArguments(locationBundle);

        ArrayList<String> itemNameList = itemPage.getStringArrayList("nameList");
        ArrayList<String> itemQuantityList = itemPage.getStringArrayList("qList");
        ArrayList<String> itemPriceList = itemPage.getStringArrayList("pList");

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
                    case "Nutrition Facts" :
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutTabs, nf).commit();
                        break;
                    case "Recipes" :
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutTabs, rp).commit();
                        break;
                    case "Reviews" :
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutTabs, rv).commit();
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
        DatabaseReference getPrice = dbRef.child("Items").child(itemLoc).child("price");
        getPrice.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){
                    DataSnapshot snapshot = task.getResult();
                    String text = snapshot.getValue(Double.class).toString();
                    price.setText("$ " + text);
                }
                else{
                    Toast.makeText(ItemPage.this, "Error Retrieving Price", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Get image from firebase
        DatabaseReference getImage = dbRef.child("Items").child(itemLoc).child("Image");
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
                Bundle cartBundle = new Bundle();
                if(numItems > 0){
                    cartBundle.putString("Amount", itemAmount);
                }
                cartBundle.putString("itemName", itemName.getText().toString());
                cartBundle.putString("noSpaces", itemLoc);
                cartBundle.putString("price", price.getText().toString());
                cartBundle.putStringArrayList("nList", itemNameList);
                cartBundle.putStringArrayList("pList", itemPriceList);
                cartBundle.putStringArrayList("qList", itemQuantityList);
                cartPage.putExtras(cartBundle);
                startActivity(cartPage);
            }
        });

    }

    //store the value selected in a variable
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
        itemAmount = parent.getItemAtPosition(position).toString();
        numItems = Integer.valueOf(itemAmount);
    }

    public void onNothingSelected(AdapterView<?> parent){

    }

@Override
    public void onBackPressed(){
        revList.clear();
        scores.clear();
        revs.clear();
        super.onBackPressed();
}

public void getReviewInfo(String itemName){
    FirebaseDatabase db;
    DatabaseReference dbRef;
    db = FirebaseDatabase.getInstance();
    dbRef = db.getReference();
    itemScore = dbRef.child("Items").child(itemName).child("reviewScoreList");
    itemScore.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            for(DataSnapshot ds : snapshot.getChildren()){
                String score = ds.getValue(Long.class).toString();
                scores.add(score);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });
    itemRevText = dbRef.child("Items").child(itemName).child("reviewTextList");
    itemRevText.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            for(DataSnapshot ds : snapshot.getChildren()){
                String rev = ds.getValue(String.class);
                revs.add(rev);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });
}

}