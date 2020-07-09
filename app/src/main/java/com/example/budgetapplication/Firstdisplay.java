package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Firstdisplay extends AppCompatActivity {

    Button button01;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstdisplay);

        button01 = findViewById(R.id.joinNow);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Firstdisplay.this,SignupActivity.class);
                startActivity(intent);
            }
        });

        button = findViewById(R.id.loginBtnFirstDisplay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Firstdisplay.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
