package com.company;

public class TableOfContents implements Element {
    private String title;

    public TableOfContents(String title)
    {
        this.title=title;
    }

    public void print() {
        System.out.println("Cuprins");
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
        //not needed
        return false;
    }

    @Override
    public Element clone() {
       TableOfContents newtoc=new TableOfContents(this.title);
       return newtoc;
    }
}
