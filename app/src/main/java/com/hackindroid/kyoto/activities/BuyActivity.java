package com.hackindroid.kyoto.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hackindroid.kyoto.R;
import com.hackindroid.kyoto.adapters.RecyclerAdAdapter;
import com.hackindroid.kyoto.models.AdDetails;

import java.util.ArrayList;

public class BuyActivity extends AppCompatActivity {
    /*RecyclerView rvAds;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    ArrayList<AdDetails> detailsArrayList = new ArrayList<>();
    RecyclerAdAdapter recyclerAdAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_buy);
        rvAds = findViewById(R.id.rvAds);
       recyclerAdAdapter = new RecyclerAdAdapter(BuyActivity.this,detailsArrayList);
        rvAds.setLayoutManager(new LinearLayoutManager(BuyActivity.this));
        rvAds.setAdapter(recyclerAdAdapter);
        initFirebase();
        addEventFirebaseListener();
    }
    private void addEventFirebaseListener() {

        mDatabaseReference.child("Ads").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                *//*if(list_users.size() > 0)
                    list_users.clear();*//*
                for(DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                    AdDetails adDetails = postSnapshot.getValue(AdDetails.class);
                    detailsArrayList.add(adDetails);
                    //Log.e("TAG","inside"+adDetails.getName());
                }
                recyclerAdAdapter.updateDetails(detailsArrayList);
               // Log.e("TAG","hi");

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
               // Log.e("TAG","Get Lost");
            }
        });
    }
    private void initFirebase() {
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference  = mFirebaseDatabase.getReference();
    }*/

}
