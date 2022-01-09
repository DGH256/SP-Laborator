package com.lab.entities;

import com.lab.services.*;

public class ImageProxy implements Element,Picture, Visitee {
    private String url;
    private Dimension dim = new Dimension(300,300);
    private Image img;

    public ImageProxy(String url)
    {
        this.url=url;
    }

    private Image loadImage()
    {
        if(this.img==null)
        {
            this.img = new Image(url);
        }

        return this.img;
    }

    public Image getImage()
    {
        return this.loadImage();
    }

    public Dimension getDimension()
    {
        return this.dim;
    }

    @Override
    public void add(Element element) throws Exception {

    }

    @Override
    public void remove(Element element) {

    }

    public String getUrl()
    {
        return this.url;
    }
    @Override
    public boolean find(Element element) {
        return false;
    }

    @Override
    public Element clone() {
        ImageProxy newProxy = new ImageProxy(this.url);
        return newProxy;
    }

    @Override
    public String url() {
        return null;
    }

    @Override
    public Dimension dim() {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.VisitImageProxy(this);
    }
}
