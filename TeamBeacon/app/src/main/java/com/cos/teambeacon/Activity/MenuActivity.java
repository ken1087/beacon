package com.cos.teambeacon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cos.teambeacon.R;


public class MenuActivity extends AppCompatActivity {

    //내 정보 버튼
    Button menuInfo;

    //전자출결 버튼
    Button menuCheck;

    //출결조회 버튼
    Button menuCheckInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuInfo = (Button)findViewById(R.id.menuInfo);
        menuCheck = (Button)findViewById(R.id.menuCheck);
        menuCheckInfo = (Button)findViewById(R.id.menuCheckInfo);



        //내 정보 눌렸을때
        menuInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                startActivity(intent);
            }
        });

        //전자출결 눌렸을때
        menuCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CheckMenuActivity.class);
                startActivity(intent);
            }
        });

        //출결조회 눌렸을때
        menuCheckInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CheckInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}