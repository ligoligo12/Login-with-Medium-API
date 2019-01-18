package com.example.nextzy.loginmedium.Dao;

import com.google.gson.annotations.SerializedName;

public class Getprofile {

    @SerializedName("id") private String id;
    @SerializedName("username") private String userName;
    @SerializedName("name") private String name;
    @SerializedName("url") private String url;
    @SerializedName("imageUrl") private String imageUrl;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
