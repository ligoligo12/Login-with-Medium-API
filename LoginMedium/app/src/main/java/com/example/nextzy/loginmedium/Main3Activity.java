package com.example.nextzy.loginmedium;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.nextzy.loginmedium.Dao.CollectionList;
import com.example.nextzy.loginmedium.Dao.Getprofile;
import com.example.nextzy.loginmedium.Dao.PublicationList;
import com.example.nextzy.loginmedium.Manager.http.GetUser;
import com.example.nextzy.loginmedium.TypeRecycleView.BaseorderDetail;
import com.example.nextzy.loginmedium.TypeRecycleView.OrderDetailConvert;
import com.example.nextzy.loginmedium.TypeRecycleView.OrderDetailType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main3Activity extends AppCompatActivity {

    private String userId ;
    private String accessToken;
    private String usernameUser;
    private String urlImageUser;
    private String nameUser;
    private RecyclerView rvOrderView;
    private Orderadapter orderadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent inbound = getIntent();

       accessToken = inbound.getStringExtra("authorization");
       nameUser = inbound.getStringExtra("nameProfile");
       usernameUser = inbound.getStringExtra("usernameProfile");
       userId = inbound.getStringExtra("idProfile");
       urlImageUser = inbound.getStringExtra("urlImageProfile");
        bindView();
        setupView();
        callService();

    }

    public void Getpublication()
    {
        Retrofit.Builder builder1 = new Retrofit.Builder()
                .baseUrl("https://api.medium.com/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit1 = builder1.build();
        final GetUser getUser1 = retrofit1.create(GetUser.class);
        Call<CollectionList> call = getUser1.getDatatoShow(
                userId,
                accessToken

        );
        call.enqueue(new Callback<CollectionList>() {
            @Override
            public void onResponse(Call<CollectionList> call, Response<CollectionList> response) {
                  CollectionList collectionList = response.body();

                setOrderDetail(collectionList);

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonOutput = gson.toJson(collectionList);
                Log.i("onResponse",jsonOutput);
            }

            @Override
            public void onFailure(Call<CollectionList> call, Throwable t) {

            }
        });




    }

    private void bindView() {
        rvOrderView = (RecyclerView) findViewById(R.id.recycleview);

    }

    private void setupView(){
        rvOrderView.setLayoutManager(new LinearLayoutManager(this));
        orderadapter = new Orderadapter();
        rvOrderView.setAdapter(orderadapter);
    }

    private void callService(){

        Getpublication();

    }
    private void setOrderDetail(CollectionList collectionList){

        List<BaseorderDetail> baseorderDetails = new ArrayList<>();
        baseorderDetails.add(OrderDetailConvert.createUserDetail(nameUser,usernameUser,urlImageUser));
        baseorderDetails.addAll(OrderDetailConvert.createOrder(collectionList));
        orderadapter.setBaseorderDetails(baseorderDetails);
        orderadapter.notifyDataSetChanged();
    }

}
