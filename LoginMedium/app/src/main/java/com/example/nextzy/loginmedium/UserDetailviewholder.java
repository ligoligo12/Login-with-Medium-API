package com.example.nextzy.loginmedium;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class UserDetailviewholder extends RecyclerView.ViewHolder{
    public TextView tvName;
    public TextView tvUsername;
    public ImageView tvImage;

    public UserDetailviewholder(@NonNull View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.qqq);
        tvUsername = (TextView) itemView.findViewById(R.id.www)  ;
        tvImage = (ImageView) itemView.findViewById(R.id.imageProfile) ;

    }
}
