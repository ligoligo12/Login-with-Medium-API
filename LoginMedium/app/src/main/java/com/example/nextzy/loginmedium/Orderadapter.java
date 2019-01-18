package com.example.nextzy.loginmedium;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.nextzy.loginmedium.TypeRecycleView.BaseorderDetail;
import com.example.nextzy.loginmedium.TypeRecycleView.CardviewOrderItem;
import com.example.nextzy.loginmedium.TypeRecycleView.OrderDetailType;
import com.example.nextzy.loginmedium.TypeRecycleView.UserDetailItem;

import java.util.ArrayList;
import java.util.List;

public class Orderadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<BaseorderDetail> baseorderDetails;

   public Orderadapter(){
       baseorderDetails = new ArrayList<>();
   }

   public void setBaseorderDetails(List<BaseorderDetail> baseorderDetails){
       this.baseorderDetails = baseorderDetails;
   }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewtype) {

       if(viewtype == OrderDetailType.TYPE_USER_DETAIL)
       {
           View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.userdetailviewholder,viewGroup,false);
           return new UserDetailviewholder(view);
       }
       else if(viewtype == OrderDetailType.TYPE_ORDER)
       {
           View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardviewlist,viewGroup,false);
            return new CardViewListviewholder(view);
       }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        BaseorderDetail baseorderDetail = baseorderDetails.get(position);
        if(viewHolder instanceof UserDetailviewholder)
        {
            UserDetailviewholder userDetailviewholder = (UserDetailviewholder) viewHolder;
            UserDetailItem userDetailItem = (UserDetailItem) baseorderDetail;
            setupUserdetail(userDetailviewholder,userDetailItem);
        }
        else if(viewHolder instanceof CardViewListviewholder)
        {
            CardViewListviewholder cardViewListviewholder = (CardViewListviewholder) viewHolder;
            CardviewOrderItem cardviewOrderItem = (CardviewOrderItem) baseorderDetail;
            setupOrder(cardViewListviewholder,cardviewOrderItem);


        }
    }

    private void setupUserdetail(UserDetailviewholder userDetailviewholder,UserDetailItem userDetailItem){

       userDetailviewholder.tvUsername.setText(userDetailItem.getUserNameInDetail());
       userDetailviewholder.tvName.setText(userDetailItem.getNameInDetail());
        Glide.with(userDetailviewholder.tvImage).load(userDetailItem.getImageProfileInDetail()).into(userDetailviewholder.tvImage);


    }
    private void setupOrder(final CardViewListviewholder cardViewListviewholder, final CardviewOrderItem cardviewOrderItem){
       cardViewListviewholder.pucName.setText(cardviewOrderItem.getNameInCardDetail());
       cardViewListviewholder.pucDesception.setText(cardviewOrderItem.getDesceptionInCardDetail());
       Glide.with(cardViewListviewholder.pucImage).load(cardviewOrderItem.getImageProfileInCardDetail()).into(cardViewListviewholder.pucImage);
        cardViewListviewholder.pucImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Main2Activity.class);
                intent.putExtra("urlPage",cardviewOrderItem.getUrlPage());
                v.getContext().startActivity(intent);
            }



        });

   }

    public int getItemViewType(int position){
       return baseorderDetails.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return baseorderDetails.size();
    }
}
