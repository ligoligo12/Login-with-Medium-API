package com.example.nextzy.loginmedium.TypeRecycleView;

public class UserDetailItem extends BaseorderDetail {
private String nameInDetail;
private String userNameInDetail;
private String imageProfileInDetail;

    public UserDetailItem() {
        super(OrderDetailType.TYPE_USER_DETAIL);
    }

    public String getNameInDetail() {
        return nameInDetail;
    }

    public void setNameInDetail(String nameInDetail) {
        this.nameInDetail = nameInDetail;
    }

    public String getUserNameInDetail() {
        return userNameInDetail;
    }

    public void setUserNameInDetail(String userNameInDetail) {
        this.userNameInDetail = userNameInDetail;
    }

    public String getImageProfileInDetail() {
        return imageProfileInDetail;
    }

    public void setImageProfileInDetail(String imageProfileInDetail) {
        this.imageProfileInDetail = imageProfileInDetail;
    }
}
