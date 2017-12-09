package com.hackindroid.kyoto.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hackindroid.kyoto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResourceFragment extends Fragment {

    TabLayout tabLayout;
    FragmentManager fragmentManager;
    ImageView ivBooks, ivNotes, ivQPapers, ivPracticals;

    public ResourceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View resourceFragmentView = inflater.inflate(R.layout.fragment_resource, container, false);


        fragmentManager = getActivity().getSupportFragmentManager();


        resourceFragmentView.findViewById(R.id.image_notes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fl_resources, new NotesFragment())
                        .commit();
            }
        });

        resourceFragmentView.findViewById(R.id.image_books).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fl_resources, new BooksFragment())
                        .commit();
            }
        });

        resourceFragmentView.findViewById(R.id.image_QPapers).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fl_resources, new QPaperFragment())
                        .commit();
            }
        });

        resourceFragmentView.findViewById(R.id.image_Practicals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fl_resources, new PracticalsFragment())
                        .commit();
            }
        });


//        tabLayout = resourceFragmentView.findViewById(R.id.tab_Resources);

//
//        FragmentPagerAdapter adapter = new FragmentPagerAdapter(fragmentManager) {
//            @Override
//            public Fragment getItem(int position) {
//                Fragment fragment = null;
//                if (position == 0) {
//                    fragment =  new NotesFragment();
//                } else if (position == 1) {
//                    fragment = new BooksFragment();
//                } else if (position == 2) {
//                    fragment = new QPaperFragment();
//                }
//                return fragment;
//            }
//
//            @Override
//            public int getCount() {
//                return 3;
//            }
//
//
//        };


//        ViewPager viewPager = resourceFragmentView.findViewById(R.id.view_pager);
//        viewPager.setAdapter(adapter);
//
//        tabLayout.setupWithViewPager(viewPager);
//
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_home_black_24dp);
//        tabLayout.getTabAt(2).setIcon(R.drawable.ic_home_black_24dp);

        return resourceFragmentView;
    }

}
