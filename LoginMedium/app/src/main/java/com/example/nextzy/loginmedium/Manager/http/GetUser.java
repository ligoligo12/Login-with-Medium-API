package com.example.nextzy.loginmedium.Manager.http;

import com.example.nextzy.loginmedium.Dao.CollectionList;
import com.example.nextzy.loginmedium.Dao.Getprofile;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface GetUser {

    @GET("v1/users/{userId}/publications")

    Call<CollectionList> getDatatoShow(
            @Path("userId") String userId,
             @Header("Authorization") String authorization

    );


}
