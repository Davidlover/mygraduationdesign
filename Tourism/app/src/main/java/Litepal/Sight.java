package Litepal;

import org.litepal.crud.LitePalSupport;

public class Sight extends LitePalSupport {
    //    city string
//    s_picture string
//    brif_introdution string
//    introdution string
//    sight具体内容模块
//    city string
    private String city;
    private String s_picture;
    private String bri_introdution;
    private String introdution;
    private String sight_content;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getS_picture() {
        return s_picture;
    }

    public void setS_picture(String s_picture) {
        this.s_picture = s_picture;
    }

    public String getBri_introdution() {
        return bri_introdution;
    }

    public void setBri_introdution(String bri_introdution) {
        this.bri_introdution = bri_introdution;
    }

    public String getIntrodution() {
        return introdution;
    }

    public void setIntrodution(String introdution) {
        this.introdution = introdution;
    }

    public String getSight_content() {
        return sight_content;
    }

    public void setSight_content(String sight_content) {
        this.sight_content = sight_content;
    }


}
