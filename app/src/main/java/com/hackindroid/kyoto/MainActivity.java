package com.hackindroid.kyoto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hackindroid.kyoto.activities.SellActivity;
import com.hackindroid.kyoto.fragments.AdvFragment;
import com.hackindroid.kyoto.fragments.BooksFragment;
import com.hackindroid.kyoto.fragments.NotesFragment;
import com.hackindroid.kyoto.fragments.PracticalsFragment;
import com.hackindroid.kyoto.fragments.QPaperFragment;
import com.hackindroid.kyoto.fragments.SettingsFragment;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    public static final String BUY_SELL_FRAG_TAG = "buysell";
    FragmentManager fragmentManager;
    TabLayout tabLayout;
    ViewPager viewPager;
    Fragment fragment;
    LinearLayout mainLayout;
    SearchView searchView;
//    FrameLayout flMain;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_resources:
                    tabLayout.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(View.VISIBLE);
                    fragmentManager.beginTransaction()
                            .remove(fragment)
                            .commit();
                    fragment = null;
                    return true;
                case R.id.navigation_buy_sell:
                    fragment = new AdvFragment();
                    tabLayout.setVisibility(GONE);
                    viewPager.setVisibility(GONE);
                    fragmentManager.beginTransaction()
                            .replace(R.id.main_layout, fragment,BUY_SELL_FRAG_TAG)
                            .commit();
                    return true;
                case R.id.navigation_settings:
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
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("Yooo", "onQueryTextSubmit: " + query);
                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("Yooo", "onQueryTextSubmit: " + newText);
                if(fragment == null){
                    //MainActivity
                }
                else if(fragment.getTag().equals(BUY_SELL_FRAG_TAG)) {
                    ((AdvFragment)fragment).setFilter();
                }
                return false;
            }


        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_search:
                Toast.makeText(this, "onOptionsItemSelected : Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_add:
            case R.id.action_add_collapse:
                if(fragment == null){
                    //MainActivity
                }
                else if(fragment.getTag().equals(BUY_SELL_FRAG_TAG)){
                    startActivity(new Intent(MainActivity.this, SellActivity.class));
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
        }  else {
            moveTaskToBack(true);
//            super.onBackPressed();
        }
    }

}
