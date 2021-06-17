package com.krudo.batchmate.Fragments;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.krudo.batchmate.Adaptor.LiveAdaptor;
import com.krudo.batchmate.Adaptor.TrendingAdaptor;
import com.krudo.batchmate.Adaptor.listAdaptor;
import com.krudo.batchmate.Model.ListModel;
import com.krudo.batchmate.Model.LiveModel;
import com.krudo.batchmate.Model.TrendingModel;
import com.krudo.batchmate.R;

import java.util.ArrayList;
import java.util.List;


public class                                                            HomeFragment extends Fragment {




    public HomeFragment() {
        // Required empty public constructor
    }
    ImageSlider slider;
    ViewPager viewPager ,liveViewPager,trendingViewpager;
    List<TrendingModel>trendingModelList;
    listAdaptor adaptor;
    LiveAdaptor liveAdaptor;
    TrendingAdaptor trendingAdaptor;
    List<LiveModel>liveModelList;
    Integer[] colors=null;
    List<ListModel> models;
    ArgbEvaluator argbEvaluator=new ArgbEvaluator();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        slider=view.findViewById(R.id.image_slider);
        final List<SlideModel> remote=new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("slider")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull  DataSnapshot snapshot) {

                        for(DataSnapshot data: snapshot.getChildren())
                        {
                            remote.add(new SlideModel(data.child("url").getValue().toString(),
                                    data.child("title").getValue().toString(), ScaleTypes.FIT));
                        }

                        slider.setImageList(remote,ScaleTypes.FIT);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        trendingViewpager=view.findViewById(R.id.trendingViewpager);
        loadTreCards();
        trendingViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        liveViewPager=view.findViewById(R.id.liveViewPager);
        loadViewCards();
        liveViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager=view.findViewById(R.id.viewPager);
        loadCards();
        //set viewpager change listener
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return view;
    }

    private void loadTreCards() {
        trendingModelList=new ArrayList<>();
        trendingModelList.add(new TrendingModel(R.drawable.painting));
        trendingModelList.add(new TrendingModel(R.drawable.painting));
        trendingModelList.add(new TrendingModel(R.drawable.painting));
        trendingAdaptor=new TrendingAdaptor(trendingModelList,getContext());
        trendingViewpager.setAdapter(trendingAdaptor);
        trendingViewpager.setPadding(5,0,400,0);

    }

    private void loadViewCards() {
        liveModelList=new ArrayList<>();
        liveModelList.add(new LiveModel(R.drawable.bag,"Manoj Goshwami"));
        liveModelList.add(new LiveModel(R.drawable.pot,"Arya Bhatta"));
        liveModelList.add(new LiveModel(R.drawable.bag,"Albert Einstein"));
        liveAdaptor=new LiveAdaptor(liveModelList,getContext());
        liveViewPager.setAdapter(liveAdaptor);
        liveViewPager.setPadding(5,0,200,0);
    }

    private void loadCards() {

        models=new ArrayList<>();
        models.add(new ListModel(R.drawable.bag,"Manoj Goshwami"));
        models.add(new ListModel(R.drawable.pot,"Arya Bhatta"));
        models.add(new ListModel(R.drawable.bag,"Albert Einstein"));
        adaptor =new listAdaptor(models,getContext());

        viewPager.setAdapter(adaptor);
        viewPager.setPadding(5,0,200,0);
    }
}