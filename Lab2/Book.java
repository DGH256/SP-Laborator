package com.company;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String name;

    private ArrayList<Author> authors = new ArrayList<>();

    private ArrayList<Chapter> chapters = new ArrayList<>();

    private TableOfContents toc;

    Book(String bookname) {
        this.name=bookname;
    }



    public int addChapter(String chapter){
        this.chapters.add(new Chapter(chapter));

        return this.chapters.size()-1;
    }

    public Chapter getChapterByIndex(int index)
    {
        if(index<this.chapters.size())
        {
            return this.chapters.get(index);
        }
        else
        {
            return null;
        }
    }

    public void addAuthor(Author author){
        this.authors.add(author);
    }


    public void print() {
        System.out.println("Book name: "+name);

       for(Author author : this.authors)
       {
           author.print();
       }

        for(Chapter chapter:chapters)
        {
            chapter.print();
        }
    }

}
