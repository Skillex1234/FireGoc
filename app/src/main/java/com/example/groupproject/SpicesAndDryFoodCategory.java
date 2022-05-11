package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class SpicesAndDryFoodCategory extends AppCompatActivity {

    ImageView cayenne;
    ImageView chili;
    ImageView cinna;
    ImageView redPep;
    ImageView garlic;
    ImageView pap;
    ImageView oregano;
    ImageView turmeric;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spices_and_dry_food_category);

        Bundle itemPage = getIntent().getExtras();
        ArrayList<String> itemNameList = itemPage.getStringArrayList("nameList");
        ArrayList<String> itemQuantityList = itemPage.getStringArrayList("qList");
        ArrayList<String> itemPriceList = itemPage.getStringArrayList("pList");

        cayenne = findViewById(R.id.cayenne);
        cayenne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Cayenne";
                String itemName = "Cayenne";
                Intent itemPage = new Intent(SpicesAndDryFoodCategory.this, ItemPage.class);
                Bundle extras = new Bundle();
                extras.putString("item_name", itemName);
                extras.putString("item_name_with_spaces", itemNameWithSpaces);
                extras.putStringArrayList("nameList", itemNameList);
                extras.putStringArrayList("qList", itemQuantityList);
                extras.putStringArrayList("pList", itemPriceList);
                itemPage.putExtras(extras);
                startActivity(itemPage);
                finish();
            }
        });

        chili = findViewById(R.id.chili);
        chili.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Chili Powder";
                String itemName = "ChiliPowder";
                Intent itemPage = new Intent(SpicesAndDryFoodCategory.this, ItemPage.class);
                Bundle extras = new Bundle();
                extras.putString("item_name", itemName);
                extras.putString("item_name_with_spaces", itemNameWithSpaces);
                extras.putStringArrayList("nameList", itemNameList);
                extras.putStringArrayList("qList", itemQuantityList);
                extras.putStringArrayList("pList", itemPriceList);
                itemPage.putExtras(extras);
                startActivity(itemPage);
                finish();
            }
        });

        cinna = findViewById(R.id.cinnamon);
        cinna.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Cinnamon";
                String itemName = "Cinnamon";
                Intent itemPage = new Intent(SpicesAndDryFoodCategory.this, ItemPage.class);
                Bundle extras = new Bundle();
                extras.putString("item_name", itemName);
                extras.putString("item_name_with_spaces", itemNameWithSpaces);
                extras.putStringArrayList("nameList", itemNameList);
                extras.putStringArrayList("qList", itemQuantityList);
                extras.putStringArrayList("pList", itemPriceList);
                itemPage.putExtras(extras);
                startActivity(itemPage);
                finish();
            }
        });

        redPep = findViewById(R.id.red);
        redPep.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Crushed Red Pepper";
                String itemName = "CrushedRedPepper";
                Intent itemPage = new Intent(SpicesAndDryFoodCategory.this, ItemPage.class);
                Bundle extras = new Bundle();
                extras.putString("item_name", itemName);
                extras.putString("item_name_with_spaces", itemNameWithSpaces);
                extras.putStringArrayList("nameList", itemNameList);
                extras.putStringArrayList("qList", itemQuantityList);
                extras.putStringArrayList("pList", itemPriceList);
                itemPage.putExtras(extras);
                startActivity(itemPage);
                finish();
            }
        });

        garlic = findViewById(R.id.garlic);
        garlic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Garlic";
                String itemName = "GarlicPowder";
                Intent itemPage = new Intent(SpicesAndDryFoodCategory.this, ItemPage.class);
                Bundle extras = new Bundle();
                extras.putString("item_name", itemName);
                extras.putString("item_name_with_spaces", itemNameWithSpaces);
                extras.putStringArrayList("nameList", itemNameList);
                extras.putStringArrayList("qList", itemQuantityList);
                extras.putStringArrayList("pList", itemPriceList);
                itemPage.putExtras(extras);
                startActivity(itemPage);
                finish();
            }
        });

        pap = findViewById(R.id.smoked);
        pap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Smoked Paprika";
                String itemName = "SmokedPaprika";
                Intent itemPage = new Intent(SpicesAndDryFoodCategory.this, ItemPage.class);
                Bundle extras = new Bundle();
                extras.putString("item_name", itemName);
                extras.putString("item_name_with_spaces", itemNameWithSpaces);
                extras.putStringArrayList("nameList", itemNameList);
                extras.putStringArrayList("qList", itemQuantityList);
                extras.putStringArrayList("pList", itemPriceList);
                itemPage.putExtras(extras);
                startActivity(itemPage);
                finish();
            }
        });

        oregano = findViewById(R.id.oregano);
        oregano.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Oregano";
                String itemName = "Oregano";
                Intent itemPage = new Intent(SpicesAndDryFoodCategory.this, ItemPage.class);
                Bundle extras = new Bundle();
                extras.putString("item_name", itemName);
                extras.putString("item_name_with_spaces", itemNameWithSpaces);
                extras.putStringArrayList("nameList", itemNameList);
                extras.putStringArrayList("qList", itemQuantityList);
                extras.putStringArrayList("pList", itemPriceList);
                itemPage.putExtras(extras);
                startActivity(itemPage);
                finish();
            }
        });

        turmeric = findViewById(R.id.Turmeric);
        turmeric.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Turmeric";
                String itemName = "Turmeric";
                Intent itemPage = new Intent(SpicesAndDryFoodCategory.this, ItemPage.class);
                Bundle extras = new Bundle();
                extras.putString("item_name", itemName);
                extras.putString("item_name_with_spaces", itemNameWithSpaces);
                extras.putStringArrayList("nameList", itemNameList);
                extras.putStringArrayList("qList", itemQuantityList);
                extras.putStringArrayList("pList", itemPriceList);
                itemPage.putExtras(extras);
                startActivity(itemPage);
                finish();
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
                startActivity(new Intent(SpicesAndDryFoodCategory.this, AboutUs.class));
                return true;
            case R.id.menuItemFAQ:
                startActivity(new Intent(SpicesAndDryFoodCategory.this, FAQ.class));
                return true;
            case R.id.menuItemLogout:
                Intent i = new Intent(SpicesAndDryFoodCategory.this, Login.class);
                HomeScreen.itemNameList.clear();
                HomeScreen.itemPriceList.clear();
                HomeScreen.itemQuantityList.clear();
                HomeScreen.adapter.clearItems();
                HomeScreen.favoriteItems.clear();
                HomeScreen.adapter.notifyDataSetChanged();
                finishAffinity();
                startActivity(i);
                return true;
            case R.id.menuItemCart:
                //figure what to pass since we're not adding an item
                Intent cartPage = new Intent(SpicesAndDryFoodCategory.this, Checkout.class);
                Bundle cartBundle = new Bundle();
                cartBundle.putString("Amount", "0");
                cartBundle.putString("itemName", "NO_ITEM");
                cartBundle.putString("noSpaces", "NO_ITEM");
                cartBundle.putString("price", "$ 0.00");
                cartBundle.putString("activity", "Category");
                cartBundle.putStringArrayList("nList", HomeScreen.itemNameList);
                cartBundle.putStringArrayList("pList", HomeScreen.itemPriceList);
                cartBundle.putStringArrayList("qList", HomeScreen.itemQuantityList);
                cartPage.putExtras(cartBundle);
                startActivity(cartPage);
                return true;
            case R.id.menuItemOrderHistory:
                startActivity(new Intent(SpicesAndDryFoodCategory.this, OrderHistory.class));
                return true;
            case R.id.menuItemFavorites:
                startActivity(new Intent(SpicesAndDryFoodCategory.this, FavoritesList.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}