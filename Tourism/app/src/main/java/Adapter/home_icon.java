package Adapter;

public class home_icon {
    private String name;
    private  int imageId;
    public home_icon(String name, int imageId){
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
