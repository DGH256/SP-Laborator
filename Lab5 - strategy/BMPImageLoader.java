package com.company;

public class BMPImageLoader implements ImageLoader{
    private String imageName;

    public BMPImageLoader(String imageName)
    {
        this.imageName=imageName;
    }

    @Override
    public void load(String str) {
        System.out.println("BMP Loaded image "+str);
    }
}
