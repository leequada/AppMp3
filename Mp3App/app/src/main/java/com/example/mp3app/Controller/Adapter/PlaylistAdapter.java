package com.example.mp3app.Controller.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mp3app.Model.Playlist;
import com.example.mp3app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
        public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);
    }
    class ListPlaylistView {
            TextView nameSong;
            ImageView iconPlaylist,imagePlaylist;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ListPlaylistView playlistview = null ;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.temp_playlist, null);
            playlistview = new ListPlaylistView();

            playlistview.nameSong = convertView.findViewById(R.id.NameSongPlaylist);
            playlistview.iconPlaylist=convertView.findViewById(R.id.imgViewContentPlaylist);
            playlistview.imagePlaylist=convertView.findViewById(R.id.ImgageButtonBack);

            convertView.setTag(playlistview);
        }else{
            playlistview= (ListPlaylistView) convertView.getTag();
        }
        Playlist playlist = getItem(position);
        Picasso.with(getContext()).load(playlist.getHinhanhlaylist()).into(playlistview.imagePlaylist);
        Picasso.with(getContext()).load(playlist.getIconplaylist()).into(playlistview.iconPlaylist);

        playlistview.nameSong.setText(playlist.getNamelaylist());

        return  convertView;
    }
}
