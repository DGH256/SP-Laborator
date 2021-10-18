package com.company;

import java.util.ArrayList;


public class Section implements Element {
    private String title;
    private ArrayList<Element> elements =new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void add(Element element) {
        this.elements.add(element.clone());
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
            newclone.add(el.clone());
        }

        return newclone;
    }

    public void print() {
        System.out.println("Titlu: " + this.title);

        for (Element i : this.elements)
            i.print();
    }
}
