package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Book discoTitanic = new Book("Disco Titanic");
        Author rpGheo = new Author("Radu Pavel Gheo");

        discoTitanic.addAuthor(rpGheo);
        int indexChapterOne = discoTitanic.addChapter("Capitolul 1");

        Chapter chp1 = discoTitanic.getChapterByIndex(indexChapterOne);
        int indexSubChapterOneOne = chp1.addSubChapter("Subcapitolul 1.1");

        SubChapter scOneOne = chp1.getSubchapterByIndex(indexSubChapterOneOne);
        scOneOne.addElement(new Paragraph("Paragraph 1"));
        scOneOne.addElement(new Paragraph("Paragraph 2"));
        scOneOne.addElement(new Paragraph("Paragraph 3"));
        scOneOne.addElement(new Image("Image 1"));
        scOneOne.addElement(new Paragraph("Paragraph 4"));
        scOneOne.addElement(new Table("Table 1"));
        scOneOne.addElement(new Paragraph("Paragraph 5"));
        scOneOne.print();

    }
}
