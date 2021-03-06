package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class Checkout extends AppCompatActivity {



    //private List<CartItem> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CartAdapter adapter = HomeScreen.adapter;
    //public CartItem ourList;

    TextView textViewSubtotal;
    TextView textViewTax;
    TextView textViewTotal;

    Button checkout;
    Button clearCart;
    Button updateTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewCart);

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        // Get shared preferences object
        Context context = Checkout.this;
        SharedPreferences sp =
                PreferenceManager.getDefaultSharedPreferences(context);
        // Get the shared preferences editor
        SharedPreferences.Editor editor = sp.edit();
        // Set preference values to save

        // Actually save values
        editor.apply();

        Bundle fromItemPage = getIntent().getExtras();
        String name = fromItemPage.getString("itemName");
        String loc = fromItemPage.getString("noSpaces");
        String quantity = fromItemPage.getString("Amount");
        String price = fromItemPage.getString("price");
        String actName = fromItemPage.getString("activity");
        price = price.substring(2);
        Double cost = Double.valueOf(quantity) * Double.valueOf(price);
        price = String.format("%.2f", cost);

        ArrayList<String> itemNameList = fromItemPage.getStringArrayList("nList");
        ArrayList<String> itemQuantityList = fromItemPage.getStringArrayList("qList");
        ArrayList<String> itemPriceList = fromItemPage.getStringArrayList("pList");

        if(savedInstanceState != null || actName.equals("history")) {
            // Arraylist for storing reversed elements
            /*ArrayList<String> reversePriceList = new ArrayList<String>();
            for (int i = itemPriceList.size() - 1; i >= 0; i--) {

                // Append the elements in reverse order
                reversePriceList.add(itemPriceList.get(i));
            }
            itemPriceList = reversePriceList;*/
            for(int i = 0; i < itemNameList.size(); i++){
                double d = (Double.valueOf(itemPriceList.get(i)) * Double.valueOf(itemQuantityList.get(i)));
                itemPriceList.set(i, Double.toString(d).format("%.2f", d));
            }
            HomeScreen.ourList.restoreItemList(itemNameList, itemQuantityList, itemPriceList);
            adapter.setData(HomeScreen.ourList.getItemName(), HomeScreen.ourList.getItemQuantity(), itemPriceList);
        }

        if(HomeScreen.ourList.getItemName().contains(name)){
            HomeScreen.ourList.updateItemQuantity(name, Integer.valueOf(quantity));
            //get the subtotal and stuff
            updateSubtotalAndStuff();
            /*textViewSubtotal = findViewById(R.id.textViewSubAmt);
            textViewTax = findViewById(R.id.textViewTaxAmt);
            textViewTotal = findViewById(R.id.textViewTotalAmt);
            Double subTotal = 0.00;
            for(int i = 0; i < HomeScreen.ourList.getSize(); i++){
                String p = HomeScreen.ourList.getItemPrice().get(i);
                subTotal = subTotal + Double.valueOf(p);
            }
            String subTotalString = String.format("%.2f", subTotal);
            Double tax = subTotal * 0.0875;
            String taxString = String.format("%.2f", tax);
            Double total = subTotal + tax;
            String totalString = String.format("%.2f", total);
            textViewSubtotal.setText("$ " + subTotalString);
            textViewTax.setText("$ " + taxString);
            textViewTotal.setText("$ " + totalString);*/
        }
        else if(name.equals("NO_ITEM")){

        }
        else{
            HomeScreen.ourList.setItemName(name);
            HomeScreen.ourList.setItemQuantity(quantity);
            HomeScreen.ourList.setItemPrice(price);
        }

        adapter.notifyDataSetChanged();

        //get the subtotal and stuff
        updateSubtotalAndStuff();
        /*textViewSubtotal = findViewById(R.id.textViewSubAmt);
        textViewTax = findViewById(R.id.textViewTaxAmt);
        textViewTotal = findViewById(R.id.textViewTotalAmt);
        Double subTotal = 0.00;
        for(int i = 0; i < HomeScreen.ourList.getSize(); i++){
            String p = HomeScreen.ourList.getItemPrice().get(i);
            subTotal = subTotal + Double.valueOf(p);
        }
        String subTotalString = String.format("%.2f", subTotal);
        Double tax = subTotal * 0.0875;
        String taxString = String.format("%.2f", tax);
        Double total = subTotal + tax;
        String totalString = String.format("%.2f", total);
        textViewSubtotal.setText("$ " + subTotalString);
        textViewTax.setText("$ " + taxString);
        textViewTotal.setText("$ " + totalString);*/

        //Checkout button
        checkout = findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!HomeScreen.ourList.getItemName().isEmpty()){
                    Bundle priceBundle = new Bundle();
                    priceBundle.putString("price", textViewTotal.getText().toString());
                    Intent i = new Intent(Checkout.this, Payment.class);
                    i.putExtras(priceBundle);
                    startActivity(i);
                    textViewSubtotal.setText("$ 0.00");
                    textViewTax.setText("$ 0.00");
                    textViewTotal.setText("$ 0.00");
                    adapter.notifyDataSetChanged();
                    finish();
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(Checkout.this).create();
                    alertDialog.setTitle("Checkout Failed");
                    alertDialog.setMessage("Please add items to the cart to checkout");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });
        clearCart = findViewById(R.id.buttonClearCart);
        clearCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.clearCart();
                adapter.notifyDataSetChanged();
                textViewSubtotal.setText("$ 0.00");
                textViewTax.setText("$ 0.00");
                textViewTotal.setText("$ 0.00");
            }
        });

        enableSwipeToDeleteAndUndo();

        //add data to list
