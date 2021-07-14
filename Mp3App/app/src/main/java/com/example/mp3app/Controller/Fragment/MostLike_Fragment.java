package com.example.mp3app.Controller.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3app.Controller.Adapter.LikeAdapter;
import com.example.mp3app.Controller.Service.API_IMPLEMENT;
import com.example.mp3app.Controller.Service.DataSevice;
import com.example.mp3app.Model.Song;
import com.example.mp3app.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostLike_Fragment extends Fragment {
    View view;
    RecyclerView recycler;
    LikeAdapter likeAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mostlike_fragment,container,false);
        recycler = view.findViewById(R.id.RecyclerviewLike);
        getData();
        return view;
    }

    private void getData() {
        DataSevice dataSevice = API_IMPLEMENT.getService();
        Call<List<Song>> callback = dataSevice.getDataSong();
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                ArrayList<Song> arrayListSong = (ArrayList<Song>) response.body();
                likeAdapter = new LikeAdapter(getActivity(),arrayListSong);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recycler.setLayoutManager(linearLayoutManager);
                recycler.setAdapter(likeAdapter);
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }
}
