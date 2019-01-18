package com.example.nextzy.loginmedium.Dao;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;

public class GetToken {

    @SerializedName("token_type")
    private String tokenType;
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("refresh_token")
    private String refreshToken;
    @SerializedName("scope")
    private String[] scopeT;
    @SerializedName("expires_at")
    private double expiresAt;

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String[] getScopeT() {
        return scopeT;
    }

    public void setScopeT(String[] scopeT) {
        this.scopeT = scopeT;
    }

    public double getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(double expiresAt) {
        this.expiresAt = expiresAt;
    }
}
