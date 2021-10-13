package com.company;

public class Table implements Element {
    private String name;

    public Table(String name) {
        this.name=name;
    }

    public void print() {
        System.out.println("Table :"+name);
    }
}
