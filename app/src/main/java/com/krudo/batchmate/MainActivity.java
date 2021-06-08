package com.krudo.batchmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnLogin,btnSignUp;
    private TextView color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin=findViewById(R.id.btnLogin);
        btnSignUp=findViewById(R.id.btnSignUp);
        color=findViewById(R.id.txtColor);
        btnLogin.setOnClickListener(v -> {

            startActivity ( new Intent(getApplicationContext(),Login.class) );
            finish ();
        });
        btnSignUp.setOnClickListener(v -> {
            startActivity ( new Intent(getApplicationContext(),SignUp.class) );
            finish ();
        });

    }
}