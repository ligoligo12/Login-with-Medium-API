package com.example.nextzy.loginmedium.TypeRecycleView;

import android.widget.ImageView;

import com.example.nextzy.loginmedium.Dao.CollectionList;
import com.example.nextzy.loginmedium.Dao.PublicationList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderDetailConvert {

    public static UserDetailItem createUserDetail(String nameInDetail, String userNameInDetail, String imageProfileInDetail){

        UserDetailItem userDetailItem = new UserDetailItem();
        userDetailItem.setNameInDetail("Name: "+nameInDetail);
        userDetailItem.setUserNameInDetail("Username: "+userNameInDetail);
        userDetailItem.setImageProfileInDetail(imageProfileInDetail);
        return userDetailItem;
    }



    //List of Publication details
    public static List<BaseorderDetail> createOrder(CollectionList collectionList){

        List<BaseorderDetail> orderDetailsList = new ArrayList<>();

        orderDetailsList.addAll(getPublicationList(collectionList));

        return orderDetailsList;
    }



    private static List<BaseorderDetail> getPublicationList(CollectionList collectionList){

        List<BaseorderDetail> dataDetailList = new ArrayList<>();
        if(collectionList != null){

            for (PublicationList data :collectionList.getData()){
                String name = data.getName();
                String desception = data.getDescription();
                String imageProfile = data.getImageUrl();
                String urlPage = data.getUrl();
                dataDetailList.add(createDetail(name,desception,imageProfile,urlPage));
            }
        }
        return dataDetailList;


    }




    private static CardviewOrderItem createDetail(String nameInDetail,String userNameInDetail,String imageProfileInDetail,String urlPage){
        CardviewOrderItem userDetailItem = new CardviewOrderItem();
        userDetailItem.setNameInCardDetail("Name: "+nameInDetail);
        userDetailItem.setDesceptionInCardDetail("Desception: "+userNameInDetail);
        userDetailItem.setImageProfileInCardDetail(imageProfileInDetail);
        userDetailItem.setUrlPage(urlPage);
        return  userDetailItem;
    }

}
