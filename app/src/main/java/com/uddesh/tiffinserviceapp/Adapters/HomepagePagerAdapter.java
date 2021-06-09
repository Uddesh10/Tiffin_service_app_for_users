package com.uddesh.tiffinserviceapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.uddesh.tiffinserviceapp.Fragments.HomeFragment;
import com.uddesh.tiffinserviceapp.Fragments.ServiceListFragment;

public class HomepagePagerAdapter extends FragmentStateAdapter {
    public HomepagePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position)
        {
            case 0:
                fragment = HomeFragment.newInstance();
                break;
            case 1:
                fragment = ServiceListFragment.newInstance();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
