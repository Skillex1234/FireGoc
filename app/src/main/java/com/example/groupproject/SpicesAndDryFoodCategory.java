package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
                itemPage.putExtras(extras);
                startActivity(itemPage);
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
                itemPage.putExtras(extras);
                startActivity(itemPage);
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
                itemPage.putExtras(extras);
                startActivity(itemPage);
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
                itemPage.putExtras(extras);
                startActivity(itemPage);
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
                itemPage.putExtras(extras);
                startActivity(itemPage);
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
                itemPage.putExtras(extras);
                startActivity(itemPage);
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
                itemPage.putExtras(extras);
                startActivity(itemPage);
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
                itemPage.putExtras(extras);
                startActivity(itemPage);
            }
        });

    }
}