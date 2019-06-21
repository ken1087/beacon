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

public class LoginActivity extends AppCompatActivity {

    public static String SERVER_ADERSS = "http://192.168.0.9:8000/";

    EditText username;
    EditText password;

    public static int getid;
    public static String getusername;
    public static String getpassword;
    public static String getname;
    public static String getphone;

    //activity_login의 로그인 버튼
    Button btnLogin;

    //activity_login의 회원가입 버튼
    Button btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.textLogin);
        password = (EditText) findViewById(R.id.textPw);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnJoin = (Button)findViewById(R.id.btnJoin);

        //로그인 버튼을 눌렸을 때
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usernamelogin = username.getText().toString();
                final String passWordlogin = password.getText().toString();

                final Call<User> loginlist = RetrofitServiceImplFactory.serverPost().sendLogin(usernamelogin,passWordlogin);
                loginlist.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        final User message = response.body();
                        getid = message.getId();
                        getusername = message.getUsername();
                        getpassword = message.getPassword();
                        getname = message.getName();
                        getphone = message.getPhone();

                        Log.i("안드로이드개새끼야",usernamelogin.toString());
                        Intent intent1 = new Intent(getApplicationContext(),MenuActivity.class);

                        User user = new User("user.getUsername()","user.getPassword()","user.getName","");

                        startActivity(intent1);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(getApplicationContext(),"서버와 통신중 에러가 발생했습니다",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        //회원가입 버튼을 눌렸을 때
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
            }
        });

    }

    static class RetrofitServiceImplFactory {
        private static Retrofit getretrofit(){
            return new Retrofit.Builder().baseUrl(SERVER_ADERSS).addConverterFactory(GsonConverterFactory.create()).build();
    }
        public static ServerPost serverPost(){
            return getretrofit().create(ServerPost.class);
        }
    }
}
