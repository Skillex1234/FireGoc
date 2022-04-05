package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeScreen extends AppCompatActivity {

    Button meatcategory;
    Button frozencategory;
    Button dairycategory;
    Button spicecategory;
    Button beveragecategory;
    Button producecategory;

    ImageView featured1;
    ImageView featured2;
    ImageView featured3;
    ImageView featured4;
    TextView textViewFeaturedOne;
    TextView textViewFeaturedTwo;
    TextView textViewFeaturedThree;
    TextView textViewFeaturedFour;

    public static CartItem ourList = new CartItem();
    private ArrayList<String> itemNameList = new ArrayList<String>();
    private ArrayList<String> itemQuantityList = new ArrayList<String>();
    private ArrayList<String> itemPriceList = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        meatcategory = findViewById(R.id.buttonCategoryMeats);
        frozencategory = findViewById(R.id.buttonCategoryFrozen);
        dairycategory = findViewById(R.id.buttonCategoryDairy);
        spicecategory = findViewById(R.id.buttonCategoryDry);
        beveragecategory = findViewById(R.id.buttonCategoryDrinks);
        producecategory = findViewById(R.id.buttonCategoryProduce);
        featured1 = findViewById(R.id.imageViewFeatured1);
        featured2 = findViewById(R.id.imageViewFeatured2);
        featured3 = findViewById(R.id.imageViewFeatured3);
        featured4 = findViewById(R.id.imageViewFeatured4);

        Bundle listBundle = new Bundle();
        listBundle.putStringArrayList("nameList", itemNameList);
        listBundle.putStringArrayList("quantityList", itemQuantityList);
        listBundle.putStringArrayList("priceList", itemPriceList);

        meatcategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //These two lines for each category
                Intent i = new Intent(HomeScreen.this, MeatsCategory.class);
                i.putExtras(listBundle);
                startActivity(i);
            }
        });

        producecategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreen.this, ProduceCategory.class);
                i.putExtras(listBundle);
                startActivity(i);
            }
        });
        dairycategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreen.this, DairyCategory.class);
                i.putExtras(listBundle);
                startActivity(i);
            }
        });
        spicecategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreen.this, SpicesAndDryFoodCategory.class);
                i.putExtras(listBundle);
                startActivity(i);
            }
        });
        beveragecategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreen.this, BeveragesCategory.class);
                i.putExtras(listBundle);
                startActivity(i);
            }
        });
        frozencategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreen.this, FrozenCategory.class);
                i.putExtras(listBundle);
                startActivity(i);
            }
        });


        textViewFeaturedOne = findViewById(R.id.textViewFeaturedOne);
        featured1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = textViewFeaturedOne.getText().toString();
                String itemName = textViewFeaturedOne.getText().toString().replaceAll("\\s","");
                Intent itemPage = new Intent(HomeScreen.this, ItemPage.class);
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

        textViewFeaturedTwo = findViewById(R.id.textViewFeaturedTwo);
        featured2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = textViewFeaturedTwo.getText().toString();
                String itemName = textViewFeaturedTwo.getText().toString().replaceAll("\\s","");
                Intent itemPage = new Intent(HomeScreen.this, ItemPage.class);
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

        textViewFeaturedThree = findViewById(R.id.textViewFeaturedThree);
        featured3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = textViewFeaturedThree.getText().toString();
                String itemName = textViewFeaturedThree.getText().toString().replaceAll("\\s","");
                Intent itemPage = new Intent(HomeScreen.this, ItemPage.class);
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

        textViewFeaturedFour = findViewById(R.id.textViewFeaturedFour);
        featured4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = textViewFeaturedFour.getText().toString();
                String itemName = textViewFeaturedFour.getText().toString().replaceAll("\\s","");
                Intent itemPage = new Intent(HomeScreen.this, ItemPage.class);
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
