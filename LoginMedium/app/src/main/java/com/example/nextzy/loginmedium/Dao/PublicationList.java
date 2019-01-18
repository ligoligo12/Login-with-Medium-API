package com.example.nextzy.loginmedium.Dao;

import com.google.gson.annotations.SerializedName;

public class PublicationList {

    @SerializedName("id") private String id;
    @SerializedName("name") private String name;
    @SerializedName("description") private String description;
    @SerializedName("url") private String url;
    @SerializedName("imageUrl") private String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
