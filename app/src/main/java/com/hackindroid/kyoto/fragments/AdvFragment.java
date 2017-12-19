package com.hackindroid.kyoto.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hackindroid.kyoto.R;
import com.hackindroid.kyoto.activities.BuyActivity;
import com.hackindroid.kyoto.activities.SellActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdvFragment extends Fragment {

LinearLayout llbuy,llsell;
    public AdvFragment() {
        // Required empty public constructor
    }


    @Override
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
    }

}
