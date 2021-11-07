package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Image implements Picture {
    private String url;
    private Dimension dim;

    private ImageLoader imageLoader;
    private ImageLoaderFactory imageFactory = new ImageLoaderFactory();

    public void loadContent() throws Exception {
        imageLoader = imageFactory.create(url);
    }

    public Image(String imageName){
        this.url = imageName;

        try {
            imageLoader = imageFactory.create(url);
        }
        catch(Exception ex){ ex.printStackTrace(); }

        try {TimeUnit.SECONDS.sleep(1);} catch( InterruptedException e) { e.printStackTrace(); }
    }


    public void print(JPanel panel, JLabel label, JFrame frame)
    {
        try {
            BufferedImage image = imageLoader.load();
            label = new JLabel(new ImageIcon(image));
            panel = new JPanel();
            panel.add(label);
            frame=new JFrame();
            dim = new Dimension(image.getWidth(), image.getHeight());
            frame.setSize(new java.awt.Dimension(dim.getWidth(),dim.getHeight()));
            frame.add(panel);
            frame.setVisible(true);
            }

        catch (Exception ex)
        {
            System.out.println("Exception thrown while loading image "+url+" "+ex.getMessage());
        }


    }

    public void print( PrintStream str)
    {
        str.println("Image with url :"+url+" and dimension: "+dim.getWidth()+"x"+dim.getHeight()+" px");
    }

    @Override
    public String url() {
       return this.url;
    }

    @Override
    public Dimension dim() {
        return this.dim;
    }
}
