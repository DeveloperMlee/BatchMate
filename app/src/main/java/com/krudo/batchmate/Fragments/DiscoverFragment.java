package com.krudo.batchmate.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.krudo.batchmate.Model.OverViewModel;
import com.krudo.batchmate.OverviewActivity;
import com.krudo.batchmate.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment {



    public DiscoverFragment() {
        // Required empty public constructor
    }
    private Animation animation;
    FirebaseFirestore db;
    ArrayList<OverViewModel> dataList;
    private CardView yoga,guitar,chess,maths,physics,coding,painting,english,french,dance,more;
    private String cName,tName,objOne,objTwo,objThree,url;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        db=FirebaseFirestore.getInstance();
        animation= AnimationUtils.loadAnimation(getContext(),R.anim.fadein);
        dataList=new ArrayList<>();
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
            v.startAnimation(animation);
            DocumentReference document=db.collection("yoga").document("manyoga");
            document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists())
                    {
                     cName=documentSnapshot.getString("cName");
                     tName=documentSnapshot.getString("tName");
                     objOne=documentSnapshot.getString("objOne");
                     objTwo=documentSnapshot.getString("objTwo");
                     objThree=documentSnapshot.getString("objThree");
                     url=documentSnapshot.getString("url");
                     startActivityOverview(cName,tName,objOne,objTwo,objThree,url);


                    }
                    else {
                        Toast.makeText(getContext(), "Failed to Fetch row ", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Toast.makeText(getContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    Log.e("Error",e.getMessage().toString());
                }
            });

        });

        guitar.setOnClickListener(v->{
            v.startAnimation(animation);
            DocumentReference document=db.collection("yoga").document("manyoga");
            document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists())
                    {
                        cName=documentSnapshot.getString("cName");
                        tName=documentSnapshot.getString("tName");
                        objOne=documentSnapshot.getString("objOne");
                        objTwo=documentSnapshot.getString("objTwo");
                        objThree=documentSnapshot.getString("objThree");
                        url=documentSnapshot.getString("url");
                        startActivityOverview(cName,tName,objOne,objTwo,objThree,url);


                    }
                    else {
                        Toast.makeText(getContext(), "Failed to Fetch row ", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Toast.makeText(getContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    Log.e("Error",e.getMessage().toString());
                }
            });

        });
        chess.setOnClickListener(v->{
            v.startAnimation(animation);
            DocumentReference document=db.collection("yoga").document("manyoga");
            document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists())
                    {
                        cName=documentSnapshot.getString("cName");
                        tName=documentSnapshot.getString("tName");
                        objOne=documentSnapshot.getString("objOne");
                        objTwo=documentSnapshot.getString("objTwo");
                        objThree=documentSnapshot.getString("objThree");
                        url=documentSnapshot.getString("url");
                        startActivityOverview(cName,tName,objOne,objTwo,objThree,url);


                    }
                    else {
                        Toast.makeText(getContext(), "Failed to Fetch row ", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Toast.makeText(getContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    Log.e("Error",e.getMessage().toString());
                }
            });

        });
        maths.setOnClickListener(v->{
            v.startAnimation(animation);
            DocumentReference document=db.collection("yoga").document("manyoga");
            document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists())
                    {
                        cName=documentSnapshot.getString("cName");
                        tName=documentSnapshot.getString("tName");
                        objOne=documentSnapshot.getString("objOne");
                        objTwo=documentSnapshot.getString("objTwo");
                        objThree=documentSnapshot.getString("objThree");
                        url=documentSnapshot.getString("url");
                        startActivityOverview(cName,tName,objOne,objTwo,objThree,url);


                    }
                    else {
                        Toast.makeText(getContext(), "Failed to Fetch row ", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Toast.makeText(getContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    Log.e("Error",e.getMessage().toString());
                }
            });

        });
        physics.setOnClickListener(v->{
            v.startAnimation(animation);
            DocumentReference document=db.collection("yoga").document("manyoga");
            document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists())
                    {
                        cName=documentSnapshot.getString("cName");
                        tName=documentSnapshot.getString("tName");
                        objOne=documentSnapshot.getString("objOne");
                        objTwo=documentSnapshot.getString("objTwo");
                        objThree=documentSnapshot.getString("objThree");
                        url=documentSnapshot.getString("url");
                        startActivityOverview(cName,tName,objOne,objTwo,objThree,url);


                    }
                    else {
                        Toast.makeText(getContext(), "Failed to Fetch row ", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Toast.makeText(getContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    Log.e("Error",e.getMessage().toString());
                }
            });

        });
        coding.setOnClickListener(v->{
            v.startAnimation(animation);
            DocumentReference document=db.collection("yoga").document("manyoga");
            document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists())
                    {
                        cName=documentSnapshot.getString("cName");
                        tName=documentSnapshot.getString("tName");
                        objOne=documentSnapshot.getString("objOne");
                        objTwo=documentSnapshot.getString("objTwo");
                        objThree=documentSnapshot.getString("objThree");
                        url=documentSnapshot.getString("url");
                        startActivityOverview(cName,tName,objOne,objTwo,objThree,url);


                    }
                    else {
                        Toast.makeText(getContext(), "Failed to Fetch row ", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Toast.makeText(getContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    Log.e("Error",e.getMessage().toString());
                }
            });

        });
        painting.setOnClickListener(v->{
            v.startAnimation(animation);
            DocumentReference document=db.collection("yoga").document("manyoga");
            document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists())
                    {
                        cName=documentSnapshot.getString("cName");
                        tName=documentSnapshot.getString("tName");
                        objOne=documentSnapshot.getString("objOne");
                        objTwo=documentSnapshot.getString("objTwo");
                        objThree=documentSnapshot.getString("objThree");
                        url=documentSnapshot.getString("url");
                        startActivityOverview(cName,tName,objOne,objTwo,objThree,url);


                    }
                    else {
                        Toast.makeText(getContext(), "Failed to Fetch row ", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Toast.makeText(getContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    Log.e("Error",e.getMessage().toString());
                }
            });

        });
        english.setOnClickListener(v->{
            v.startAnimation(animation);
            DocumentReference document=db.collection("yoga").document("manyoga");
            document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists())
                    {
                        cName=documentSnapshot.getString("cName");
                        tName=documentSnapshot.getString("tName");
                        objOne=documentSnapshot.getString("objOne");
                        objTwo=documentSnapshot.getString("objTwo");
                        objThree=documentSnapshot.getString("objThree");
                        url=documentSnapshot.getString("url");
                        startActivityOverview(cName,tName,objOne,objTwo,objThree,url);


                    }
                    else {
                        Toast.makeText(getContext(), "Failed to Fetch row ", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Toast.makeText(getContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    Log.e("Error",e.getMessage().toString());
                }
            });

        });
        french.setOnClickListener(v->{
            v.startAnimation(animation);
            DocumentReference document=db.collection("yoga").document("manyoga");
            document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists())
                    {
                        cName=documentSnapshot.getString("cName");
                        tName=documentSnapshot.getString("tName");
                        objOne=documentSnapshot.getString("objOne");
                        objTwo=documentSnapshot.getString("objTwo");
                        objThree=documentSnapshot.getString("objThree");
                        url=documentSnapshot.getString("url");
                        startActivityOverview(cName,tName,objOne,objTwo,objThree,url);


                    }
                    else {
                        Toast.makeText(getContext(), "Failed to Fetch row ", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Toast.makeText(getContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    Log.e("Error",e.getMessage().toString());
                }
            });

        });
        dance.setOnClickListener(v->{
            v.startAnimation(animation);
            DocumentReference document=db.collection("yoga").document("manyoga");
            document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists())
                    {
                        cName=documentSnapshot.getString("cName");
                        tName=documentSnapshot.getString("tName");
                        objOne=documentSnapshot.getString("objOne");
                        objTwo=documentSnapshot.getString("objTwo");
                        objThree=documentSnapshot.getString("objThree");
                        url=documentSnapshot.getString("url");
                        startActivityOverview(cName,tName,objOne,objTwo,objThree,url);


                    }
                    else {
                        Toast.makeText(getContext(), "Failed to Fetch row ", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Toast.makeText(getContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    Log.e("Error",e.getMessage().toString());
                }
            });

        });
        more.setOnClickListener(v->{
            v.startAnimation(animation);
            DocumentReference document=db.collection("yoga").document("manyoga");
            document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists())
                    {
                        cName=documentSnapshot.getString("cName");
                        tName=documentSnapshot.getString("tName");
                        objOne=documentSnapshot.getString("objOne");
                        objTwo=documentSnapshot.getString("objTwo");
                        objThree=documentSnapshot.getString("objThree");
                        url=documentSnapshot.getString("url");
                        startActivityOverview(cName,tName,objOne,objTwo,objThree,url);


                    }
                    else {
                        Toast.makeText(getContext(), "Failed to Fetch row ", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Toast.makeText(getContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    Log.e("Error",e.getMessage().toString());
                }
            });

        });
        return view;
    }

    private void startActivityOverview(String cName, String tName, String objOne, String objTwo, String objThree, String url) {

        Intent intent=new Intent(getContext(),OverviewActivity.class);
        intent.putExtra("cName",cName);
        intent.putExtra("tName",tName);
        intent.putExtra("objOne",objOne);
        intent.putExtra("objTwo",objTwo);
        intent.putExtra("objThree",objThree);
        intent.putExtra("url",url);
        startActivity(intent);
    }
}