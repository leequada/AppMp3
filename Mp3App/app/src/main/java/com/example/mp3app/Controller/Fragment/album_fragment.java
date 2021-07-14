package com.example.mp3app.Controller.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3app.Controller.Adapter.AlbumAdapter;
import com.example.mp3app.Controller.Service.API_IMPLEMENT;
import com.example.mp3app.Controller.Service.DataSevice;
import com.example.mp3app.Model.Album;
import com.example.mp3app.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class album_fragment extends Fragment {
    View view ;
    RecyclerView recyclerView;
    TextView textView;
    AlbumAdapter albumAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.album_fragment,container,false);
        recyclerView = view.findViewById(R.id.RecyclerviewAlbum);
        textView = view.findViewById(R.id.TextXemthemAlbum);
        getData();
        return view;
    }

    private void getData() {
        DataSevice dataSevice = API_IMPLEMENT.getService();
        Call<List<Album>> callback = dataSevice.getDataAlbum();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> albums = (ArrayList<Album>) response.body();
                albumAdapter = new AlbumAdapter(getActivity(), albums);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(albumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
}
