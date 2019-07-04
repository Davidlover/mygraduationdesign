package Litepal;

import org.litepal.crud.LitePalSupport;

public class Login extends LitePalSupport {
    private String uid;
    private String upassword;
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }


}
