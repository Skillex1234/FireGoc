package com.example.groupproject;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

    String[] quantity = new String[100];

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewItemName;
        public Spinner spinnerQuantity;
        public TextView textViewPrice;


        public MyViewHolder(View view){
            super(view);
            textViewItemName = (TextView) view.findViewById(R.id.textViewItemNameCart);
            spinnerQuantity = (Spinner) view.findViewById(R.id.spinnerItemQuantity);
            textViewPrice = (TextView) view.findViewById(R.id.textViewPriceCart);
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
        for(int i = 1; i < quantity.length; i++){
            quantity[i-1] = String.valueOf(i);
        }


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        //Add spinner values somehow
        holder.textViewItemName.setText(itemNames.get(position));
        holder.textViewPrice.setText(itemPrices.get(position));
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
