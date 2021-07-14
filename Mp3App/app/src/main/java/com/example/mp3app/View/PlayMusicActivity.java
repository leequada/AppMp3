package com.example.mp3app.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.loader.content.AsyncTaskLoader;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mp3app.Controller.Adapter.ViewPagerPlaySongAdapter;
import com.example.mp3app.Controller.Fragment.ListBaiHat_Fragment;
import com.example.mp3app.Controller.Fragment.PlayingSong_Fragment;
import com.example.mp3app.Model.Song;
import com.example.mp3app.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PlayMusicActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView txtTimeSong,txtTotalTimeSong,Namesong,Namesinger;
    SeekBar seekBar;
    ImageButton play,next,back,repeat,suff;
    ImageView love;
    ViewPager viewPager;
    PlayingSong_Fragment playingSong_fragment;
    ListBaiHat_Fragment listBaiHat_fragment;
    public static ArrayList<Song> arrayListSong = new ArrayList<>();
    public static ArrayList<String> arrayTime = new ArrayList<>();
    public static ViewPagerPlaySongAdapter viewPagerPlaySongAdapter;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Intent intent = getIntent();
        if(intent != null) {
            if (intent.hasExtra("music")) {
                Song baihat = intent.getParcelableExtra("music");
                arrayListSong.add(baihat);
                //Toast.makeText(this, baihat.getTenbaihat(), Toast.LENGTH_SHORT).show();
            }
            if (intent.hasExtra("listmusic")) {
                ArrayList<Song> arrayList = intent.getParcelableArrayListExtra("listmusic");
                arrayListSong = arrayList;
            }
        }
        init();
        eventClickListner();
    }

    private void eventClickListner() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(viewPagerPlaySongAdapter.getItem(1) != null){
                    playingSong_fragment.Playnhac(arrayListSong.get(0).getHinhbaihat());
                    handler.removeCallbacks(this);
                }else {
                    handler.postDelayed(this,300);
                }
            }
        },500);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    play.setBackgroundResource(R.drawable.ic_play_music1);
                }
            }
        });
    }

    private void getData() {

    }
    public class MediaPlay extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try{
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            });
                mediaPlayer.setDataSource(s);
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
            TimeofSong();
        }
    }

    private void TimeofSong() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        txtTotalTimeSong.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        seekBar.setMax(mediaPlayer.getDuration());
    }

    private void init() {
        toolbar = findViewById(R.id.TollbarPlayMusic);
        seekBar = findViewById(R.id.Seekbarplaymusic);
        viewPager = findViewById(R.id.ViewPagerPlaymusic);
        txtTimeSong = findViewById(R.id.txttimedisplaymusic);
        txtTotalTimeSong = findViewById(R.id.timetotalplaymusic);
        Namesong = findViewById(R.id.NamesongPlayMusic);
        Namesinger = findViewById(R.id.NameSingerPlaymusic);
        love = findViewById(R.id.LovePlaymusic);
        play = findViewById(R.id.RunPlaymusic);
        next = findViewById(R.id.NextPlaymusic);
        back = findViewById(R.id.BackPlaymusic);
        repeat = findViewById(R.id.RepeatPlaymusic);
        suff = findViewById(R.id.suffPlaymusic);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listBaiHat_fragment = new ListBaiHat_Fragment();
        playingSong_fragment = new PlayingSong_Fragment();
        viewPagerPlaySongAdapter = new ViewPagerPlaySongAdapter(getSupportFragmentManager());
        //viewPagerPlaySongAdapter.AddFragment(playingSong_fragment);
        viewPagerPlaySongAdapter.AddFragment(listBaiHat_fragment);
        viewPagerPlaySongAdapter.AddFragment(playingSong_fragment);
        viewPager.setAdapter(viewPagerPlaySongAdapter);
        playingSong_fragment = (PlayingSong_Fragment) viewPagerPlaySongAdapter.getItem(1);
        if(arrayListSong.size() > 0){
            getSupportActionBar().setTitle(arrayListSong.get(0).getTenbaihat());
            new MediaPlay().execute(arrayListSong.get(0).getLinkbaihat());
            play.setBackgroundResource(R.drawable.ic_pause);
        }

    }
}