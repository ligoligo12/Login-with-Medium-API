package com.example.nextzy.loginmedium.Manager.http;

import com.example.nextzy.loginmedium.Dao.DataProfile;
import com.example.nextzy.loginmedium.Dao.GetToken;
import com.example.nextzy.loginmedium.Dao.Getprofile;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Apiservice {
    @POST("v1/tokens")
    @FormUrlEncoded
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
                    "Accept: application/json",
                    "Accept-Charset: utf-8"
    })



    Call<GetToken> loadprofile(
            @Field("code") String code,
            @Field("client_id") String clientId,
            @Field("client_secret") String clientSecret,
            @Field("grant_type") String grantType,
            @Field("redirect_uri") String redirect
    );

    @GET("v1/me")
@Headers({
        "Content-Type: application/json",
        "Accept: application/json",
        "Accept-Charset: utf-8"
})

    Call<DataProfile> getprofile(

            @Header("Authorization") String authorization

    );








}
