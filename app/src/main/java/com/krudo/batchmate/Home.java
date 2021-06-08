package com.krudo.batchmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

//import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {
private Button logout;
private FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        logout=findViewById(R.id.LogOut);
        fAuth=FirebaseAuth.getInstance();
        logout.setOnClickListener(v -> {
            fAuth.signOut();
            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();
        });
    }
}