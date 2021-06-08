package com.krudo.batchmate;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class SignUp extends AppCompatActivity {
     private EditText name,email,password,phone;
     private Button signUp,signIn;
     private ImageView back;
     private FirebaseAuth mAuth;
     private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
        signIn.setOnClickListener(v -> {
           startActivity(new Intent(getApplicationContext(),Login.class));
            finish ();
        });
        back.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish ();
        });

        if (mAuth.getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(),Home.class));
           finish();
        }

        signUp.setOnClickListener(v -> checkCredentials());




    }

    private void init() {
        name=findViewById(R.id.edtSignUpName);
        email=findViewById(R.id.edtSignUpEmail);
        phone=findViewById(R.id.edtSignUpNumber);
        password=findViewById(R.id.edtSignUpPass);
        signUp=findViewById(R.id.btnCreateAccount);
        signIn=findViewById(R.id.btnSignIn);
        back=findViewById(R.id.signBackArrow);
        mAuth=FirebaseAuth.getInstance();
        db=FirebaseFirestore.getInstance ();
    }

    private void checkCredentials() {

        String Name=name.getText().toString().trim();
        String Email=email.getText().toString().trim();
        String Phone=phone.getText().toString().trim();
        String Pass=password.getText().toString().trim();
        if (TextUtils.isEmpty(Name)){
            name.setError("Please Enter Name");
            return;
        }
        if (TextUtils.isEmpty(Email)){
            email.setError("Email is required");
            return;
        }
        if (TextUtils.isEmpty(Phone)){
            phone.setError("Phone is required");
            return;
        }
        if (TextUtils.isEmpty(Pass)){
            password.setError("Password is required");
            return;
        }
        if (Pass.length()<6){
            password.setError("Password is to short");
            return;
        }

        //user registration
        mAuth.createUserWithEmailAndPassword(Email,Pass).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                Toast.makeText(SignUp.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                insertData();
                startActivity(new Intent(getApplicationContext(),ChildInfo.class));
                finish();

            }else{
                Toast.makeText(SignUp.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

            }

        });
    }

    private void insertData() {

        Map<String,String> items=new HashMap<>(  );
        items.put("name",name.getText().toString().toLowerCase().trim());
        items.put("phone",phone.getText().toString().toLowerCase().trim());

        db.collection ("Users" ).add ( items ).addOnCompleteListener(task -> {

        });
    }


}