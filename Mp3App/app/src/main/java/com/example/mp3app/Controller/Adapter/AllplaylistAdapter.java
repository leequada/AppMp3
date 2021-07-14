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

import com.example.mp3app.Model.Playlist;
import com.example.mp3app.R;
import com.example.mp3app.View.BannertoSongActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AllplaylistAdapter extends RecyclerView.Adapter<AllplaylistAdapter.ViewHolder>{
    Context context;
    ArrayList<Playlist> playlists;

    public AllplaylistAdapter(Context context, ArrayList<Playlist> playlists) {
        this.context = context;
        this.playlists = playlists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.temp_allplaylist, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Playlist playlist = playlists.get(position);

        holder.NamePlaylist.setText(playlist.getNamelaylist());
        Picasso.with(context).load(playlist.getHinhanhlaylist()).into(holder.BackgroundPlaylist);
        Picasso.with(context).load(playlist.getIconplaylist()).into(holder.Iconplaylist);
    }

    @Override
    public int getItemCount() {
        return playlists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView NamePlaylist;
        ImageView BackgroundPlaylist , Iconplaylist;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            NamePlaylist = itemView.findViewById(R.id.NameSongAllPlaylist);
            BackgroundPlaylist = itemView.findViewById(R.id.ImgageViewAllplaylist);
            Iconplaylist = itemView.findViewById(R.id.imgViewContentAllPlaylist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,BannertoSongActivity.class);
                    intent.putExtra("itemplaylist", playlists.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
