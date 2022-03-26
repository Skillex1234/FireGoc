package com.example.groupproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Description extends Fragment {

    TextView textViewDescription;

    public Description() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_description, container, false);

        textViewDescription = (TextView) view.findViewById(R.id.textViewDescription);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = firebaseDatabase.getReference();

        String itemLoc = this.getArguments().getString("itemLocation");

        DatabaseReference getDesc = dbRef.child("Items").child(itemLoc).child("Description");
        getDesc.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    DataSnapshot snapshot = task.getResult();
                    String text = snapshot.getValue(String.class);
                    textViewDescription.setText(text);
                } else {
                    Toast.makeText(getActivity(), "Error Retrieving Description", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}