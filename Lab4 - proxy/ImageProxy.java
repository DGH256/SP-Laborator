package com.company;

public class ImageProxy implements Element,Picture{
    private String url;
    private Dimension dim = new Dimension(300,300);
    private Image img;

    public ImageProxy(String url)
    {
        this.url=url;
    }
    @Override
    public void print() {
        System.out.println("Image proxy with url:"+url+" and dimension:"+dim);

        loadImage().print();

    }

    private Image loadImage()
    {
       if(this.img==null)
       {
           this.img = new Image(url);
       }

       return this.img;
    }

    @Override
    public void add(Element element) throws Exception {

    }

    @Override
    public void remove(Element element) {

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
}
