package com.krudo.batchmate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TrendingAdaptor extends PagerAdapter {

    List<TrendingModel>trendingModelList;
    Context context;

    public TrendingAdaptor(List<TrendingModel> trendingModelList, Context context) {
        this.trendingModelList = trendingModelList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return trendingModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {

        View view= LayoutInflater.from(context).inflate(R.layout.trending_list,container,false);
        ImageView treImage;
        treImage=view.findViewById(R.id.trending);
        treImage.setImageResource(trendingModelList.get(position).getImage());
        container.addView(view,position);
        return view;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
       container.removeView((View) object);
    }
}
