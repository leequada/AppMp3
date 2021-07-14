package com.example.mp3app.Controller.Service;

public class API_IMPLEMENT
{
    private static String sv_url = "https://leequadapro.000webhostapp.com/Server/";
    public static DataSevice getService(){
        return APIRetrofit.getClient(sv_url).create(DataSevice.class);
    }
}
