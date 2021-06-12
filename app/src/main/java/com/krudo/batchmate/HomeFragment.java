package com.krudo.batchmate;

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

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {




    public HomeFragment() {
        // Required empty public constructor
    }
    ImageSlider slider;
    ViewPager viewPager;
    listAdaptor adaptor;
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