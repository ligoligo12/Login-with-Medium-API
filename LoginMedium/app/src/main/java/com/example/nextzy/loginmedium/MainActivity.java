package com.example.nextzy.loginmedium;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nextzy.loginmedium.Dao.DataProfile;
import com.example.nextzy.loginmedium.Dao.GetToken;
import com.example.nextzy.loginmedium.Dao.Getprofile;
import com.example.nextzy.loginmedium.Manager.http.Apiservice;
import com.example.nextzy.loginmedium.Manager.http.GetUser;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public  static  final  String APIUrl = "https://api.medium.com";
    private String clientId = "dc38c66765b6";
    private String clientSecret = "51fd0cb31e86ac4239302e9e429e2865b85fddb2";
    private String redirect = "myapp://oauthresponse";
    private String state = "111111";
    private String grantType = "authorization_code";
    private String accToken;
    private String tokenT;
    boolean count = false;
    private String id;
    private String authorization;
    private String userName;
    private String pic;
    private String name;
    private String imageUrL;
    private String application;
    private String urL;
    private String ref;



    TextView tname;
    TextView tuser;
    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://api.medium.com")
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();
    Apiservice apiservice = retrofit.create(Apiservice.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Oauthlogin();



            }

        });




    }

    private void Oauthlogin() {


        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://medium.com/m/oauth/authorize" + "?client_id=" + clientId + "&scope=basicProfile,publishPost,listPublications&state=" + state + "&response_type=code&redirect_uri=" + redirect));
        startActivity(intent);


    }



    private void LoginGetdata() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.medium.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        authorization = tokenT + " " + accToken;
        Apiservice apiservice = retrofit.create(Apiservice.class);
        Call<DataProfile> call1 = apiservice.getprofile(
                authorization


        );
        call1.enqueue(new Callback<DataProfile>() {
            @Override
            public void onResponse(Call<DataProfile> call, Response<DataProfile> response) {

                DataProfile dataProfile = response.body();
                name = dataProfile.getData().getName();
                userName = dataProfile.getData().getUserName();
                urL = dataProfile.getData().getUrl();
                id = dataProfile.getData().getId();
                imageUrL = dataProfile.getData().getImageUrl();
                Intent i = new Intent(getApplicationContext(), Main3Activity.class);
                i.putExtra("authorization",authorization.toString());
                i.putExtra("idProfile",id.toString());
                i.putExtra("nameProfile", name.toString());
                i.putExtra("usernameProfile", userName.toString());
                i.putExtra("urlProfile", urL.toString());
                i.putExtra("urlImageProfile", imageUrL.toString());
                startActivity(i);



            }

            @Override
            public void onFailure(Call<DataProfile> call, Throwable t) {

            }
        });
    }





        @Override
        protected void onResume () {
            super.onResume();
            Uri uri = getIntent().getData();
            if (uri != null) {
                String code = uri.getQueryParameter("code");

                Call<GetToken> call = apiservice.loadprofile(
                        code,
                        clientId,
                        clientSecret,
                        grantType,
                        redirect

                );

                call.enqueue(new Callback<GetToken>() {
                    @Override
                    public void onResponse(Call<GetToken> call, Response<GetToken> response) {
                        if (response.isSuccessful()) {
                            final GetToken dao = response.body();


                            accToken = dao.getAccessToken();
                            tokenT = dao.getTokenType();
                            ref = dao.getRefreshToken();
                            LoginGetdata();



                        }
                    }

                    @Override
                    public void onFailure(Call<GetToken> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "No", Toast.LENGTH_LONG).show();
                    }
                });


            }


        }


//
    }