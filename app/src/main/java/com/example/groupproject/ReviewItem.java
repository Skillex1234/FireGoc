package com.example.groupproject;

public class ReviewItem {
    private String reviewText;
    private float reviewScore;

    ReviewItem(){}

    ReviewItem(String t, float s){
        reviewText = t;
        reviewScore = s;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public float getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(float reviewScore) {
        this.reviewScore = reviewScore;
    }
}
