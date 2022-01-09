package com.lab.services;


import com.lab.entities.*;

import java.util.ArrayList;
import java.util.List;

public class JsonExportVisitor implements Visitor{

    String jsonOutput="";
    @Override
    public void VisitBook(Book book) {
        jsonOutput+=String.format("{\"Book\": {\"Title\": \"%s\"", book.getTitle());

        List<Author> authors = book.getAuthors();

        if(authors.size()>0)
        {
            jsonOutput+=",\"authors\" : [";

            for(int i=0;i<authors.size();i++)
            {
                jsonOutput+=String.format("{\"Author\" : {\"Name\": \"%s\"}}", authors.get(i).getName());

                if(i!= authors.size()-1)
                {
                    jsonOutput+=",";
                }
            }
            jsonOutput+="]";
        }


        ArrayList<Element> elements = book.getElements();

        if(elements.size()>0) {
            jsonOutput+=",\"elements\":[";

            for (int i=0;i<elements.size();i++) {

                Visitee casted = (Visitee) elements.get(i);
                casted.accept(this);

                if(i!= elements.size()-1)
                {
                    jsonOutput+=",";
                }
            }

            jsonOutput+="]";
        }

        jsonOutput+="}}";
    }

    @Override
    public void VisitSection(Section section) {
        jsonOutput+=String.format("{\"Section\": {\"Title\": \"%s\"", section.getTitle());

        ArrayList<Element> elements = section.getElements();

        if(elements.size()>0) {
            jsonOutput+=",\"elements\":[";

            for (int i=0;i<elements.size();i++) {
                Visitee casted = (Visitee) elements.get(i);
                casted.accept(this);

                if(i!= elements.size()-1)
                {
                    jsonOutput+=",";
                }
            }
            jsonOutput+="]";
        }


        jsonOutput+="}}";
    }

    @Override
    public void VisitParagraph(Paragraph paragraph) {
        jsonOutput+=generateJson(paragraph);
    }

    @Override
    public void VisitImageProxy(ImageProxy p) {
        jsonOutput+=generateJson(p);
    }

    @Override
    public void VisitImage(Image i) {
        jsonOutput+=generateJson(i);
    }

    @Override
    public void VisitTable(Table_element t) {
        jsonOutput+=generateJson(t);
    }

    public String showJsonOutput()
    {
        return jsonOutput;
    }


    public String generateJson(Paragraph p)
    {
        return String.format("{\"Paragraph\" : {\"Text\": \"%s\",\"AlignStrategy\": \"%s\" }}",
                p.getText(), generateObjectName(p.getStrategy()));
    }

    public String generateJson(Image i)
    {
        return String.format("{\"Image\" : {\"Url\": \"%s\" ,\"ImageLoader\": \"%s\" ,\"ImageLoaderFactory\": \"%s\"}}",
                i.getUrl(), generateObjectName(i.getImageLoader()), generateObjectName(i.getImageLoaderFactory()));
    }

    public String generateJson(ImageProxy p)
    {
        String imageOutput ="";

        Image image = p.getImage();
        if(image==null){ imageOutput="null";} else{ imageOutput= generateJson(image); }

        return String.format("{\"ImageProxy\" : {\"Url\": \"%s\", \"Dimension\": {\"width\" :\"%s\",\"height\" :\"%s\" } , \"Image\": %s}}",
                p.getUrl(), p.getDimension().getWidth(), p.getDimension().getHeight(), imageOutput);
    }

    public String generateJson(Table_element t)
    {
        return String.format("{\"Table\" : {\"Title\": \"%s\"}}", t.getTitle());
    }


    public String generateObjectName(Object obj)
    {
        if(obj==null)
        {
            return "null";
        }
        else
        {
            return obj.getClass().getSimpleName();
        }
    }
}
