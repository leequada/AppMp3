package com.example.mp3app.Controller.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3app.Model.Song;
import com.example.mp3app.R;
import com.example.mp3app.View.PlayMusicActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerListAdapter extends RecyclerView.Adapter<BannerListAdapter.Viewholder>{
    Context context;
    ArrayList<Song> arrayListBaihat ;

    public BannerListAdapter(Context context, ArrayList<Song> arrayListSong) {
        this.context = context;
        this.arrayListBaihat = arrayListSong;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.temp_displaysongfrbanner, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Song song = arrayListBaihat.get(position);

        holder.namesinger.setText(song.getCasi());
        holder.namesong.setText(song.getTenbaihat());
        Picasso.with(context).load(song.getHinhbaihat()).into(holder.imgview);
    }

    @Override
    public int getItemCount() {
        return arrayListBaihat.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView imgview;
        TextView namesong,namesinger;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imgview = itemView.findViewById(R.id.Img_temp_songfrbanner);
            namesong = itemView.findViewById(R.id.txtNamesong_temp_songfrbanner);
            namesinger = itemView.findViewById(R.id.Namesinger_temp_songfrbanner);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayMusicActivity.class);
                    intent.putExtra("music",arrayListBaihat.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
