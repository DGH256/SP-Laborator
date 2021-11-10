package models;

public class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void print() {
        System.out.println(this.name);
    }
}
