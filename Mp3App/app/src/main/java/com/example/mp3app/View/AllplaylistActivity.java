package com.example.mp3app.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.mp3app.Controller.Adapter.AllplaylistAdapter;
import com.example.mp3app.Controller.Service.API_IMPLEMENT;
import com.example.mp3app.Controller.Service.DataSevice;
import com.example.mp3app.Model.Playlist;
import com.example.mp3app.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllplaylistActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    ArrayList<Playlist> playlistArrayList;
    AllplaylistAdapter allplaylistAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allplaylist);
        toolbar = findViewById(R.id.Toolbar_allplaylist);
        recyclerView = findViewById(R.id.RecyclerviewAllplaylist);
        init();
        getData();
    }

    private void getData() {
        DataSevice dataSevice = API_IMPLEMENT.getService();
        Call<List<Playlist>> callback = dataSevice.getDataAllPlaylist();
        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                playlistArrayList =(ArrayList<Playlist>) response.body();
                allplaylistAdapter = new AllplaylistAdapter(AllplaylistActivity.this, playlistArrayList);
                recyclerView.setLayoutManager(new LinearLayoutManager(AllplaylistActivity.this));
                recyclerView.setAdapter(allplaylistAdapter);
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Play list");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}