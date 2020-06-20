package com.example.watcho;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.watcho.Fragments.Channels;
import com.example.watcho.Fragments.CustomerSupport;
import com.example.watcho.Fragments.Friends;
import com.example.watcho.Fragments.MyRoom;
import com.example.watcho.Fragments.News;
import com.example.watcho.Fragments.Premium;
import com.example.watcho.Fragments.Shows;
import com.example.watcho.Fragments.Spotlight;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Browse extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private Channels channels;
    private News news;
    private Premium premium;
    private Shows shows;
    private Spotlight spotlight;
    private CustomerSupport customerSupport;
    private Friends friends;
    private MyRoom myRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabLayout);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.browse);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.browse: return true;
                    case R.id.downloads:
                        startActivity(new Intent(getApplicationContext(), Downloads.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(), Search.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.more:
                        startActivity(new Intent(getApplicationContext(), More.class));
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });


        channels = new Channels();
        news = new News();
        premium = new Premium();
        shows = new Shows();
        spotlight = new Spotlight();
        customerSupport = new CustomerSupport();
        friends = new Friends();
        myRoom = new MyRoom();

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(premium, getString(R.string.premium));
        viewPagerAdapter.addFragment(shows, getString(R.string.shows));
        viewPagerAdapter.addFragment(friends, getString(R.string.friends));
        viewPagerAdapter.addFragment(myRoom, getString(R.string.my_room));
        viewPagerAdapter.addFragment(channels, getString(R.string.channels));
        viewPagerAdapter.addFragment(spotlight, getString(R.string.spotlight));
        viewPagerAdapter.addFragment(news, getString(R.string.news));
        viewPagerAdapter.addFragment(customerSupport,getString(R.string.customer_support));

        viewPager.setAdapter(viewPagerAdapter);
    }

    private static class ViewPagerAdapter extends FragmentPagerAdapter {


        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragment_titles = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        private void addFragment(Fragment fragment, String title)
        {
            fragments.add(fragment);
            fragment_titles.add(title);
        }


        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragment_titles.get(position);
        }
    }
}
