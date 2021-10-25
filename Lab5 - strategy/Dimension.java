package com.company;

public class Dimension {

    private int height;

    private int width;

    public Dimension(int height,int width)
    {
        this.height=height;
        this.width=width;
    }

    public void print()
    {
        System.out.println("Dimension :"+height+","+width);
    }
}
