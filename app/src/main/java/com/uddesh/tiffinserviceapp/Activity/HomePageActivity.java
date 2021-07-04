package com.uddesh.tiffinserviceapp.Activity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.uddesh.tiffinserviceapp.Adapters.HomepagePagerAdapter;
import com.uddesh.tiffinserviceapp.Helpers.SharedPreferencesHelper;
import com.uddesh.tiffinserviceapp.Helpers.ToastHelper;
import com.uddesh.tiffinserviceapp.R;

public class HomePageActivity extends FragmentActivity {
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private ImageView homepageTabSettingsImageView;
    final int[] tabDrawables = {R.drawable.ic_home , R.drawable.ic_search};
    private SharedPreferencesHelper sharedPreferences;
    private ToastHelper toast;
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
        toast = new ToastHelper(this);
        viewPager = findViewById(R.id.view_pager);
        FragmentStateAdapter pagerAdapter = new HomepagePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        tabLayout = findViewById(R.id.tab_layout);
        homepageTabSettingsImageView = findViewById(R.id.homepageTabSettingsImageView);
        TextView homepageTabTextView = findViewById(R.id.homepageTabTextview);
        sharedPreferences = new SharedPreferencesHelper(this);
        String username = "Welcome!\n"+sharedPreferences.getSharedPreferences("username");
        homepageTabTextView.setText(username);
        homepageTabSettingsImageView.setOnClickListener(v-> openMenu());
    }

    @SuppressLint("NonConstantResourceId")
    private void openMenu() {
        PopupMenu popupMenu = new PopupMenu(this , homepageTabSettingsImageView);
        popupMenu.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()){
                case R.id.changeLocation:
                    Intent intent = new Intent(getApplication() , SetAddressActivity.class);
                    startActivity(intent);
                    break;
                case R.id.logout:
                    sharedPreferences.setSharedPreferences("loggedIn" , "false");
                    toast.makeToast("logged out successfully" , Toast.LENGTH_LONG);
                    Intent intent1 = new Intent(getApplication() , MainActivity.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent1);
                    finish();
                    break;
            }
            return false;
        });
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }

    private void tabMediator()
    {
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setIcon(tabDrawables[position])).attach();
    }
}