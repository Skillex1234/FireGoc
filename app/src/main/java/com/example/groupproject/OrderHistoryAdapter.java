package com.example.groupproject;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryAdapter extends  RecyclerView.Adapter<OrderHistoryAdapter.MyViewHolder>{
    private List<String> orderList = new ArrayList<>();
    private ArrayList<String> itemList = new ArrayList<>();
    private ArrayList<String> quantityList = new ArrayList<>();
    private ArrayList<String> priceList = new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;
    private OrderHistoryDialogAdapter HistoryAdapter;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewOrderName;
        public Button buttonViewOrder;
        public MyViewHolder(View view) {
            super(view);
            textViewOrderName = (TextView) view.findViewById(R.id.textViewOrderName);

            buttonViewOrder = (Button) view.findViewById(R.id.buttonViewOrder);
            buttonViewOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference dbRef = firebaseDatabase.getReference();
                    DatabaseReference ohRef = dbRef.child("Users").child(Login.username).child("Orders");
                    runQuery(ohRef, textViewOrderName.getText().toString());

                    View dialoglayout = inflater.inflate(R.layout.view_order_layout, null);

                    RecyclerView rvOrderHistory = dialoglayout.findViewById(R.id.recyclerViewItemHistory);
                    HistoryAdapter = new OrderHistoryDialogAdapter(itemList, quantityList);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(view.getContext().getApplicationContext());
                    rvOrderHistory.setLayoutManager(layoutManager);
                    rvOrderHistory.setAdapter(HistoryAdapter);

                    //itemList.remove(0);
                    //quantityList.remove(0);

                    AlertDialog.Builder b = new AlertDialog.Builder(view.getContext());
                    b.setView(dialoglayout);
                    AlertDialog alertDialog = b.create();
                    alertDialog.setTitle(R.string.orderhist);
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Add To Cart",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    //add to cart
                                    for(int i = 0; i < itemList.size(); i++){
                                        String itemName = itemList.get(i).replaceAll("\\s","");
                                        DatabaseReference orders = dbRef.child("Items").child(itemName);
                                        Query q = orders;
                                        q.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                for(DataSnapshot ds : snapshot.getChildren()){
                                                    if(ds.getKey().equals("price")){
                                                        priceList.add(ds.getValue().toString());
                                                    }
                                                }
                                                if(itemList.get(0).equals("Total")){
                                                    itemList.remove(0);
                                                    quantityList.remove(0);
                                                }
                                                if(priceList.size() == itemList.size()){
                                                    Intent x = new Intent(view.getContext().getApplicationContext(), Checkout.class);
                                                    Bundle bund = new Bundle();
                                                    bund.putString("Amount", "0");
                                                    bund.putString("itemName", "NO_ITEM");
                                                    bund.putString("noSpaces", "NO_ITEM");
                                                    bund.putString("price", "$ 0.00");
                                                    bund.putString("activity", "history");
                                                    HomeScreen.itemNameList = itemList;
                                                    HomeScreen.itemQuantityList = quantityList;
                                                    HomeScreen.itemPriceList = priceList;
                                                    bund.putStringArrayList("nList", HomeScreen.itemNameList);
                                                    bund.putStringArrayList("pList", HomeScreen.itemPriceList);
                                                    bund.putStringArrayList("qList", HomeScreen.itemQuantityList);
                                                    x.putExtras(bund);
                                                    view.getContext().startActivity(x);
                                                    ((Activity)view.getContext()).finish();
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError error) {

                                            }

                                        });

                                    }


                                }
                            });
                    alertDialog.show();
                }
            });
        }
    }

    public OrderHistoryAdapter(List<String> orderList, ArrayList<String> iList, ArrayList<String> qList, Context context) {
        this.orderList = orderList;
        itemList = iList;
        quantityList = qList;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.order_history_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String orderName = orderList.get(position);
        holder.textViewOrderName.setText(orderName);
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public void setData(List<String> nameList, ArrayList<String> iList, ArrayList<String> qList) {
        orderList = nameList;
        itemList = iList;
        quantityList = qList;
        notifyDataSetChanged();
    }

    public void runQuery(DatabaseReference ohRef, String orderName){
        DatabaseReference itemRef = ohRef.child(orderName);
        itemList.clear();
        quantityList.clear();
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
                setData(orderList, itemList, quantityList);
                HistoryAdapter.setData(itemList, quantityList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}
