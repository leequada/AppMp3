package com.example.mp3app.Controller.Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3app.Model.Song;
import com.example.mp3app.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PlaySongAdapter extends RecyclerView.Adapter<PlaySongAdapter.ViewHolder>{
    Context context;
    ArrayList<Song> arraySong;
    ArrayList<String> timeDisplay;
    MediaPlayer media;
    public PlaySongAdapter(Context context, ArrayList<Song> arraySong) {
        this.context = context;
        this.arraySong = arraySong;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.temp_listsong,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = arraySong.get(position);
        holder.nameSinger.setText(song.getCasi());
        holder.nameSong.setText(song.getTenbaihat());
        holder.stt.setText(position + 1 + "");
        media = new MediaPlayer();
        try {
            media.reset();
            media.setDataSource(song.getLinkbaihat());
            media.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        holder.timeTotal.setText(simpleDateFormat.format(media.getDuration()));

    }

    @Override
    public int getItemCount() {
        return arraySong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView stt,nameSong,nameSinger,timeTotal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stt = itemView.findViewById(R.id.txtViewPlaynhac);
            nameSong = itemView.findViewById(R.id.TextViewNameSong_Playnhac);
            nameSinger = itemView.findViewById(R.id.txtNameSinger_Playnhac);
            timeTotal = itemView.findViewById(R.id.txtTotalTime_Playnhac);
        }
    }
}
