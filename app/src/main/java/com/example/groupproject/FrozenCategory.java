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

public class FrozenCategory extends AppCompatActivity {

    ImageView ic;
    ImageView pizza;
    ImageView salmon;
    ImageView tots;
    ImageView shrimp;
    ImageView potWedges;
    ImageView mixVeg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frozen_category);

        Bundle itemPage = getIntent().getExtras();
        ArrayList<String> itemNameList = itemPage.getStringArrayList("nameList");
        ArrayList<String> itemQuantityList = itemPage.getStringArrayList("qList");
        ArrayList<String> itemPriceList = itemPage.getStringArrayList("pList");

        ic = findViewById(R.id.cookies);
        ic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Cookies & Cream";
                String itemName = "IceCream";
                Intent itemPage = new Intent(FrozenCategory.this, ItemPage.class);
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

        pizza = findViewById(R.id.pizza);
        pizza.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Frozen Pizza";
                String itemName = "Pizza";
                Intent itemPage = new Intent(FrozenCategory.this, ItemPage.class);
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

        salmon = findViewById(R.id.salmon);
        salmon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Frozen Salmon";
                String itemName = "FrozenSalmon";
                Intent itemPage = new Intent(FrozenCategory.this, ItemPage.class);
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

        tots = findViewById(R.id.tots);
        tots.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Tater Tots";
                String itemName = "TaterTots";
                Intent itemPage = new Intent(FrozenCategory.this, ItemPage.class);
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

        shrimp = findViewById(R.id.shrimp);
        shrimp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Frozen Shrimp";
                String itemName = "WhiteShrimp";
                Intent itemPage = new Intent(FrozenCategory.this, ItemPage.class);
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

        potWedges = findViewById(R.id.Wedges);
        potWedges.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Potato Wedges";
                String itemName = "PotatoWedges";
                Intent itemPage = new Intent(FrozenCategory.this, ItemPage.class);
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

        mixVeg = findViewById(R.id.Steamed);
        mixVeg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Steamed Vegetables";
                String itemName = "MixedVegetables";
                Intent itemPage = new Intent(FrozenCategory.this, ItemPage.class);
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
                startActivity(new Intent(FrozenCategory.this, AboutUs.class));
                return true;
            case R.id.menuItemFAQ:
                startActivity(new Intent(FrozenCategory.this, FAQ.class));
                return true;
            case R.id.menuItemLogout:
                Intent i = new Intent(FrozenCategory.this, Login.class);
                HomeScreen.itemNameList.clear();
                HomeScreen.itemPriceList.clear();
                HomeScreen.itemQuantityList.clear();
                HomeScreen.adapter.clearItems();
                HomeScreen.adapter.notifyDataSetChanged();
                finishAffinity();
                startActivity(i);
                return true;
            case R.id.menuItemCart:
                //figure what to pass since we're not adding an item
                Intent cartPage = new Intent(FrozenCategory.this, Checkout.class);
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
                startActivity(new Intent(FrozenCategory.this, FavoritesList.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}