package com.uddesh.tiffinserviceapp.Activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.uddesh.tiffinserviceapp.Adapters.HomepagePagerAdapter;
import com.uddesh.tiffinserviceapp.R;

public class HomePageActivity extends FragmentActivity {
    ViewPager2 viewPager;
    FragmentStateAdapter pagerAdapter;
    TabLayout tabLayout;
    final int[] tabDrawables = {R.drawable.ic_home , R.drawable.ic_search};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        initializeComponents();
        tabMediator();
    }

    // private functions

    private void initializeComponents()
    {
        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new HomepagePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        tabLayout = findViewById(R.id.tab_layout);
    }

    private void tabMediator()
    {
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setIcon(tabDrawables[position]);
            }
        }).attach();
    }
}