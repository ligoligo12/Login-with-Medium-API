package com.example.nextzy.loginmedium.Dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataProfile {

    @SerializedName("data") private Getprofile data;

    public Getprofile getData() {
        return data;
    }

    public void setData(Getprofile data) {
        this.data = data;
    }
}
