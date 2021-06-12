package com.krudo.batchmate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class listAdaptor extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private List<ListModel> models;
    private Context context;

    public listAdaptor(List<ListModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {

        layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.list_class_item,container,false);

        ImageView listImage;
        TextView listName;
        listImage=view.findViewById(R.id.listImage);
        listName=view.findViewById(R.id.listName);
        listImage.setImageResource(models.get(position).getImage());
        listName.setText(models.get(position).getName());

        container.addView(view,position);

        //get data

        return view;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        container.removeView((View) object);
    }
}
