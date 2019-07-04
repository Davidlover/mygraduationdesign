package Litepal;

import org.litepal.crud.LitePalSupport;

public class Video extends LitePalSupport {
//    vid  string
//    vpath string
    private String vid;
    private  String vpath;
    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVpath() {
        return vpath;
    }

    public void setVpath(String vpath) {
        this.vpath = vpath;
    }


}
