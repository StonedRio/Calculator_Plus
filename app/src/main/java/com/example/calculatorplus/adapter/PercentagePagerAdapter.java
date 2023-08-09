package com.example.calculatorplus.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.calculatorplus.fragments.CompleteFragment;
import com.example.calculatorplus.fragments.DecreaseFragment;
import com.example.calculatorplus.fragments.IncreaseFragment;
import com.example.calculatorplus.fragments.SimpleFragment;

public class PercentagePagerAdapter extends FragmentStateAdapter {

    public PercentagePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return the appropriate fragment based on the position
        switch (position) {
            case 0:

                return new SimpleFragment();
            case 1:
                return new IncreaseFragment();
            case 2:
                return new DecreaseFragment();
            case 3:
                return new CompleteFragment();
            default:
                return new SimpleFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4; // Number of pages in the ViewPager
    }
}
