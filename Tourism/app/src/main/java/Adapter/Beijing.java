package Adapter;

public class Beijing {
    private String name;
    private  int imageId;
    public Beijing(String name,int imageId){
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
