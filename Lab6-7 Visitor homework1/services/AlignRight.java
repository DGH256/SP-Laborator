package services;

import models.Context;
import models.Paragraph;

public class AlignRight implements AlignStrategy{
    public void render(Paragraph paragraph, Context context)
    {
        System.out.println("Align right: "+paragraph);
    }
}
