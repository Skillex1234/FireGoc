package com.example.groupproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderHistoryDialogAdapter extends RecyclerView.Adapter<OrderHistoryDialogAdapter.MyViewHolder> {
    public static List<String> itemList, quantityList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewItemName, textViewItemQuantity;
        public MyViewHolder(View view) {
            super(view);
            textViewItemName = (TextView) view.findViewById(R.id.textViewItemNameHist);
            textViewItemQuantity = (TextView) view.findViewById(R.id.textViewItemQuantityHist);
        }
    }

    public OrderHistoryDialogAdapter(List<String> nameList, List<String> quantityList) {
        itemList = nameList;
        this.quantityList = quantityList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_history_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String name = itemList.get(position);
        holder.textViewItemName.setText(name);
        String quan = quantityList.get(position);
        holder.textViewItemQuantity.setText(quan);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
    public void setData(List<String> nameList, List<String> quantityList) {
        itemList = nameList;
        this.quantityList = quantityList;
        notifyDataSetChanged();
    }

}
