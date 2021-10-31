package com.company;

public class Paragraph implements Element {
    private String text;

    private AlignStrategy strategy;

    public void setAlignStrategy(AlignStrategy strat)
    {
        this.strategy=strat;
    }

    public Paragraph(String text) {
        this.text = text;
    }

    public void print() {
        if(strategy!=null)
        {
            strategy.render(this,new Context());
        }
        else {
            System.out.println(this.text);
        }
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
        if (!(element instanceof Paragraph))
            return false;
        else {
            return ((Paragraph) element).text.equals(this.text);
        }
    }

    @Override
    public Element clone() {
        Paragraph newparagraph = new Paragraph(this.text);
        return newparagraph;
    }
}
