package com.example.dictioneryapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class wordMeaningActivity extends AppCompatActivity {
    private Toolbar toolbar;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_meaning);
        getSupportActionBar().setTitle("English words");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        }
        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewPager);
        if (viewPager==null){
            setUpViewPager(viewPager);
        }
        TabLayout tabLayout=findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }


    public class viewPagerAdapter extends FragmentPagerAdapter {
     private final List<Fragment>mFragmentList=new ArrayList<>();
     private final List<String>mStringTitle=new ArrayList<>();

        public viewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addArg(Fragment fragment,String title){
            mFragmentList.add(fragment);
            mStringTitle.add(title);

        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mStringTitle.get(position);
        }
    }
    private void setUpViewPager(ViewPager viewPager){
        viewPagerAdapter adapter=new viewPagerAdapter(getSupportFragmentManager());
        adapter.addArg(new MeaningFragment(),"Meaning");
        adapter.addArg(new synonymFragment(),"Synonyme");
        adapter.addArg(new AntonymeFragment(),"Antonyme");
        adapter.addArg(new ExampleFragment(),"Example");
        viewPager.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if (item.getItemId()==R.id.home){
                onBackPressed();
            }
        return super.onOptionsItemSelected(item);
    }
}