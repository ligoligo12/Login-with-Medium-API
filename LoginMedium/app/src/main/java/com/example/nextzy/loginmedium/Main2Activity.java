package com.example.nextzy.loginmedium;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nextzy.loginmedium.Dao.Getprofile;
import com.example.nextzy.loginmedium.Manager.http.GetUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {

private String geturl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent inbound = getIntent();
        geturl = inbound.getStringExtra("urlPage");
        WebView webView = (WebView) findViewById(R.id.webviewRecycle);
        webView.loadUrl(geturl);




    }









}
