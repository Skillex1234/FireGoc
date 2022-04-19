package com.example.groupproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.MyViewHolder> {
    private List<ReviewItem> reviewList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public RatingBar rating;
        public EditText reviewText;


        public MyViewHolder(View view){
            super(view);
            rating = (RatingBar) view.findViewById(R.id.ratingBarReviewItemScore);
            reviewText = (EditText) view.findViewById(R.id.editTextReviewItemText);
        }
    }

    public ReviewAdapter(List<ReviewItem> reviewList){
        this.reviewList = reviewList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.review_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        float ratingScore = reviewList.get(position).getReviewScore();
        String reviewText = reviewList.get(position).getReviewText();

        holder.rating.setRating(ratingScore);
        holder.reviewText.setText(reviewText);
    }

    @Override
    public int getItemCount(){
        return reviewList.size();
    }

}
