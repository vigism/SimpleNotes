package com.example.rushil.simplenotes.API;

import android.util.Log;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rushil on 8/9/2017.
 */

public class Client {

    public static final String BASE_URL="http://192.168.1.3:8000/";
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    Retrofit.Builder builder;


    Retrofit retrofit;
    APIClient client;


    public Client() {
        builder =
        new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        retrofit =
        builder
                .client(
                        httpClient.build()
                )
                .build();
        client = retrofit.create(APIClient.class);
    }


    //Post New user
    public boolean postUsername(String username, String password){
        NewUserInfo userInfo=new NewUserInfo(username,password);
        Call<NewUserInfo> call=client.postUser(userInfo);

        call.enqueue(new Callback<NewUserInfo>() {
            @Override
            public void onResponse(Call<NewUserInfo> call, Response<NewUserInfo> response) {


            }
            @Override
            public void onFailure(Call<NewUserInfo> call, Throwable t) {

            }
        });
        return call.isExecuted();
    }

    //Login User
    public void loginUsername(String username, String password){
        NewUserInfo info=new NewUserInfo(username,password);
        Call<NewUserInfo> call=client.loginUser(info);
        call.enqueue(new Callback<NewUserInfo>() {
            @Override
            public void onResponse(Call<NewUserInfo> call, Response<NewUserInfo> response) {

            }

            @Override
            public void onFailure(Call<NewUserInfo> call, Throwable t) {

            }
        });
    }
}
