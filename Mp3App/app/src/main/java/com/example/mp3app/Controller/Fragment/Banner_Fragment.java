package com.example.mp3app.Controller.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mp3app.Controller.Adapter.BannerAdapter;
import com.example.mp3app.Controller.Service.API_IMPLEMENT;
import com.example.mp3app.Controller.Service.DataSevice;
import com.example.mp3app.Model.Quangcao;
import com.example.mp3app.R;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Banner_Fragment extends Fragment {
    View view;
    ViewPager viewPager;
    CircleIndicator indicator;
    BannerAdapter bannerAdapter;
    Runnable runnable;
    Handler handler;
    int current;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.banner_fragment,container,false);
        anhxa();
        getData();
        return view;
    }

    private void anhxa() {
        viewPager = view.findViewById(R.id.ViewpagerBanner);
        indicator = view.findViewById(R.id.Indicator);
    }

    private void getData() {
        DataSevice dataSevice = API_IMPLEMENT.getService();
        Call<List<Quangcao>> callback = dataSevice.getData();
        callback.enqueue(new Callback<List<Quangcao>>() {
            @Override
            public void onResponse(Call<List<Quangcao>> call, Response<List<Quangcao>> response) {
                ArrayList<Quangcao> qc = (ArrayList<Quangcao>) response.body();

                bannerAdapter = new BannerAdapter(getActivity(),qc);
                viewPager.setAdapter(bannerAdapter);
                indicator.setViewPager(viewPager);
                handler = new Handler(Looper.getMainLooper());
                runnable = new Runnable() {

                    @Override
                    public void run() {
                        current = viewPager.getCurrentItem();
                        current++;
                        if(current >= viewPager.getAdapter().getCount()){
                            current=0;
                        }
                        viewPager.setCurrentItem(current,true);
                        handler.postDelayed(runnable,2500);
                    }
                };
                handler.postDelayed(runnable,2500);

            }

            @Override
            public void onFailure(Call<List<Quangcao>> call, Throwable t) {

            }
        });
    }
}
