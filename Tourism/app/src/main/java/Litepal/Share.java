package Litepal;

import org.litepal.crud.LitePalSupport;

public class Share extends LitePalSupport {
    private  String share_aim;

    public String getShare_aim() {
        return share_aim;
    }

    public void setShare_aim(String share_aim) {
        this.share_aim = share_aim;
    }
}
