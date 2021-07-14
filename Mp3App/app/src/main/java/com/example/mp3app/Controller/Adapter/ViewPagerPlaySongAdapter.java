package com.example.mp3app.Controller.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mp3app.Model.Song;

import java.util.ArrayList;

public class ViewPagerPlaySongAdapter extends FragmentPagerAdapter {

    public final ArrayList<Fragment> fragments = new ArrayList<>();
    public ViewPagerPlaySongAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    public  void AddFragment(Fragment fr){
        fragments.add(fr);
    }
}
