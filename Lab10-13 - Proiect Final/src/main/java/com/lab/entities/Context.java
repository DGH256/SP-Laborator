package com.lab.entities;

public class Context {
    private int stringLength;

    public Context(int length)
    {
        this.stringLength=length;
    }

    public int length()
    {
        return this.stringLength;
    }
}
