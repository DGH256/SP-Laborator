package com.lab.services;
import com.lab.entities.*;

public interface Visitor {

    void VisitBook(Book book);
    void VisitSection(Section section);
    void VisitParagraph(Paragraph p);
    void VisitImageProxy(ImageProxy p);
    void VisitImage(Image i);
    void VisitTable(Table_element t);


}
