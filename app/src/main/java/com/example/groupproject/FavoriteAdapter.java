package com.example.groupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.MyViewHolder> {
    private List<String> itemList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public Button favButton;

        public MyViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.textViewFaveName);
            favButton = (Button) view.findViewById(R.id.buttonFavPage);
            favButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), ItemPage.class);
                    Bundle b = new Bundle();
                    b.putString("item_name", name.getText().toString().replaceAll("\\s",""));
                    b.putString("item_name_with_spaces", name.getText().toString());
                    i.putExtras(b);
                    view.getContext().startActivity(i);
                    ((Activity)view.getContext()).finish();
                }
            });
        }
    }

    public FavoriteAdapter(List<String> il){
        this.itemList = il;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.favorites_list_item, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String item = itemList.get(position);
        holder.name.setText(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setData(List<String> nameList) {
        this.itemList = nameList;
        notifyDataSetChanged();
    }

}
