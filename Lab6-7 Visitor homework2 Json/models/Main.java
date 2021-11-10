package models;

import services.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        p2.setAlignStrategy(new AlignRight());
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        p3.setAlignStrategy(new AlignLeft());
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);
        cap1.add(new ImageProxy("ImageOne.jpg"));
        cap1.add(new Image("ImageTwo.png"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));

        Section cap22= new Section("Sectiunea 22");

        Section cap33= new Section("Sectiunea 33");

        cap33.add(new ImageProxy("ImageProxy33.jpg"));
        cap33.add(new Image("Image33.png"));
        cap33.add(new Table("Table 33"));

        cap22.add(cap33);
        cap1.add(cap22);
        p3.add(cap22);

        Book book1 = new Book("Book 1");
        book1.addAuthor( new Author("Autor 1"));
        book1.addAuthor( new Author("Autor 2"));
        book1.addContent(cap1);


        RenderContentVisitor stats = new  RenderContentVisitor();
        book1.accept(stats);

        CountElementsVisitor counter = new CountElementsVisitor();
        book1.accept(counter);
        counter.showStatistics();


        JsonExportVisitor jsonExporter = new JsonExportVisitor();
        book1.accept(jsonExporter);

        String jsonOutput = jsonExporter.showJsonOutput();

        System.out.println(jsonOutput);

        FileHandler.writeToFile(jsonOutput, "output.txt");

    }
}