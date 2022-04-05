package com.example.groupproject;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        public TextView textViewQuantity;
        public TextView textViewPrice;

        public MyViewHolder(View view){
            super(view);
            textViewItemName = (TextView) view.findViewById(R.id.textViewItemNameCart);
            textViewQuantity = (TextView) view.findViewById(R.id.textViewQuantityCart);
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

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.textViewItemName.setText(itemNames.get(position));
        holder.textViewQuantity.setText(itemQuantities.get(position));
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


}
