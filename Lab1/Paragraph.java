package com.company;

public class Paragraph implements Element {
    private String name;

    public Paragraph(String name) {
    this.name=name;
    }

    public void print() {
        System.out.println("Paragraph :"+name);
    }
}
