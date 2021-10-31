package com.company;

public class AlignLeft implements AlignStrategy{

    public void render(Paragraph paragraph, Context context)
    {
        System.out.println("Align left: "+paragraph);
    }
}
