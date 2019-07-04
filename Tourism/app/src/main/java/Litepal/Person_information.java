package Litepal;

import org.litepal.crud.LitePalSupport;

public class Person_information extends LitePalSupport {
    private String uid;
    private String username;
    private int sex;
    private int fans;
    private int follow;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getFollow() {
        return follow;
    }

    public void setFollow(int follow) {
        this.follow = follow;
    }

    public String[] getFan_list() {
        return fan_list;
    }

    public void setFan_list(String[] fan_list) {
        this.fan_list = fan_list;
    }

    public String[] getFollow_list() {
        return follow_list;
    }

    public void setFollow_list(String[] follow_list) {
        this.follow_list = follow_list;
    }

    private String[] fan_list;
    private String[] follow_list;
}
