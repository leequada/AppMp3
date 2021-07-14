package com.example.mp3app.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.mp3app.Controller.Adapter.AdapterManager;
import com.example.mp3app.Controller.Fragment.Home_Fragment;
import com.example.mp3app.Controller.Fragment.Search_Fragment;
import com.example.mp3app.R;
    import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tab;
    ViewPager view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
    }

    private void anhxa() {
        tab = findViewById(R.id.Tablayout);
        view = findViewById(R.id.ViewPager);
    }

    private void init() {
        AdapterManager adapter = new AdapterManager(getSupportFragmentManager());
        adapter.addFragment(new Home_Fragment());
        adapter.addFragment(new Search_Fragment());
        view.setAdapter(adapter);
        tab.setupWithViewPager(view);
        tab.getTabAt(0).setIcon(R.drawable.ic_home);
        tab.getTabAt(1).setIcon(R.drawable.ic_search);
    }

}