package com.appank.cardviewdanlistview;


public class cards {
    private  String imgUrl;
    private  String name,rating,type;

    public cards(String imgUrl,
                 String name,
                 String rating,
                 String type) {


        this.imgUrl = imgUrl;
        this.name = name;
        this.rating = rating;
        this.type = type;

    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle1() {
        return name;
    }
    public String getTitle2() {
        return rating;
    }
    public String getTitle3() {
        return type;
    }

    public void setTitle(String name,String rating,String type) {
        this.name = name;
        this.rating = rating;
        this.type = type;
    }
}