//        Bundle fromItemPage = getIntent().getExtras();
//        String name = fromItemPage.getString("itemName");
//        String loc = fromItemPage.getString("noSpaces");
//        String quantity = fromItemPage.getString("Amount");
//        String price = fromItemPage.getString("price");
//        price = price.substring(2);
//        Double cost = Double.valueOf(quantity) * Double.valueOf(price);
//        price = String.format("%.2f", cost);
//
//        itemList.add(new CartItem(name, quantity, price));
//        adapter.notifyDataSetChanged();
//
//
//        //get the subtotal and stuff
//        textViewSubtotal = findViewById(R.id.textViewSubAmt);
//        textViewTax = findViewById(R.id.textViewTaxAmt);
//        textViewTotal = findViewById(R.id.textViewTotalAmt);
//        Double subTotal = 0.00;
//        for(int i = 0; i < itemList.size(); i++){
//            String p = itemList.get(i).getItemPrice();
//            subTotal = subTotal + Double.valueOf(p);
//        }
//        String subTotalString = String.format("%.2f", subTotal);
//        Double tax = subTotal * 0.0875;
//        String taxString = String.format("%.2f", tax);
//        Double total = subTotal + tax;
//        String totalString = String.format("%.2f", total);
//        textViewSubtotal.setText(subTotalString);
//        textViewTax.setText(taxString);
//        textViewTotal.setText(totalString);
    }

    @Override
    public void onSaveInstanceState(@NonNull  Bundle outState){
        Parcelable rvState = recyclerView.getLayoutManager().onSaveInstanceState();
        super.onSaveInstanceState(outState);
        //I need to save the grocery list here
        //save recycler view position?
        outState.putParcelable("RECYCLER_VIEW_KEY", rvState);
        //save recycler view items?
        outState.putSerializable("RV_DATA", (Serializable) HomeScreen.ourList.getItemName());
        outState.putSerializable("RV_DATA2", (Serializable) HomeScreen.ourList.getItemQuantity());
        outState.putSerializable("RV_DATA3", (Serializable) HomeScreen.ourList.getItemPrice());
        //getChildFragmentManager().putFragment(outState, "bottom_dialog", bottomSheetDialogFrag);
    }

    public void enableSwipeToDeleteAndUndo() {
        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(this) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


                final int position = viewHolder.getAdapterPosition();

                adapter.deleteItem(position);

                Double subTotal = 0.00;
                for(int x = 0; x < HomeScreen.ourList.getSize(); x++){
                    String p = HomeScreen.ourList.getItemPrice().get(x);
                    subTotal = subTotal + Double.valueOf(p);
                }
                String subTotalString = String.format("%.2f", subTotal);
                Double tax = subTotal * 0.0875;
                String taxString = String.format("%.2f", tax);
                Double total = subTotal + tax;
                String totalString = String.format("%.2f", total);
                textViewSubtotal.setText("$ " + subTotalString);
                textViewTax.setText("$ " + taxString);
                textViewTotal.setText("$ " + totalString);

            }
        };

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchhelper.attachToRecyclerView(recyclerView);

    }

    public void updateSubtotalAndStuff(){
        //get the subtotal and stuff
        textViewSubtotal = findViewById(R.id.textViewSubAmt);
        textViewTax = findViewById(R.id.textViewTaxAmt);
        textViewTotal = findViewById(R.id.textViewTotalAmt);
        Double subTotal = 0.00;
        for(int i = 0; i < HomeScreen.ourList.getSize(); i++){
            String p = HomeScreen.ourList.getItemPrice().get(i);
            subTotal = subTotal + Double.valueOf(p);
        }
        String subTotalString = String.format("%.2f", subTotal);
        Double tax = subTotal * 0.0875;
        String taxString = String.format("%.2f", tax);
        Double total = subTotal + tax;
        String totalString = String.format("%.2f", total);
        textViewSubtotal.setText("$ " + subTotalString);
        textViewTax.setText("$ " + taxString);
        textViewTotal.setText("$ " + totalString);
    }




}