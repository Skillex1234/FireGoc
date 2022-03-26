package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


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

        meatcategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, MeatsCategory.class));
            }
        });

        producecategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, ProduceCategory.class));
            }
        });
        dairycategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, DairyCategory.class));
            }
        });
        spicecategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, SpicesAndDryFoodCategory.class));
            }
        });
        beveragecategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, BeveragesCategory.class));
            }
        });
        frozencategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, FrozenCategory.class));
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
                itemPage.putExtras(extras);
                startActivity(itemPage);
            }
        });
    }
}
