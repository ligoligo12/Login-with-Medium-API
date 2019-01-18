package com.example.nextzy.loginmedium.Dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollectionList {

@SerializedName("data") private List<PublicationList> data;

    public List<PublicationList> getData() {
        return data;
    }

    public void setData(List<PublicationList> data) {
        this.data = data;
    }
}


