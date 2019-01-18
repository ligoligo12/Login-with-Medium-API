package com.example.nextzy.loginmedium;

import android.widget.ImageView;

public class itemrecycle {

    private ImageView mUrl;
    private String mName;
    private String mdesciption;

    public  itemrecycle(ImageView imageUrl,String name,String desception)
    {
        mUrl = imageUrl;
        mName = name;
        mdesciption = desception;
    }

    public ImageView getImageUrl()
    {
        return  mUrl;
    }
    public String getNamere()
    {
        return  mName;
    }
    public String getDesceptionre()
    {
        return mdesciption;
    }


}
