package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DairyCategory extends AppCompatActivity {

    ImageView buttermilk;
    ImageView heavyCream;
    ImageView mozz;
    ImageView sourCream;
    ImageView parm;
    ImageView wholeMilk;
    ImageView shred;
    ImageView yogurt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_category);

        buttermilk = findViewById(R.id.buttermilk);
        buttermilk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Buttermilk";
                String itemName = "Buttermilk";
                Intent itemPage = new Intent(DairyCategory.this, ItemPage.class);
                Bundle extras = new Bundle();
                extras.putString("item_name", itemName);
                extras.putString("item_name_with_spaces", itemNameWithSpaces);
                itemPage.putExtras(extras);
                startActivity(itemPage);
            }
        });

        heavyCream = findViewById(R.id.Cream);
        heavyCream.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Cream";
                String itemName = "HeavyCream";
                Intent itemPage = new Intent(DairyCategory.this, ItemPage.class);
                Bundle extras = new Bundle();
                extras.putString("item_name", itemName);
                extras.putString("item_name_with_spaces", itemNameWithSpaces);
                itemPage.putExtras(extras);
                startActivity(itemPage);
            }
        });

        mozz = findViewById(R.id.Mozza);
        mozz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Mozzarella Cheese";
                String itemName = "MozzarellaCheese";
                Intent itemPage = new Intent(DairyCategory.this, ItemPage.class);
                Bundle extras = new Bundle();
                extras.putString("item_name", itemName);
                extras.putString("item_name_with_spaces", itemNameWithSpaces);
                itemPage.putExtras(extras);
                startActivity(itemPage);
            }
        });

        sourCream = findViewById(R.id.Sour);
        sourCream.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Sour Cream";
                String itemName = "SourCream";
                Intent itemPage = new Intent(DairyCategory.this, ItemPage.class);
                Bundle extras = new Bundle();
                extras.putString("item_name", itemName);
                extras.putString("item_name_with_spaces", itemNameWithSpaces);
                itemPage.putExtras(extras);
                startActivity(itemPage);
            }
        });

        parm = findViewById(R.id.Parm);
        parm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Parmesan Cheese";
                String itemName = "ParmesanCheese";
                Intent itemPage = new Intent(DairyCategory.this, ItemPage.class);
                Bundle extras = new Bundle();
                extras.putString("item_name", itemName);
                extras.putString("item_name_with_spaces", itemNameWithSpaces);
                itemPage.putExtras(extras);
                startActivity(itemPage);
            }
        });

        wholeMilk = findViewById(R.id.Whole);
        wholeMilk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Whole Milk";
                String itemName = "WholeMilk";
                Intent itemPage = new Intent(DairyCategory.this, ItemPage.class);
                Bundle extras = new Bundle();
                extras.putString("item_name", itemName);
                extras.putString("item_name_with_spaces", itemNameWithSpaces);
                itemPage.putExtras(extras);
                startActivity(itemPage);
            }
        });

        shred = findViewById(R.id.Shredded);
        shred.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Shredded Cheese";
                String itemName = "ShreddedCheese";
                Intent itemPage = new Intent(DairyCategory.this, ItemPage.class);
                Bundle extras = new Bundle();
                extras.putString("item_name", itemName);
                extras.putString("item_name_with_spaces", itemNameWithSpaces);
                itemPage.putExtras(extras);
                startActivity(itemPage);
            }
        });

        yogurt = findViewById(R.id.Yogurt);
        yogurt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemNameWithSpaces = "Yogurt";
                String itemName = "Yogurt";
                Intent itemPage = new Intent(DairyCategory.this, ItemPage.class);
                Bundle extras = new Bundle();
                extras.putString("item_name", itemName);
                extras.putString("item_name_with_spaces", itemNameWithSpaces);
                itemPage.putExtras(extras);
                startActivity(itemPage);
            }
        });

    }
}