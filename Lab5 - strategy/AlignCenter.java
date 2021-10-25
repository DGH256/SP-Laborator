package com.company;

public class AlignCenter implements AlignStrategy{
    public void render(Paragraph paragraph, Context context)
    {
        System.out.println("Align center: "+paragraph);
    }
}
