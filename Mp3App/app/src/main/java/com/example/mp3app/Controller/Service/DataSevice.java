package com.example.mp3app.Controller.Service;

import com.example.mp3app.Model.Album;
import com.example.mp3app.Model.ChudevaTheloai;
import com.example.mp3app.Model.Playlist;
import com.example.mp3app.Model.Quangcao;
import com.example.mp3app.Model.Song;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataSevice {
    @GET("bannerQC.php")
    Call<List<Quangcao>> getData();

    @GET("PlaylistDAO.php")
    Call<List<Playlist>>  getDataPlaylist();

    @GET("ChudeandTheLoaiDAO.php")
    Call<ChudevaTheloai> getDataChudevaTheloai();

    @GET("AlbumDao.php")
    Call<List<Album>> getDataAlbum();

    @GET("LikeDAO.php")
    Call<List<Song>> getDataSong();

    @FormUrlEncoded
    @POST("ListSongfrBanner.php")
    Call<List<Song>> getListSongfrBanner(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("ListSongfrBanner.php")
    Call<List<Song>> getListSongfrPlaylist(@Field("idplaylist") String idplaylist);

    @GET("AllPlaylistDAO.php")
    Call<List<Playlist>> getDataAllPlaylist();

}
