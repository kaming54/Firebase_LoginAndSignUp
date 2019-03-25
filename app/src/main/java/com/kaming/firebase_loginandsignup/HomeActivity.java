package com.kaming.firebase_loginandsignup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button login,signUp;
    private int user=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(user == 0){
            setContentView(R.layout.activity_home);
            login = (Button) findViewById(R.id.login);
            signUp = (Button) findViewById(R.id.signup);

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(HomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });
            signUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(HomeActivity.this, SignUpActivity.class);
                    startActivity(intent);
                }
            });
        } else {
            Intent intent = new Intent();
            intent.setClass(HomeActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
