package models;

import services.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class Image implements Element, Picture,Visitee{
    private String url;
    private Dimension dim = new Dimension(400,400);

    private ImageLoader content;
    private ImageLoaderFactory imageFactory = new ImageLoaderFactory();

    public void loadContent() throws Exception {
        content = imageFactory.create(url);
    }

    public Image(String imageName) {
        this.url = imageName;

        try
        {
            TimeUnit.SECONDS.sleep(1);
        }
        catch( InterruptedException e) { e.printStackTrace(); }
    }

    public void print() {
/*
        try {
            BufferedImage myPicture = ImageIO.read(new File(url));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            JPanel jPanel = new JPanel();
            jPanel.add(picLabel);
            JFrame f = new JFrame();
            dim = new Dimension(myPicture.getWidth(), myPicture.getHeight());
            f.setSize(new java.awt.Dimension(dim.getWidth(),dim.getHeight()));
            f.add(jPanel);
            f.setVisible(true);
        }
        catch (Exception ex)
        {
            System.out.println("Exception thrown while loading image "+url+" "+ex.getMessage());
        }

        System.out.println("Image with url:"+url+" and dimension: "+dim.getWidth()+"x"+dim.getHeight()+" px");

 */
    }

    public String getUrl()
    {
        return this.url;
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
            return ((Image) element).url.equals(this.url);
        }
    }

    @Override
    public Element clone() {
        Image newimage = new Image(this.url);
        return newimage;
    }

    @Override
    public String url() {
       return this.url;
    }

    @Override
    public Dimension dim() {
        return this.dim;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.VisitImage(this);
    }
}
