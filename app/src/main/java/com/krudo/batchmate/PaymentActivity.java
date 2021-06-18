package com.krudo.batchmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {

    private TextView className,teaName,date,time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        className=findViewById(R.id.cName);
        teaName=findViewById(R.id.tName);
        date=findViewById(R.id.txtDate);
        time=findViewById(R.id.txtTime);
        className.setText(getIntent().getExtras().getString("className"));
        teaName.setText(getIntent().getExtras().getString("teacherName"));
        date.setText(getIntent().getExtras().getString("days"));
        time.setText(getIntent().getExtras().getString("time"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),CenterMainActivity.class));
        finish();
    }
}