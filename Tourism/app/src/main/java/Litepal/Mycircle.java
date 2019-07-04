package Litepal;

import android.net.Uri;

import org.litepal.crud.LitePalSupport;

public class Mycircle extends LitePalSupport {
    private String usename;
    private String title;
    private String photonum;
    private String content;
    private String comment;
    private int likenum;
    private int diarynum;
    private String cover_photo;   //封面图片
    private long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getDiarynum() {

        return diarynum;
    }

    public void setDiarynum(int diarynum) {
        this.diarynum = diarynum;
    }



    public String getUsename() {
        return usename;
    }

    public void setUsename(String uid) {
        this.usename = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotonum() {
        return photonum;
    }

    public void setPhotonum(String photonum) {
        this.photonum = photonum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getLikenum() {
        return likenum;
    }

    public void setLikenum(int likenum) {
        this.likenum = likenum;
    }

    public String getCover_photo() {
        return cover_photo;
    }

    public void setCover_photo(String cover_photo) {
        this.cover_photo = cover_photo;
    }


}
