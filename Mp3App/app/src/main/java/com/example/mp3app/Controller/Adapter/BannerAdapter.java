package com.example.mp3app.Controller.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mp3app.Model.Quangcao;
import com.example.mp3app.R;
import com.example.mp3app.View.BannertoSongActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class BannerAdapter extends PagerAdapter {
    TextView namesong , descreption;
    Context context;
    ArrayList<Quangcao> qc;

    public BannerAdapter(Context context, ArrayList<Quangcao> qc) {
        this.context = context;
        this.qc = qc;
    }

    @Override
    public int getCount() {
        return qc.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.temp_banner_fragment,null);

        ImageView imgbackgroundbanner = view.findViewById(R.id.imgviewbackgroundbanner);
        ImageView imgsongbanner = view.findViewById(R.id.imgviewBanner);

        namesong = (TextView) view.findViewById(R.id.TitleBanner);
        descreption = (TextView) view.findViewById(R.id.contentBanner);

        Picasso.with(context).load(qc.get(position).getImage()).into(imgbackgroundbanner);
        Picasso.with(context).load(qc.get(position).getImagesong()).into(imgsongbanner);

        namesong.setText(qc.get(position).getNamesong());
        descreption.setText(qc.get(position).getContent());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BannertoSongActivity.class);
                intent.putExtra("Banner", qc.get(position));
                context.startActivity(intent);
            }
        });

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
