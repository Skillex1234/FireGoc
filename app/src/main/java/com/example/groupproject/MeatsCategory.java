package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MeatsCategory extends AppCompatActivity {

    ImageView dino;
    TextView dinoText;
    ImageView groundBeef;
    TextView gbText;
    ImageView groundTurkey;
    ImageView prosciutto;
    ImageView chickenBreast;
    ImageView chickenThighs;
    ImageView ribeye;
    ImageView wholeChicken;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meats_category);

        Bundle itemPage = getIntent().getExtras();
        ArrayList<String> itemNameList = itemPage.getStringArrayList("nameList");
        ArrayList<String> itemQuantityList = itemPage.getStringArrayList("qList");
        ArrayList<String> itemPriceList = itemPage.getStringArrayList("pList");

        dino = findViewById(R.id.dino);
        dinoText = findViewById(R.id.dinotext);
        dino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = dinoText.getText().toString().substring(0,12);
                String itemName = dinoText.getText().toString().substring(0,12).replaceAll(" ","");
                Intent itemPage = new Intent(MeatsCategory.this, ItemPage.class);
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

        groundBeef = findViewById(R.id.beef);
        gbText = findViewById(R.id.beeftext);
        groundBeef.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = gbText.getText().toString().substring(0,11);
                String itemName = gbText.getText().toString().substring(0,11).replaceAll(" ","");
                Intent itemPage = new Intent(MeatsCategory.this, ItemPage.class);
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

        groundTurkey = findViewById(R.id.turkey);
        groundTurkey.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Ground Turkey";
                String itemName = "GroundTurkey";
                Intent itemPage = new Intent(MeatsCategory.this, ItemPage.class);
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

        prosciutto = findViewById(R.id.prosciutto);
        prosciutto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Sliced Prosciutto";
                String itemName = "SlicedProsciutto";
                Intent itemPage = new Intent(MeatsCategory.this, ItemPage.class);
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

        chickenBreast = findViewById(R.id.breast);
        chickenBreast.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Chicken Breast";
                String itemName = "ChickenBreast";
                Intent itemPage = new Intent(MeatsCategory.this, ItemPage.class);
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

        chickenThighs = findViewById(R.id.thighs);
        chickenThighs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Chicken Thighs";
                String itemName = "ChickenThigh";
                Intent itemPage = new Intent(MeatsCategory.this, ItemPage.class);
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

        ribeye = findViewById(R.id.steak);
        ribeye.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Ribeye Steak";
                String itemName = "RibeyeSteak";
                Intent itemPage = new Intent(MeatsCategory.this, ItemPage.class);
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

        wholeChicken = findViewById(R.id.Wholechicken);
        wholeChicken.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Whole Chicken";
                String itemName = "WholeChicken";
                Intent itemPage = new Intent(MeatsCategory.this, ItemPage.class);
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
                startActivity(new Intent(MeatsCategory.this, AboutUs.class));
                return true;
            case R.id.menuItemFAQ:
                startActivity(new Intent(MeatsCategory.this, FAQ.class));
                return true;
            case R.id.menuItemLogout:
                Intent i = new Intent(MeatsCategory.this, Login.class);
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
                Intent cartPage = new Intent(MeatsCategory.this, Checkout.class);
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
                startActivity(new Intent(MeatsCategory.this, OrderHistory.class));
                return true;
            case R.id.menuItemFavorites:
                startActivity(new Intent(MeatsCategory.this, FavoritesList.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}