package com.example.lenovo.tourism.FindWeb;

public class Web {
    private  String name;
    private int imageId;

    public Web(String web, int icon_account) {
        this.name=web;
        this.imageId=icon_account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
