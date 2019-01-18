package com.example.nextzy.loginmedium.TypeRecycleView;

public class CardviewOrderItem extends BaseorderDetail {

    private String nameInCardDetail;
    private String desceptionInCardDetail;
    private String imageProfileInCardDetail;
    private String urlPage;
    public CardviewOrderItem() {
        super(OrderDetailType.TYPE_ORDER);
    }

    public String getNameInCardDetail() {
        return nameInCardDetail;
    }

    public void setNameInCardDetail(String nameInCardDetail) {
        this.nameInCardDetail = nameInCardDetail;
    }

    public String getDesceptionInCardDetail() {
        return desceptionInCardDetail;
    }

    public void setDesceptionInCardDetail(String desceptionInCardDetail) {
        this.desceptionInCardDetail = desceptionInCardDetail;
    }

    public String getImageProfileInCardDetail() {
        return imageProfileInCardDetail;
    }

    public void setImageProfileInCardDetail(String imageProfileInCardDetail) {
        this.imageProfileInCardDetail = imageProfileInCardDetail;
    }

    public String getUrlPage() {
        return urlPage;
    }

    public void setUrlPage(String urlPage) {
        this.urlPage = urlPage;
    }
}
