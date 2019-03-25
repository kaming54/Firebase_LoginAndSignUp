package com.kaming.firebase_loginandsignup;

import android.accounts.Account;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText id,pass;
    private Button signUpBtn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();
    }
    private void initView() {
        id = (EditText) findViewById(R.id.id);
        pass = (EditText) findViewById(R.id.password);
        signUpBtn = (Button) findViewById(R.id.signUp);
        mAuth = FirebaseAuth.getInstance();

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = id.getText().toString();
                String password = pass.getText().toString();

                mAuth.createUserWithEmailAndPassword(account,password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUpActivity.this, "success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent();
                            intent.setClass(SignUpActivity.this,MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
