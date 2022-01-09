package com.lab.entities;

public class Dimension {

    private int height;

    private int width;

    public Dimension(int width,int height)
    {
        this.height=height;
        this.width=width;
    }

    public int getHeight()
    {
        return this.height;
    }

    public int getWidth()
    {
        return this.width;
    }

    public void print()
    {
        System.out.println("Dimension :"+height+","+width);
    }
}
