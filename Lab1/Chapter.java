package com.company;

import java.util.ArrayList;

public class Chapter {
    private String title;
    private ArrayList<SubChapter> subchapters = new ArrayList<>();

    public Chapter(String title){
        this.title=title;
    }

    public int addSubChapter(String subchapter)
    {
        subchapters.add(new SubChapter(subchapter));

        return this.subchapters.size()-1;
    }

    public SubChapter getSubchapterByIndex(int index){
        if(index<subchapters.size())
        {
            return this.subchapters.get(index);
        }
        else
        {
            return null;
        }
    }

    public void print()
    {
        System.out.println("Chapter :"+title);

        for(SubChapter subchapter : subchapters)
        {
            subchapter.print();
        }
    }
}
