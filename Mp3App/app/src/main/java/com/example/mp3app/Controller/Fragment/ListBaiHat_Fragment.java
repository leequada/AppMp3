package com.example.mp3app.Controller.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3app.Controller.Adapter.PlaySongAdapter;
import com.example.mp3app.R;
import com.example.mp3app.View.PlayMusicActivity;

public class ListBaiHat_Fragment extends Fragment {
    View view;
    RecyclerView recyclerViewListsong;
    PlaySongAdapter playSongAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.listbaihat_fragment,container,false);
        recyclerViewListsong = view.findViewById(R.id.RecyclerviewListSong);
        playSongAdapter = new PlaySongAdapter(getActivity(), PlayMusicActivity.arrayListSong);
        Log.d("Size",String.valueOf(PlayMusicActivity.arrayListSong.size()));
        recyclerViewListsong.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewListsong.setAdapter(playSongAdapter);
        return view;
    }
}
