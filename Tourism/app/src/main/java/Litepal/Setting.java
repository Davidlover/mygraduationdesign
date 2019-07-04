package Litepal;

import org.litepal.crud.LitePalSupport;

public class Setting extends LitePalSupport {
   private String  themecolor;
   private int comment_or_not ;
   private int  like_or_not;

    public String getThemecolor() {
        return themecolor;
    }

    public void setThemecolor(String themecolor) {
        this.themecolor = themecolor;
    }

    public int getComment_or_not() {
        return comment_or_not;
    }

    public void setComment_or_not(int comment_or_not) {
        this.comment_or_not = comment_or_not;
    }

    public int getLike_or_not() {
        return like_or_not;
    }

    public void setLike_or_not(int like_or_not) {
        this.like_or_not = like_or_not;
    }
}
