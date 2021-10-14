package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        Book noapteBuna = new Book("Noapte buna, copii!");

        Author rpGheo = new Author("Radu Pavel Gheo");
        noapteBuna.addContent(new Paragraph("Multumesc celor care ..."));
        noapteBuna.addAuthor(rpGheo);

        Section cap1 = new Section("Capitolul 1");
        Section cap11 = new Section("Capitolul 1.1");
        Section cap111 = new Section("Capitolul 1.1.1");
        Section cap1111 = new Section("Subchapter 1.1.1.1");
        cap1.add(new Paragraph("Moto capitol"));
        cap11.add(new Paragraph("Text from subchapter 1.1"));
        cap111.add(new Paragraph("Text from subchapter 1.1.1"));

        cap111.add(cap1111);
        cap11.add(cap111);
        cap1.add(cap11);
        noapteBuna.addContent(cap1);

        //Checking if it stays 'Capitolul 1.1.1' in the book
        cap111=new Section("Capitol 2.2.2");

        noapteBuna.print();

        cap111.print();
        //It stayed 'Capitolul 1.1.1' in the book, proving that the cloning was successful
        //Outside the book it now is 'Capitolul 2.2.2'
    }
    }

