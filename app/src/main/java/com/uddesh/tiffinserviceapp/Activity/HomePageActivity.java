package com.uddesh.tiffinserviceapp.Activity;


import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.uddesh.tiffinserviceapp.Adapters.HomepagePagerAdapter;
import com.uddesh.tiffinserviceapp.R;

public class HomePageActivity extends FragmentActivity {
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;
    private TabLayout tabLayout;
    private TextView homepageTabTextView;
    private ImageView homepageTabSettingsImageView;
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
        homepageTabSettingsImageView = findViewById(R.id.homepageTabSettingsImageView);
        homepageTabTextView = findViewById(R.id.homepageTabTextview);
    }

    private void tabMediator()
    {
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setIcon(tabDrawables[position])).attach();
    }
}