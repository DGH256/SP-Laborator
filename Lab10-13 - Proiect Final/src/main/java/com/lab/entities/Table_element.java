package com.lab.entities;

import com.lab.services.*;

public class Table_element implements Element, Visitee {
    private String title;

    public Table_element(String title) {
        this.title = title;
    }

    public void print() {
        System.out.println(this.title);
    }

    public String getTitle()
    {
        return this.title;
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
        if (!(element instanceof Table_element))
            return false;
        else {
            return ((Table_element) element).title.equals(this.title);
        }
    }

    @Override
    public Element clone() {
        Table_element newtable = new Table_element(this.title);
        return newtable;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.VisitTable(this);
    }
}