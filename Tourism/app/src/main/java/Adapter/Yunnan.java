package Adapter;

public class Yunnan {
    private String name;
    private  int imageId;
    public Yunnan(String name, int imageId){
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
