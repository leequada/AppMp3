package com.example.mp3app.Controller.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.*;
import 	androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class AdapterManager extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragment = new ArrayList<>();

    public AdapterManager(FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragment.get(position);
    }

    @Override
    public int getCount() {
        return fragment.size();
    }
    public void addFragment(Fragment f){
        fragment.add(f);
    }


}
