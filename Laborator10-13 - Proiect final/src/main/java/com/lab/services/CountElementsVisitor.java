package com.lab.services;

import com.lab.entities.*;

public class CountElementsVisitor implements Visitor{

    private int nr_books=0;
    private int nr_sections=0;
    private int nr_paragraphs=0;
    private int nr_images=0;
    private int nr_imageproxy=0;
    private int nr_tables=0;

    @Override
    public void VisitBook(Book book) {
        for (Element i : book.getElements())
        {
            Visitee casted = (Visitee) i;
            casted.accept(this);
        }
        nr_books++;
    }

    @Override
    public void VisitSection(Section section) {
        for (Element i : section.getElements())
        {
            Visitee casted = (Visitee) i;
            casted.accept(this);
        }
        nr_sections++;
    }

    @Override
    public void VisitParagraph(Paragraph p) {
        nr_paragraphs++;
    }

    @Override
    public void VisitImageProxy(ImageProxy p) {
        nr_imageproxy++;
    }

    @Override
    public void VisitImage(Image i) {
        nr_images++;
    }

    @Override
    public void VisitTable(Table_element t) {
        nr_tables++;
    }

    public void showStatistics() {
        System.out.println("Books visited : "+nr_books);
        System.out.println("Paragraphs visited : "+nr_paragraphs);
        System.out.println("Sections visited : "+nr_sections);
        System.out.println("Images visited : "+nr_images);
        System.out.println("Image proxies visited : "+nr_images);
        System.out.println("Tables visited : "+nr_tables);
    }
}
