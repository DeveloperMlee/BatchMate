package com.krudo.batchmate.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.krudo.batchmate.JoinClass;
import com.krudo.batchmate.Model.LiveModel;
import com.krudo.batchmate.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LiveAdaptor extends PagerAdapter {
    List<LiveModel>liveModelList;
    Context context;

    public LiveAdaptor(List<LiveModel> liveModelList, Context context) {
        this.liveModelList = liveModelList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return liveModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {

        View view= LayoutInflater.from(context).inflate(R.layout.live_list_item,container,false);
        ImageView liveImage;
        TextView liveName;
        CardView liveCardView;

        liveImage=view.findViewById(R.id.liveImage);
        liveName=view.findViewById(R.id.liveName);
        liveCardView=view.findViewById(R.id.liveCardView);
        liveImage.setImageResource(liveModelList.get(position).getImage());
        liveName.setText(liveModelList.get(position).getName());
        liveCardView.setOnClickListener(v -> {
            Animation animation= AnimationUtils.loadAnimation(context,R.anim.fadein);
            v.startAnimation(animation);
            Intent liveIntent= new Intent(context, JoinClass.class);
            liveIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(liveIntent);
        });
        container.addView(view,position);
        return view;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        container.removeView((View) object);
    }
}
