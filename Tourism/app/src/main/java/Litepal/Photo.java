package Litepal;

import org.litepal.crud.LitePalSupport;

public class Photo extends LitePalSupport {
    private String pid;
    private String ppath;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPpath() {
        return ppath;
    }

    public void setPpath(String ppath) {
        this.ppath = ppath;
    }
}
