package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory extends AppCompatActivity {
    private List<String> orderList = new ArrayList<>();
    private ArrayList<String> itemList = new ArrayList<>();
    private ArrayList<String> quantityList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OrderHistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        FirebaseDatabase fb = FirebaseDatabase.getInstance();
        DatabaseReference ref = fb.getReference();
        DatabaseReference ohRef = ref.child("Users").child(Login.username).child("Orders");
        ohRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){

                    String order = ds.getKey();
                    orderList.add(order);
                    DatabaseReference itemRef = ohRef.child(order);
                    itemRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot ds : snapshot.getChildren()){
                                String name, quan;
                                if(ds.getKey().equals("Total")){
                                    name = ds.getKey().toString();
                                    quan = ds.getValue().toString();
                                    itemList.add(0, name);
                                    quantityList.add(0,quan);
                                }
                                else{
                                    String nameEdit = ds.getValue().toString();
                                    name = nameEdit.substring(0, nameEdit.indexOf(","));
                                    quan = nameEdit.substring(nameEdit.indexOf(",")+1);
                                    itemList.add(name);
                                    quantityList.add(quan);
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                adapter.setData(orderList, itemList, quantityList);
                HomeScreen.orderList = orderList;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewOrderHistory);
        adapter = new OrderHistoryAdapter(orderList, itemList, quantityList, OrderHistory.this);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


}