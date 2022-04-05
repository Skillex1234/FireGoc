package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
            }
        });
    }
}