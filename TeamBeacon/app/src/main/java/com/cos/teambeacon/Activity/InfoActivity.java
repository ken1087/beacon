package com.cos.teambeacon.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.cos.teambeacon.R;

import static com.cos.teambeacon.Activity.LoginActivity.getname;
import static com.cos.teambeacon.Activity.LoginActivity.getphone;
import static com.cos.teambeacon.Activity.LoginActivity.getusername;

public class InfoActivity extends AppCompatActivity {


    TextView infoName;
    TextView infoId;
    TextView infoPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        init();
        infoName.setText("이름 : "+getname);
        infoId.setText("아이디 : "+getusername);
        infoPhone.setText("전화번호 : "+getphone);
    }

    public void init(){
        infoName = (TextView)findViewById(R.id.infoName);
        infoId = (TextView)findViewById(R.id.infoId);
        infoPhone = (TextView)findViewById(R.id.infoPhone);
    }
}
