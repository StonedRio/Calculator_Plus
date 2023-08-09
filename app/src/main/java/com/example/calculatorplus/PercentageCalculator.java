package com.example.calculatorplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.calculatorplus.adapter.PercentagePagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class PercentageCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.percentage_calculator);

        TabLayout tabLayout=findViewById(R.id.tab_layout);
        ViewPager2 viewPager=findViewById(R.id.view_pager);


        PercentagePagerAdapter pagerAdapter = new PercentagePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);


        // Set the TabLayout text and background color based on the selected fragment
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.secondry));
                        updateNotificationBarColor(getResources().getColor(R.color.secondry));
                        break;
                    case 1:
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.secondry2));
                        updateNotificationBarColor(getResources().getColor(R.color.secondry2));
                        break;
                    case 2:
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.secondry3));
                        updateNotificationBarColor(getResources().getColor(R.color.secondry3));
                        break;
                    case 3:
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.secondry4));
                        updateNotificationBarColor(getResources().getColor(R.color.secondry4));
                        break;
                    default:
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.secondry));
                        updateNotificationBarColor(getResources().getColor(R.color.secondry));
                        break;
                }
            }
        });


        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    // Set the tab text based on the position
                    switch (position) {
                        case 0:
                            tab.setText("Simple");
                            break;
                        case 1:
                            tab.setText("Increase +5");
                            break;
                        case 2:
                            tab.setText("Decrease -5");
                            break;
                        case 3:
                            tab.setText("Complete");
                            break;
                        default:
                            tab.setText("Page " + (position + 1));
                            break;
                    }
                }).attach();

    }


    private void updateNotificationBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }


}