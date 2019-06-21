package com.cos.teambeacon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cos.teambeacon.R;
import com.cos.teambeacon.Server.ServerPost;
import com.cos.teambeacon.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JoinActivity extends AppCompatActivity {

    public static String SERVER_ADRESS = "http://192.168.0.9:8000/";

    EditText username;
    EditText password;
    EditText name;
    EditText phone;
    //activity_join의 가입완료버튼
    Button joinOk;

    //activity_join의 가입취소버튼
    Button joinCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        username = (EditText) findViewById(R.id.joinId);
        password = (EditText) findViewById(R.id.joinPassword);
        name = (EditText) findViewById(R.id.joinUsername);
        phone = (EditText) findViewById(R.id.joinPhone);


                joinOk = (Button)findViewById(R.id.joinOk);
        joinCancel = (Button)findViewById(R.id.joinCancel);

        //가입완료 눌렸을때
        joinOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username2 = username.getText().toString();
                final String Password2 = password.getText().toString();
                final String name2 = name.getText().toString();
                final String phone2 = phone.getText().toString();

                Log.d("안드로이드개새끼","정말로씹샊;");
                if (username.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "아이디를 입력하세요", Toast.LENGTH_SHORT).show();
                    username.requestFocus();
                    return;
                }
                if (name.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "성명을 입력하세요", Toast.LENGTH_SHORT).show();
                    name.requestFocus();
                    return;
                }
                if (password.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                    password.requestFocus();
                    return;
                }
                if (password.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "핸드폰번호를를 입력하세요", Toast.LENGTH_SHORT).show();
                    phone.requestFocus();
                    return;
                }


                else {
                    final Call<User> user = RetrofitServiceImplFactory.serverPost().sendJoin(username2,Password2,name2,phone2);
                    user.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            Toast.makeText(getApplicationContext(), "회원가입 완료", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Log.i("안드로이드씨발", t.toString());
                            Log.d("222안드로이드개새끼야","응답하라119");
                        }
                    });
                }
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        //아무기능필요없음
        //가입취소 눌렸을때
        joinCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    static  class RetrofitServiceImplFactory{
        private static Retrofit getretrofit(){
            return new Retrofit.Builder()
                    .baseUrl(SERVER_ADRESS)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        public  static ServerPost serverPost() {
            return getretrofit().create(ServerPost.class);
        }
        }
    }
