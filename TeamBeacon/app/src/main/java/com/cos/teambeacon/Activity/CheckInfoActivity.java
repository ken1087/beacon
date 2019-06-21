package com.cos.teambeacon.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cos.teambeacon.R;
import com.cos.teambeacon.Server.ServerPost;
import com.cos.teambeacon.adapter.AttendanceAdapter;
import com.cos.teambeacon.model.AttendanceCheck;
import com.cos.teambeacon.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.cos.teambeacon.Activity.LoginActivity.getid;
import static com.cos.teambeacon.Activity.LoginActivity.getusername;

public class CheckInfoActivity extends AppCompatActivity {
    Retrofit retrofit;
    ServerPost serverpost;
    RecyclerView rvCheck;
    int size;

    AttendanceAdapter adapter;

    public static String SERVER_ADRESS = "http://192.168.0.9:8000/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_info);
        init();
        serverpost = retrofit.create(ServerPost.class);
        Call<List<AttendanceCheck>> con = serverpost.app(getid);
        con.enqueue(new Callback<List<AttendanceCheck>>() {
            @Override
            public void onResponse(Call<List<AttendanceCheck>> call, Response<List<AttendanceCheck>> response) {
                final List<AttendanceCheck> co1 = response.body();
                size = co1.size();
                Log.d("aaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaa");

                String[] checking2 = new String[size];
                String[] createDate2 = new String[size];


                adapter = new AttendanceAdapter();

                for (int i = 0; i < size; i++) {
                    Log.d("test33", co1.get(i).getCreateDate());

                    Log.d("Test33", co1.get(i).getChecking());
                    checking2[i] = co1.get(i).getChecking();
                    createDate2[i] = co1.get(i).getCreateDate();

                    rvCheck = findViewById(R.id.rvCheck);
                    adapter.addItem(new AttendanceCheck(checking2[i], createDate2[i]));
                    rvCheck.setAdapter(adapter);
                }
                LinearLayoutManager verticalLayoutManager
                        = new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL, false);

                rvCheck.setLayoutManager(verticalLayoutManager);

            }


            @Override
            public void onFailure(Call<List<AttendanceCheck>> call, Throwable t) {
                Log.d("test33", "test55");
            }
        });
    }


    public void init() {
        retrofit = new Retrofit.Builder().baseUrl(SERVER_ADRESS).addConverterFactory(GsonConverterFactory.create()).build();
    }

}
