package com.example.mp3app.Controller.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3app.Model.Album;
import com.example.mp3app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    Context context;
    ArrayList<Album> arrayListAlbum;

    public AlbumAdapter(Context context, ArrayList<Album> arrayListAlbum) {
        this.context = context;
        this.arrayListAlbum = arrayListAlbum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.temp_album,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = arrayListAlbum.get(position);
        holder.name.setText(album.getTenalbum());
        holder.casi.setText(album.getCasi());
        Picasso.with(context).load(album.getHinhanh()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return arrayListAlbum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,casi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ImgviewAlbum);
            name = itemView.findViewById(R.id.TextNameAlbuum);
            casi = itemView.findViewById(R.id.NameSingerAlbum);
        }
    }
}
