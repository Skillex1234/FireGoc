package com.example.groupproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Reviews extends Fragment {
    private RecyclerView recyclerView;
    private ReviewAdapter adapter;
    private FirebaseDatabase db;
    private  DatabaseReference dbRef;
    /*private DatabaseReference itemScore;
    private DatabaseReference itemRevText;
    private ArrayList<String> scores = new ArrayList<>();
    private ArrayList<String> revs = new ArrayList<>();*/

    Button submitReview;
    RatingBar ratingScore;
    EditText reviewText;

    public Reviews() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reviews, container, false);

        String itemName = this.getArguments().getString("itemLocation");

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewReviews);
        adapter = new ReviewAdapter(ItemPage.revList);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference();
        /*itemScore = dbRef.child("Items").child(itemName).child("reviewScoreList");
        itemScore.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    String score = ds.getValue(Long.class).toString();
                    scores.add(score);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        itemRevText = dbRef.child("Items").child(itemName).child("reviewTextList");
        itemRevText.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    String rev = ds.getValue(String.class);
                    revs.add(rev);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        for(int i = 0; i < ItemPage.scores.size(); i++){
            ItemPage.revList.add(new ReviewItem(ItemPage.revs.get(i), Float.valueOf(ItemPage.scores.get(i))));
        }

        ratingScore = (RatingBar) view.findViewById(R.id.ratingBarReviewScore);
        reviewText = (EditText) view.findViewById(R.id.editTextReviewText);

        submitReview = (Button) view.findViewById(R.id.buttonSubmitReview);
        submitReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keyScore = dbRef.child("Items").child(itemName).child("reviewScoreList").push().getKey();
                String keyText = dbRef.child("Items").child(itemName).child("reviewTextList").push().getKey();

                Map<String, Object> scoreMap = new HashMap<>();
                Map<String, Object> textMap = new HashMap<>();

                scoreMap.put(keyScore, ratingScore.getRating());
                textMap.put(keyText, reviewText.getText().toString());

                dbRef.child("Items").child(itemName).child("reviewScoreList").updateChildren(scoreMap);
                dbRef.child("Items").child(itemName).child("reviewTextList").updateChildren(textMap);

                ItemPage.revList.add(new ReviewItem(reviewText.getText().toString(), ratingScore.getRating()));
                adapter.notifyDataSetChanged();

                reviewText.setText("");
                ratingScore.setRating(0);
            }
        });

        return view;
    }

}