package models;

import services.Visitee;
import services.Visitor;

public class Table implements Element, Visitee {
    private String title;

    public Table(String title) {
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
        if (!(element instanceof Table))
            return false;
        else {
            return ((Table) element).title.equals(this.title);
        }
    }

    @Override
    public Element clone() {
        Table newtable = new Table(this.title);
        return newtable;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.VisitTable(this);
    }
}
