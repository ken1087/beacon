package com.cos.teambeacon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.cos.teambeacon.R;

public class CheckMenuActivity extends AppCompatActivity {

    ImageView checkBtn;
    ImageView searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_menu);

        checkBtn = (ImageView)findViewById(R.id.checkText);
        searchBtn = (ImageView) findViewById(R.id.searchBtn);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CheckActivity.class);
                startActivity(intent);
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CheckInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}