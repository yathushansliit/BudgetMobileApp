package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserVerify extends AppCompatActivity {

    Button buttonVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_verify);

        buttonVerify = findViewById(R.id.verify);
        buttonVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVerify = new Intent(UserVerify.this,LoginActivity.class);
                startActivity(intentVerify);
            }
        });
    }
}
