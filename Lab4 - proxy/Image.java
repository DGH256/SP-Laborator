package com.company;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Image implements Element, Picture {
    private String imageName;
    private Dimension dim = new Dimension(400,400);

    public Image(String imageName) {
        this.imageName = imageName;

        try
        {
            TimeUnit.SECONDS.sleep(5);
        }
        catch( InterruptedException e) { e.printStackTrace(); }
    }

    public void print() {
        System.out.println(this.imageName);
    }

    @Override
    public void add(Element element) {
        //not needed
    }


    @Override
    public void remove(Element element) {
        //not needed
    }

    @Override
    public boolean find(Element element) {
        if (!(element instanceof Image))
            return false;
        else {
            return ((Image) element).imageName.equals(this.imageName);
        }
    }

    @Override
    public Element clone() {
        Image newimage = new Image(this.imageName);
        return newimage;
    }

    @Override
    public String url() {
       return this.imageName;
    }

    @Override
    public Dimension dim() {
        return this.dim;
    }
}
