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

public class ProduceCategory extends AppCompatActivity {

    ImageView apples;
    ImageView asparagus;
    ImageView avocados;
    ImageView dragon;
    ImageView bananas;
    ImageView onions;
    ImageView cuke;
    ImageView oranges;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produce_category);

        Bundle itemPage = getIntent().getExtras();
        ArrayList<String> itemNameList = itemPage.getStringArrayList("nameList");
        ArrayList<String> itemQuantityList = itemPage.getStringArrayList("qList");
        ArrayList<String> itemPriceList = itemPage.getStringArrayList("pList");

        apples = findViewById(R.id.apple);
        apples.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Gala Apples";
                String itemName = "GalaApples";
                Intent itemPage = new Intent(ProduceCategory.this, ItemPage.class);
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

        asparagus = findViewById(R.id.asparagus);
        asparagus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Asparagus";
                String itemName = "Asparagus";
                Intent itemPage = new Intent(ProduceCategory.this, ItemPage.class);
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

        avocados = findViewById(R.id.avovo);
        avocados.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Avocados";
                String itemName = "Avocados";
                Intent itemPage = new Intent(ProduceCategory.this, ItemPage.class);
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

        dragon = findViewById(R.id.Dragon);
        dragon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Dragon Fruit";
                String itemName = "DragonFruit";
                Intent itemPage = new Intent(ProduceCategory.this, ItemPage.class);
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

        bananas = findViewById(R.id.Banana);
        bananas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Bananas";
                String itemName = "Banana";
                Intent itemPage = new Intent(ProduceCategory.this, ItemPage.class);
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

        onions = findViewById(R.id.onions);
        onions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Onions";
                String itemName = "Onions";
                Intent itemPage = new Intent(ProduceCategory.this, ItemPage.class);
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

        cuke = findViewById(R.id.Cucumber);
        cuke.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Cucumbers";
                String itemName = "Cucumbers";
                Intent itemPage = new Intent(ProduceCategory.this, ItemPage.class);
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

        oranges = findViewById(R.id.Oranges);
        oranges.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Oranges";
                String itemName = "Oranges";
                Intent itemPage = new Intent(ProduceCategory.this, ItemPage.class);
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
                startActivity(new Intent(ProduceCategory.this, AboutUs.class));
                return true;
            case R.id.menuItemFAQ:
                startActivity(new Intent(ProduceCategory.this, FAQ.class));
                return true;
            case R.id.menuItemLogout:
                Intent i = new Intent(ProduceCategory.this, Login.class);
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
                Intent cartPage = new Intent(ProduceCategory.this, Checkout.class);
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
                startActivity(new Intent(ProduceCategory.this, OrderHistory.class));
                return true;
            case R.id.menuItemFavorites:
                startActivity(new Intent(ProduceCategory.this, FavoritesList.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}