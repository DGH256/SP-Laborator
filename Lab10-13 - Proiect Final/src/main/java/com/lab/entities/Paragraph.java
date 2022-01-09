package com.lab.entities;

import  com.lab.services.*;

public class Paragraph implements Element, Visitee {
    private String text;

    private AlignStrategy strategy;

    public void setAlignStrategy(AlignStrategy strat)
    {
        this.strategy=strat;
    }

    public Paragraph(String text) {
        this.text = text;
    }
    @Override
    public void add(Element element) {
        //not needed
    }

    public String getText()
    {
        return this.text;
    }

    public AlignStrategy getStrategy()
    {
        return this.strategy;
    }

    @Override
    public void remove(Element element) {
        //not needed
    }

    public void print() {
        if(strategy!=null)
        {
            strategy.render(this,new Context(100));
        }
        else {
            System.out.println(this.text);
        }
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

    @Override
    public void accept(Visitor visitor) {
        visitor.VisitParagraph(this);
    }


}
