package com.hackindroid.kyoto.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hackindroid.kyoto.R;
import com.hackindroid.kyoto.adapters.RecyclerAdAdapter;
import com.hackindroid.kyoto.models.AdDetails;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdvFragment extends Fragment {

    RecyclerView rvAds;
    ArrayList<AdDetails> detailsArrayList = new ArrayList<>();
    RecyclerAdAdapter recyclerAdAdapter;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    public AdvFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_buy, container, false);
        rvAds = view.findViewById(R.id.rvAds);
        recyclerAdAdapter = new RecyclerAdAdapter(getContext(), detailsArrayList);
        rvAds.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAds.setAdapter(recyclerAdAdapter);
        initFirebase();
        addEventFirebaseListener();
        return view;
    }

    private void addEventFirebaseListener() {

        mDatabaseReference.child("Ads").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /*if(list_users.size() > 0)
                    list_users.clear();*/
                detailsArrayList = new ArrayList<>();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    AdDetails adDetails = postSnapshot.getValue(AdDetails.class);
                    detailsArrayList.add(adDetails);
                    //Log.e("TAG","inside"+adDetails.getName());
                }
                recyclerAdAdapter.updateDetails(detailsArrayList, RecyclerAdAdapter.RESET_FILTER);
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
        mDatabaseReference = mFirebaseDatabase.getReference();
    }


    public void setFilter(){
        //TODO:
    }
}



    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_adv, container, false);
        llbuy = rootView.findViewById(R.id.llbuy);
        llsell = rootView.findViewById(R.id.llsell);
        llbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), BuyActivity.class));
            }
        });
        llsell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SellActivity.class));
            }
        });
        return rootView;
    }*/

