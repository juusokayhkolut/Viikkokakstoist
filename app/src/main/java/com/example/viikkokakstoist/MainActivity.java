package com.example.viikkokakstoist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup TabLayout with ViewPager2
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(this);
        ViewPager2 viewArea = findViewById(R.id.viewArea);
        viewArea.setAdapter(tabPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewArea,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Main");
                            break;
                        case 1:
                            tab.setText("Add");
                            break;
                        case 2:
                            tab.setText("All");
                            break;
                    }
                }).attach();

        BottomFragment bottomFragment = new BottomFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameBottom, bottomFragment)
                .commit();

    }
}
