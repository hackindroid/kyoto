package com.hackindroid.kyoto.models;

/**
 * Created by Sushila on 12/15/2017.
 */

public class SellDetails {
    String title;
    String desc;
    String imgPath;
    String imgView;

    public SellDetails(String title, String desc, String imgPath, String imgView) {
        this.title = title;
        this.desc = desc;
        this.imgPath = imgPath;
        this.imgView = imgView;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getImgView() {
        return imgView;
    }
}
