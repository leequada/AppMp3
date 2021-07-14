package com.example.mp3app.Controller.Adapter;

import android.content.Context;
import android.content.Intent;
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

public class LikeAdapter extends RecyclerView.Adapter<LikeAdapter.Viewholder>{
    Context context;
    ArrayList<Song> arrayList;

    public LikeAdapter(Context context, ArrayList<Song> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.temp_mostlike, parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Song song = arrayList.get(position);
        holder.txtName.setText(song.getTenbaihat());
        holder.txtSinger.setText(song.getCasi());
        Picasso.with(context).load(song.getHinhbaihat()).into(holder.imageSong);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView txtName,txtSinger;
        ImageView imageSong,imageLike;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.TextViewNameSong);
            txtSinger = itemView.findViewById(R.id.TextNameSinger);
            imageSong = itemView.findViewById(R.id.ImageMostlike);
            imageLike = itemView.findViewById(R.id.luotthich);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayMusicActivity.class);
                    intent.putExtra("music",arrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
