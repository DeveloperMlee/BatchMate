package com.krudo.batchmate.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krudo.batchmate.OverviewActivity;
import com.krudo.batchmate.R;

public class DiscoverFragment extends Fragment {



    public DiscoverFragment() {
        // Required empty public constructor
    }

    private CardView yoga,guitar,chess,maths,physics,coding,painting,english,french,dance,more;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_discover, container, false);
        yoga=view.findViewById(R.id.disYoga);
        guitar=view.findViewById(R.id.disGuitar);
        chess=view.findViewById(R.id.disChess);
        maths=view.findViewById(R.id.disMaths);
        physics=view.findViewById(R.id.disPhysics);
        coding=view.findViewById(R.id.disCoding);
        painting=view.findViewById(R.id.disPainting);
        english=view.findViewById(R.id.disEng);
        french=view.findViewById(R.id.disFre);
        dance=view.findViewById(R.id.disDance);
        more=view.findViewById(R.id.disMore);

        yoga.setOnClickListener( v -> {
            FragmentManager fragmentManager;

            startActivity(new Intent(getContext(), OverviewActivity.class));
        });


        return view;
    }
}