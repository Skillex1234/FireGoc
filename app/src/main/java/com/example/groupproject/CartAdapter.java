package com.example.groupproject;

import android.content.Context;
import android.media.Image;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder>{

    private List<String> itemNames;
    private List<String> itemQuantities;
    private List<String> itemPrices;


    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewItemName;
        public TextView cartQuantity;
        public TextView textViewPrice;
        public Button subButton;
        public Button addButton;

        public MyViewHolder(View view){
            super(view);
            textViewItemName = (TextView) view.findViewById(R.id.textViewItemNameCart);
            cartQuantity = (TextView) view.findViewById(R.id.textViewQuantity);
            textViewPrice = (TextView) view.findViewById(R.id.textViewPriceCart);
            subButton = (Button) view.findViewById(R.id.buttonSubQuantity);
            addButton = (Button) view.findViewById(R.id.buttonIncQuantity);

            subButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Integer.valueOf(cartQuantity.getText().toString()) > 1){
                        HomeScreen.ourList.updateItemQuantity(textViewItemName.getText().toString(), -1);
                        HomeScreen.adapter.notifyDataSetChanged();
                    }
                    else if (Integer.valueOf(cartQuantity.getText().toString()) == 1){
                        deleteItem(HomeScreen.ourList.getItemName().indexOf(textViewItemName.getText().toString()));
                        HomeScreen.adapter.notifyDataSetChanged();
                    }
                }
            });

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HomeScreen.ourList.updateItemQuantity(textViewItemName.getText().toString(), 1);
                    HomeScreen.adapter.notifyDataSetChanged();

                }
            });
        }
    }

    public CartAdapter(List<String> itemNameList, List<String> itemQuanList, List<String> itemPriceList){
        itemNames = itemNameList;
        itemQuantities = itemQuanList;
        itemPrices = itemPriceList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout, parent, false);



        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.textViewItemName.setText(itemNames.get(position));
        holder.textViewPrice.setText(itemPrices.get(position));
        holder.cartQuantity.setText(itemQuantities.get(position));
    }

    @Override
    public int getItemCount(){
        return itemNames.size();
    }

    public void clearCart() {
        if (itemNames != null && !itemNames.isEmpty()) {
            int size = itemNames.size();
            itemNames.clear();
            itemQuantities.clear();
            itemPrices.clear();
            notifyItemRangeRemoved(0, size);
        }
    }

    public void deleteItem(int pos){
        itemNames.remove(pos);
        itemPrices.remove(pos);
        itemQuantities.remove(pos);
        notifyItemRemoved(pos);
        notifyDataSetChanged();
    }

    public void clearItems(){
        itemNames.clear();
        itemPrices.clear();
        itemQuantities.clear();
        notifyDataSetChanged();
    }


}
