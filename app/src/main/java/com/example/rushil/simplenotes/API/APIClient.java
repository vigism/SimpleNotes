package com.example.rushil.simplenotes.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Rushil on 8/7/2017.
 */

public interface APIClient {

    //Get User
    @GET("/users/{id}/?format=json")
    Call<NewUserInfo> reposForUser(
            @Path("id")int id
    );

    //Post New User
    @POST("/users/")
    Call<NewUserInfo> postUser(@Body NewUserInfo info);

    //Login
    @POST("/api-auth/login/")
    Call<NewUserInfo> loginUser(@Body NewUserInfo info);
}
