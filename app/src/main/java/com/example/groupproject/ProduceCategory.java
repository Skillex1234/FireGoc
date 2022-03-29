package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
                itemPage.putExtras(extras);
                startActivity(itemPage);
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
                itemPage.putExtras(extras);
                startActivity(itemPage);
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
                itemPage.putExtras(extras);
                startActivity(itemPage);
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
                itemPage.putExtras(extras);
                startActivity(itemPage);
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
                itemPage.putExtras(extras);
                startActivity(itemPage);
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
                itemPage.putExtras(extras);
                startActivity(itemPage);
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
                itemPage.putExtras(extras);
                startActivity(itemPage);
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
                itemPage.putExtras(extras);
                startActivity(itemPage);
            }
        });

    }
}