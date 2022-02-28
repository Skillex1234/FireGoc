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
    ImageView featured1;
    TextView textViewFeaturedOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        meatcategory = findViewById(R.id.buttonCategoryMeats);
        featured1 = findViewById(R.id.imageViewCoke);

        meatcategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, MeatsCategory.class));
            }
        });

        textViewFeaturedOne = findViewById(R.id.textViewFeaturedOne);
        featured1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = textViewFeaturedOne.getText().toString().replaceAll("\\s","");
                Intent itemPage = new Intent(HomeScreen.this, ItemPage.class);
                itemPage.putExtra("item_name", itemName);
                startActivity(itemPage);
            }
        });
    }
}
