package com.cos.teambeacon.Server;

import com.cos.teambeacon.model.AttendanceCheck;
import com.cos.teambeacon.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ServerPost {

    public static final String SERVER_ADERSS = "http://192.168.0.9:8000/";

    @GET("user/login")
    Call<User> sendLogin(@Query("username") String username, @Query("password") String password);



    @GET("myattendce")
    Call<List<AttendanceCheck>> app(@Query("userId") int userId);




    @GET("/beacon")
    Call<User> sendbeacon(@Query("userId") int userId ,@Query("password") String password);





    @FormUrlEncoded
    @POST("user/join")
    Call<User> sendJoin(@Field("username") String username,
                        @Field("password") String password,
                        @Field("name") String name,
                        @Field("phone") String phone);


}


