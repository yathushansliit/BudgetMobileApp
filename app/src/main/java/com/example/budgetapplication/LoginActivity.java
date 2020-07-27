package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView textView;
    TextView textView01;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView = (TextView) findViewById(R.id.Signup);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        button = findViewById(R.id.loginBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Home.class);
                startActivity(intent);
            }
        });

        textView01 = (TextView) findViewById(R.id.TVforgotPwd);
        textView01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent01 = new Intent(LoginActivity.this,forgetUi.class);
                startActivity(intent01);

            }
        });

    }
}
