package Adapter;

public class Hainan {
    private String name;
    private  int imageId;
    public Hainan(String name, int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return  name;
    }
    public int getImageId(){
        return imageId;
    }
}
