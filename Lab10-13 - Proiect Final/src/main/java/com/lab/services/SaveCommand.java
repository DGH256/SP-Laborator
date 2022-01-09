package com.lab.services;

import com.lab.entities.*;

public class SaveCommand implements Command{
    private Section section;

    public SaveCommand(Section section)
    {
        this.section=section;
    }
    @Override
    public void execute() {
        this.section.add((new Paragraph("Paragraf nou")));

        DocumentManager.getInstance().getBook().addContent(section);
    }
}
