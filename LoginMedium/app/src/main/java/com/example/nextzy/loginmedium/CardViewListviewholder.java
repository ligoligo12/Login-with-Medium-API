package com.example.nextzy.loginmedium;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CardViewListviewholder extends RecyclerView.ViewHolder {
    public TextView pucName;
    public TextView pucDesception;
    public ImageView pucImage;


    public CardViewListviewholder(@NonNull View itemView) {
        super(itemView);
        pucName = (TextView) itemView.findViewById(R.id.textNamePuc);
        pucDesception = (TextView) itemView.findViewById(R.id.textDesPuc);
        pucImage = (ImageView) itemView.findViewById(R.id.imgPuc);
    }
}
