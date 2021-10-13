package com.company;

import java.util.ArrayList;

public class SubChapter {
    private String name;

    private ArrayList<Element> elements = new ArrayList<>();

    public SubChapter(String name) {
        this.name=name;
    }

   public void addElement(Element element)
   {
       this.elements.add(element);
   }

    public void print()
    {
        System.out.println("Subcapitol :"+name);

        for(Element element: elements)
        {
            element.print();
        }

    }
}
