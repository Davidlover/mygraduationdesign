package Litepal;

import org.litepal.crud.LitePalSupport;

public class Strategy extends LitePalSupport {
//    city string prikey
//    strategy string
//    s_picture string
    private  String city;
    private  String strategy;
    private  String s_picture;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getS_picture() {
        return s_picture;
    }

    public void setS_picture(String s_picture) {
        this.s_picture = s_picture;
    }
}
