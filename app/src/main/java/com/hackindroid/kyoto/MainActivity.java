package com.hackindroid.kyoto;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hackindroid.kyoto.fragments.AdvFragment;
import com.hackindroid.kyoto.fragments.BooksFragment;
import com.hackindroid.kyoto.fragments.NotesFragment;
import com.hackindroid.kyoto.fragments.PracticalsFragment;
import com.hackindroid.kyoto.fragments.QPaperFragment;
import com.hackindroid.kyoto.fragments.ResourceFragment;
import com.hackindroid.kyoto.fragments.SettingsFragment;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    TabLayout tabLayout;
    ViewPager viewPager;
    Fragment fragment;
    LinearLayout mainLayout;
//    FrameLayout flMain;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    tabLayout.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.VISIBLE);
                    fragmentManager.beginTransaction()
                            .remove(fragment)
                            .commit();
                    return true;
                case R.id.navigation_dashboard:
                    fragment = new AdvFragment();
                    tabLayout.setVisibility(GONE);
                    viewPager.setVisibility(GONE);
                    fragmentManager.beginTransaction()
                            .replace(R.id.main_layout, fragment)
                            .commit();
                    return true;
                case R.id.navigation_notifications:
                    tabLayout.setVisibility(GONE);
                    viewPager.setVisibility(GONE);
                    fragment = new SettingsFragment();
                    fragmentManager.beginTransaction()
                            .replace(R.id.main_layout, fragment)
                            .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fragment manager
        fragmentManager = getSupportFragmentManager();

        //Relative Layout
        mainLayout = findViewById(R.id.main_layout);
//        flMain = findViewById(R.id.fl_main);

//        fragmentManager.beginTransaction()
//                .replace(R.id.main_layout, new ResourceFragment())
//                .commit();



        tabLayout = findViewById(R.id.tab_Resources);

//
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                if (position == 0) {
                    fragment =  new NotesFragment();
                } else if (position == 1) {
                    fragment = new BooksFragment();
                } else if (position == 2) {
                    fragment = new QPaperFragment();
                } else if (position == 3) {
                    fragment = new PracticalsFragment();
                }
                return fragment;
            }
//
            @Override
            public int getCount() {
                return 4;
            }

        };

//        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
//                getSupportFragmentManager(), FragmentPagerItems.with(this)
//                .add("Notes", NotesFragment.class)
//                .add("Books", BooksFragment.class)
//                .add("Q-Paper", QPaperFragment.class)
//                .add("Practicals", PracticalsFragment.class)
//                .create());


        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);

//        SmartTabLayout viewPagerTab = findViewById(R.id.view_pager_tab);
//        viewPagerTab.setViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Notes");
        tabLayout.getTabAt(1).setText("Books");
        tabLayout.getTabAt(2).setText("Q-Papers");
        tabLayout.getTabAt(3).setText("Practicals");

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
