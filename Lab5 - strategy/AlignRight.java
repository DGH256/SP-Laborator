package com.company;

public class AlignRight implements AlignStrategy{
    public void render(Paragraph paragraph, Context context)
    {
        System.out.println("Align right: "+paragraph);
    }
}
