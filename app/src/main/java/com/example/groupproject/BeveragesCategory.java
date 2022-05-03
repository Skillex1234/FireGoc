package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class BeveragesCategory extends AppCompatActivity {

    ImageView coke;
    ImageView greenTea;
    ImageView icedTea;
    ImageView water;
    ImageView aj;
    ImageView sparkWater;
    ImageView oj;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverages_category);

        Bundle itemPage = getIntent().getExtras();
        ArrayList<String> itemNameList = itemPage.getStringArrayList("nameList");
        ArrayList<String> itemQuantityList = itemPage.getStringArrayList("qList");
        ArrayList<String> itemPriceList = itemPage.getStringArrayList("pList");

        coke = findViewById(R.id.coke);
        coke.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Coca-Cola";
                String itemName = "coke";
                Intent itemPage = new Intent(BeveragesCategory.this, ItemPage.class);
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

        greenTea = findViewById(R.id.green);
        greenTea.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Arizona Green Tea";
                String itemName = "ArizonaGreenTea";
                Intent itemPage = new Intent(BeveragesCategory.this, ItemPage.class);
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

        icedTea = findViewById(R.id.iced);
        icedTea.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Arizona Iced Tea";
                String itemName = "ArizonaIcedTea";
                Intent itemPage = new Intent(BeveragesCategory.this, ItemPage.class);
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

        water = findViewById(R.id.poland);
        water.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Poland Spring";
                String itemName = "PolandSpring";
                Intent itemPage = new Intent(BeveragesCategory.this, ItemPage.class);
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

        aj = findViewById(R.id.apple_juice);
        aj.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Apple Juice";
                String itemName = "AppleJuice";
                Intent itemPage = new Intent(BeveragesCategory.this, ItemPage.class);
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

        sparkWater = findViewById(R.id.sparkling);
        sparkWater.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Sparkling Water";
                String itemName = "SparklingWater";
                Intent itemPage = new Intent(BeveragesCategory.this, ItemPage.class);
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

        oj = findViewById(R.id.orange_juice);
        oj.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Orange Juice";
                String itemName = "OrangeJuice";
                Intent itemPage = new Intent(BeveragesCategory.this, ItemPage.class);
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
                startActivity(new Intent(BeveragesCategory.this, AboutUs.class));
                return true;
            case R.id.menuItemFAQ:
                startActivity(new Intent(BeveragesCategory.this, FAQ.class));
                return true;
            case R.id.menuItemLogout:
                Intent i = new Intent(BeveragesCategory.this, Login.class);
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
                Intent cartPage = new Intent(BeveragesCategory.this, Checkout.class);
                Bundle cartBundle = new Bundle();
                cartBundle.putString("Amount", "0");
                cartBundle.putString("itemName", "NO_ITEM");
                cartBundle.putString("noSpaces", "NO_ITEM");
                cartBundle.putString("price", "$ 0.00");
                cartBundle.putStringArrayList("nList", HomeScreen.itemNameList);
                cartBundle.putStringArrayList("pList", HomeScreen.itemPriceList);
                cartBundle.putStringArrayList("qList", HomeScreen.itemQuantityList);
                cartPage.putExtras(cartBundle);
                startActivity(cartPage);
                return true;
            case R.id.menuItemFavorites:
                startActivity(new Intent(BeveragesCategory.this, FavoritesList.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}