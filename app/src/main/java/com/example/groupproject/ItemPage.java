package com.example.groupproject;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] quantity = new String[100];

    ImageView image;
    TextView itemName;
    TextView price;
    TabLayout tabLayout;
    Spinner itemQuantity;
    Button addToCart;
    ImageButton favorite;
    private boolean isFavorited;

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

        for(int i = 1; i < quantity.length+1; i++){
            quantity[i-1] = String.valueOf(i);
        }

        image = findViewById(R.id.imageViewItem);
        itemName = findViewById(R.id.textViewItemName);
        price = findViewById(R.id.textViewPrice);
        tabLayout = findViewById(R.id.tabLayout);
        itemQuantity = findViewById(R.id.spinnerQuantity);
        addToCart = findViewById(R.id.buttonAddToCart);
        favorite = findViewById(R.id.imageButtonFavorites);

        //add values to spinner
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

        if(HomeScreen.favoriteItems.contains(itemPage.getString("item_name_with_spaces"))){
            isFavorited = true;
            favorite.setImageResource(R.drawable.ic_baseline_star_24);
        }
        else{
            isFavorited = false;
        }

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
                cartBundle.putString("activity", "Item Page");
                cartBundle.putStringArrayList("nList", itemNameList);
                cartBundle.putStringArrayList("pList", itemPriceList);
                cartBundle.putStringArrayList("qList", itemQuantityList);
                cartPage.putExtras(cartBundle);
                startActivity(cartPage);
                finish();
            }
        });

        //Favorites list
        DatabaseReference favorites = dbRef.child("Users").child(Login.username).child("Favorites");


        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFavorited == true){
                    Query q = favorites.orderByChild(itemPage.getString("item_name_with_spaces")).equalTo(itemPage.getString("item_name_with_spaces"));
                    q.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            snapshot.getRef().removeValue();

                            int index = HomeScreen.favoriteItems.indexOf(itemPage.getString("item_name_with_spaces"));
                            HomeScreen.favoriteItems.remove(index);
                            for (int x = 0 ; x < HomeScreen.favoriteItems.size(); x++){
                                String keyFav = dbRef.child("Users").child(Login.username).child("Favorites").push().getKey();
                                Map<String, Object> favs = new HashMap<>();
                                favs.put(keyFav, HomeScreen.favoriteItems.get(x));
                                dbRef.child("Users").child(Login.username).child("Favorites").updateChildren(favs);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    favorite.setImageResource(R.drawable.ic_baseline_star_border_24);
                    isFavorited = false;
                }
                else{
                    String keyFav = dbRef.child("Users").child(Login.username).child("Favorites").push().getKey();
                    Map<String, Object> favs = new HashMap<>();
                    HomeScreen.favoriteItems.add(itemPage.getString("item_name_with_spaces"));
                    favorite.setImageResource(R.drawable.ic_baseline_star_24);
                    isFavorited = true;
                    favs.put(keyFav, itemPage.getString("item_name_with_spaces"));
                    dbRef.child("Users").child(Login.username).child("Favorites").updateChildren(favs);
                }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menuItemAboutUs:
                startActivity(new Intent(ItemPage.this, AboutUs.class));
                return true;
            case R.id.menuItemFAQ:
                startActivity(new Intent(ItemPage.this, FAQ.class));
                return true;
            case R.id.menuItemLogout:
                Intent i = new Intent(ItemPage.this, Login.class);
                HomeScreen.itemNameList.clear();
                HomeScreen.itemPriceList.clear();
                HomeScreen.itemQuantityList.clear();
                HomeScreen.adapter.clearItems();
                HomeScreen.favoriteItems.clear();
                HomeScreen.orderList.clear();
                HomeScreen.adapter.notifyDataSetChanged();
                finishAffinity();
                startActivity(i);
                return true;
            case R.id.menuItemCart:
                //figure what to pass since we're not adding an item
                Intent cartPage = new Intent(ItemPage.this, Checkout.class);
                Bundle cartBundle = new Bundle();
                cartBundle.putString("Amount", "0");
                cartBundle.putString("itemName", "NO_ITEM");
                cartBundle.putString("noSpaces", "NO_ITEM");
                cartBundle.putString("price", "$ 0.00");
                cartBundle.putString("activity", "itemPageCartButton");
                cartBundle.putStringArrayList("nList", HomeScreen.itemNameList);
                cartBundle.putStringArrayList("pList", HomeScreen.itemPriceList);
                cartBundle.putStringArrayList("qList", HomeScreen.itemQuantityList);
                cartPage.putExtras(cartBundle);
                startActivity(cartPage);
                return true;
            case R.id.menuItemOrderHistory:
                startActivity(new Intent(ItemPage.this, OrderHistory.class));
                return true;
            case R.id.menuItemFavorites:
                startActivity(new Intent(ItemPage.this, FavoritesList.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}