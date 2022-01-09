package com.lab.entities;
import java.util.ArrayList;

import com.lab.services.*;

public class Section implements Element, Visitee {
    private String title;
    private ArrayList<Element> elements =new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void add(Element element) {
        //this.elements.add(element.clone());
        this.elements.add(element);
    }

    @Override
    public void remove(Element element) {
        this.elements.remove(element);
    }

    @Override
    public boolean find(Element element) {
        for (Element i : this.elements) {
            if (i.find(element))
                return true;
        }

        return false;
    }

    @Override
    public Element clone() {
        Section newclone = new Section(this.title);

        for(Element el : this.elements)
        {
            newclone.add(el);
        }

        return newclone;
    }

    public String getTitle()
    {
        return this.title;
    }

    public ArrayList<Element> getElements()
    {
        return this.elements;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.VisitSection(this);
    }
}
