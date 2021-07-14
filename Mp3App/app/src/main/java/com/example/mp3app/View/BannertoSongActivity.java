package com.example.mp3app.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mp3app.Controller.Adapter.BannerListAdapter;
import com.example.mp3app.Controller.Service.API_IMPLEMENT;
import com.example.mp3app.Controller.Service.DataSevice;
import com.example.mp3app.Model.Playlist;
import com.example.mp3app.Model.Quangcao;
import com.example.mp3app.Model.Song;
import com.example.mp3app.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BannertoSongActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    Playlist playlist;
    Quangcao quangcao;
    ImageView imageView;
    TextView textView;
    BannerListAdapter bannerListAdapter;
    ArrayList<Song> arrays, arSong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bannerto_song);
        coordinatorLayout = findViewById(R.id.cdl_bannertoSong);
        collapsingToolbarLayout = findViewById(R.id.CTL_BannertoSong);
        toolbar = findViewById(R.id.Tb_BannertoSong);
        textView = findViewById(R.id.TextNameSongBannerFrSong);
        recyclerView = findViewById(R.id.rcv_bannertoSong);
        floatingActionButton = findViewById(R.id.Fab_bannertoSong);
        imageView = findViewById(R.id.img_BannertoSong);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        IntentData();
        Init();
        if(quangcao != null && !quangcao.getNamesong().equals(" ")){
            setValuetoView(quangcao.getNamesong(),quangcao.getImage());
            getDataQuangCao(quangcao.getIdqc());
        }
        if(playlist != null && !playlist.getNamelaylist().equals(" ")){
            setValuetoView(playlist.getNamelaylist(),playlist.getHinhanhlaylist());
            getDataPlaylist(playlist.getIdplaylist());
        }
    }

    private void getDataPlaylist(String idplaylist) {
        DataSevice dataSevice = API_IMPLEMENT.getService();
        Call<List<Song>> callback = dataSevice.getListSongfrPlaylist(idplaylist);
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                arrays= (ArrayList<Song>) response.body();
                bannerListAdapter = new BannerListAdapter(BannertoSongActivity.this,arrays);
                recyclerView.setLayoutManager(new LinearLayoutManager(BannertoSongActivity.this));
                recyclerView.setAdapter(bannerListAdapter);
                onClick();

            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }

    private void setValuetoView(String ten , String img) {
        //collapsingToolbarLayout.setTitle(null);
        textView.setText(ten);

        try {
            URL url =  new URL(img);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable   = new BitmapDrawable(getResources(),bitmap);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                collapsingToolbarLayout.setBackground(bitmapDrawable);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(img).into(imageView);
    }

    private void getDataQuangCao(String id) {
        DataSevice dataSevice = API_IMPLEMENT.getService();
        Call<List<Song>> callback = dataSevice.getListSongfrBanner(id);
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                arSong =(ArrayList<Song>) response.body();
                bannerListAdapter = new BannerListAdapter(BannertoSongActivity.this,arSong);
                recyclerView.setLayoutManager(new LinearLayoutManager(BannertoSongActivity.this));
                recyclerView.setAdapter(bannerListAdapter);
                onClickQuangCao();
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }

    private void onClickQuangCao() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BannertoSongActivity.this,PlayMusicActivity.class);
                intent.putExtra("listmusic", arSong);
                startActivity(intent);
            }
        });
    }

    private void Init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }

        });

    }



    private void IntentData() {
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("Banner")){
                quangcao = (Quangcao) intent.getSerializableExtra("Banner");
                Toast.makeText(this, quangcao.getNamesong(), Toast.LENGTH_SHORT).show();

            }
            if(intent.hasExtra("itemplaylist")){
                playlist = (Playlist) intent.getSerializableExtra("itemplaylist");
            }
        }
        }
    private void onClick(){

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BannertoSongActivity.this,PlayMusicActivity.class);
                intent.putExtra("listmusic", arrays);
                startActivity(intent);
            }
        });
    }

}