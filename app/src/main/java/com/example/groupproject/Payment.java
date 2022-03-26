package com.example.groupproject;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Payment extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        listView = findViewById(R.id.listView);

        String [] values = new String[]{
                "Mastercard ending 2012, EXP: 2/25", "Visa ending 3423 EXP: 3/23"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int postion, long id) {
                if (postion == 0) {
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}

