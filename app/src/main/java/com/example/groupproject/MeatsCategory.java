package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
            }
        });
    }
}