package com.lab.services;

import com.lab.entities.*;

public class RenderContentVisitor implements Visitor{

    @Override
    public void VisitBook(Book book) {
        System.out.println("Carte: " + book.getTitle());

        System.out.println("Autori: ");
        for (Author i : book.getAuthors())
            i.print();

        System.out.println("Elemente: ");
        for (Element i : book.getElements())
        {
            Visitee casted = (Visitee) i;
            casted.accept(this);
        }

        System.out.println();


    }

    @Override
    public void VisitSection(Section section) {
        System.out.println("Titlu : "+section.getTitle());

        for (Element i : section.getElements())
        {
            Visitee casted = (Visitee) i;
            casted.accept(this);
        }

    }

    @Override
    public void VisitParagraph(Paragraph p) {
        if(p.getStrategy()!=null)
        {
            p.getStrategy().render(p,new Context(100));
        }
        else {
            System.out.println(p.getText());
        }


    }

    @Override
    public void VisitImageProxy(ImageProxy p) {
        System.out.println("Image proxy with url:"+p.getUrl());

        p.getImage().print(System.out);

    }

    @Override
    public void VisitImage(Image i) {
        System.out.println("Image with url:"+i.getUrl());
    }

    @Override
    public void VisitTable(Table_element t) {
        System.out.println(t.getTitle());

    }

}
