package com.krudo.batchmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {
    private ImageView backArrow;
    private EditText email,pass;
    private Button btnLogin;
    private FirebaseAuth fAuth;
    private TextView forgetPass,btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       init();
       backArrow.setOnClickListener(v -> {
           startActivity(new Intent(getApplicationContext(),MainActivity.class));
           finish();
       });
       btnSignUp.setOnClickListener(v -> {
           startActivity(new Intent(getApplicationContext(),SignUp.class));
           finish();
       });
       btnLogin.setOnClickListener(v -> checkCredentials());


    }



    private void init() {
        backArrow=findViewById(R.id.logImgBackArrow);
        btnLogin=findViewById(R.id.btnLogin);
        forgetPass=findViewById(R.id.txtForgetPass);
        btnSignUp=findViewById(R.id.btnSignUp);
        email=findViewById(R.id.edtLoginEmail);
        pass=findViewById(R.id.edtLoginPassword);
        fAuth=FirebaseAuth.getInstance();
    }
    private void checkCredentials() {
        String Email=email.getText().toString().trim();
        String Pass=pass.getText().toString().trim();

        if (TextUtils.isEmpty(Email)){
            email.setError("Email is required");
            return;
        }
        if (TextUtils.isEmpty(Pass)){
            pass.setError("Password is required");
            return;
        }

//        authentication of the user
        fAuth.signInWithEmailAndPassword(Email,Pass).addOnCompleteListener(task -> {
            if (task.isSuccessful()){

                Toast.makeText(Login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),CenterMainActivity.class));

            }else
            {
                Toast.makeText(Login.this, "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

    }
}