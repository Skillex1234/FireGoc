package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
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
    private CartAdapter adapter;
    //public CartItem ourList;

    TextView textViewSubtotal;
    TextView textViewTax;
    TextView textViewTotal;

    Button checkout;
    Button clearCart;
    Button chosepayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewCart);
        adapter = new CartAdapter(HomeScreen.ourList.getItemName(), HomeScreen.ourList.getItemQuantity(), HomeScreen.ourList.getItemPrice());
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
        price = price.substring(2);
        Double cost = Double.valueOf(quantity) * Double.valueOf(price);
        price = String.format("%.2f", cost);

        ArrayList<String> itemNameList = fromItemPage.getStringArrayList("nameList");
        ArrayList<String> itemQuantityList = fromItemPage.getStringArrayList("qList");
        ArrayList<String> itemPriceList = fromItemPage.getStringArrayList("pList");

        if(savedInstanceState != null) {
            HomeScreen.ourList.restoreItemList(itemNameList, itemQuantityList, itemPriceList);
        }

        if(HomeScreen.ourList.getItemName().contains(name)){
            HomeScreen.ourList.updateItemQuantity(name, Integer.valueOf(quantity));
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
        else{
            HomeScreen.ourList.setItemName(name);
            HomeScreen.ourList.setItemQuantity(quantity);
            HomeScreen.ourList.setItemPrice(price);
        }

        adapter.notifyDataSetChanged();

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

        //Checkout button
        checkout = findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!HomeScreen.ourList.getItemName().isEmpty()){
                    AlertDialog alertDialog = new AlertDialog.Builder(Checkout.this).create();
                    alertDialog.setTitle("Checkout Successful");
                    alertDialog.setMessage("Checkout success please check email for details");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    adapter.clearCart();
                                    adapter.notifyDataSetChanged();
                                    textViewSubtotal.setText("$ 0.00");
                                    textViewTax.setText("$ 0.00");
                                    textViewTotal.setText("$ 0.00");
                                }
                            });
                    alertDialog.show();
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
        //Payment Button
        chosepayment = findViewById(R.id.chosepayment);
        chosepayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Checkout.this, Payment.class));

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
    public void onResume(){
        super.onResume();

//        // Get shared preferences object
//        Context context = Checkout.this;
//        SharedPreferences sp =
//                PreferenceManager.getDefaultSharedPreferences(context);
//        // Get the shared preferences editor
//        SharedPreferences.Editor editor = sp.edit();
//        // Set preference values to save
//
//        // Actually save values
//        editor.apply();
//
//        Bundle fromItemPage = getIntent().getExtras();
//        String name = fromItemPage.getString("itemName");
//        String loc = fromItemPage.getString("noSpaces");
//        String quantity = fromItemPage.getString("Amount");
//        String price = fromItemPage.getString("price");
//        price = price.substring(2);
//        Double cost = Double.valueOf(quantity) * Double.valueOf(price);
//        price = String.format("%.2f", cost);
//
//        ArrayList<String> itemNameList = fromItemPage.getStringArrayList("nameList");
//        ArrayList<String> itemQuantityList = fromItemPage.getStringArrayList("qList");
//        ArrayList<String> itemPriceList = fromItemPage.getStringArrayList("pList");
//
//
//
//        ourList.setItemName(name);
//        ourList.setItemQuantity(quantity);
//        ourList.setItemPrice(price);
//        adapter.notifyDataSetChanged();
//
//        //get the subtotal and stuff
//        textViewSubtotal = findViewById(R.id.textViewSubAmt);
//        textViewTax = findViewById(R.id.textViewTaxAmt);
//        textViewTotal = findViewById(R.id.textViewTotalAmt);
//        Double subTotal = 0.00;
//        for(int i = 0; i < ourList.getSize(); i++){
//            String p = ourList.getItemPrice().get(i);
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


}