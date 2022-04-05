package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
            }
        });

    }
}