package com.example.mp3app.Controller.Fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.mp3app.Controller.Service.API_IMPLEMENT;
import com.example.mp3app.Controller.Service.DataSevice;
import com.example.mp3app.Model.Chude;
import com.example.mp3app.Model.ChudevaTheloai;
import com.example.mp3app.Model.Theloai;
import com.example.mp3app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChudeTheloai_Fragment extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    TextView txtViewMoreChude;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.chudetheloai_fragment,container,false);
        horizontalScrollView = view.findViewById(R.id.HorizontalScrollViewChude);
        txtViewMoreChude = view.findViewById(R.id.TxtViewMoreChude);
        getData();
        return view;
    }

    private void getData() {
        DataSevice dataSevice = API_IMPLEMENT.getService();
        Call<ChudevaTheloai> callback = dataSevice.getDataChudevaTheloai();
        callback.enqueue(new Callback<ChudevaTheloai>() {
            @Override
            public void onResponse(Call<ChudevaTheloai> call, Response<ChudevaTheloai> response) {
                ChudevaTheloai chudevaTheloai = response.body();
                final ArrayList<Chude> chudeArrayList = new ArrayList<>();
                chudeArrayList.addAll(chudevaTheloai.getChude());
                final ArrayList<Theloai> theloaiArrayList = new ArrayList<>();
                theloaiArrayList.addAll(chudevaTheloai.getTheloai());

                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(580,250);
                layout.setMargins(10,20,10,30);
                LinearLayout.LayoutParams layoutTextview = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutTextview.setMargins(18,40,0,0);

                for(int i=0;i< chudeArrayList.size();i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    TextView textView = new TextView(getActivity());
                    ImageView imageView  = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    textView.setTypeface(null, Typeface.BOLD);
                    textView.setTextSize(19);
                    textView.setTextColor(Color.WHITE);
                    textView.setLayoutParams(layoutTextview);
                    if(chudeArrayList.get(i).getHinhanhchude() != null){
                        Picasso.with(getActivity()).load(chudeArrayList.get(i).getHinhanhchude()).into(imageView);
                        textView.setText(chudeArrayList.get(i).getTenchude());
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    cardView.addView(textView);
                    linearLayout.addView(cardView);
                }

                for(int j=0;j< theloaiArrayList.size();j++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    TextView textView = new TextView(getActivity());
                    ImageView imageView  = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    textView.setTypeface(null, Typeface.BOLD);
                    textView.setTextSize(19);
                    textView.setTextColor(Color.WHITE);
                    textView.setLayoutParams(layoutTextview);
                    if(theloaiArrayList.get(j).getHinhanhtheloai() != null){
                        Picasso.with(getActivity()).load(theloaiArrayList.get(j).getHinhanhtheloai()).into(imageView);
                        textView.setText(theloaiArrayList.get(j).getTentheloai());
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    cardView.addView(textView);
                    linearLayout.addView(cardView);
                }
                horizontalScrollView.addView(linearLayout);

            }

            @Override
            public void onFailure(Call<ChudevaTheloai> call, Throwable t) {

            }
        });
    }
}
