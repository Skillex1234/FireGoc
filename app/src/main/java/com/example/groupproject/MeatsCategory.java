package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MeatsCategory extends AppCompatActivity {

    ImageView dino;
    TextView dinoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meats_category);

        dino = findViewById(R.id.dino);
        dinoText = findViewById(R.id.dinotext);
        dino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = dinoText.getText().toString().substring(0,12).replaceAll(" ","");
                Intent itemPage = new Intent(MeatsCategory.this, ItemPage.class);
                itemPage.putExtra("item_name", itemName);
                startActivity(itemPage);
            }
        });
    }
}