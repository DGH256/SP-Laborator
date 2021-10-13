package com.company;

import java.util.ArrayList;

public class Element {

    private ArrayList<Element> elements = new ArrayList<>();

    private Element parent = null;

    private String title;

    //Are we allowed to have the same chapter in multiple sections? Or the same image in multipe sections?;
    private boolean allowSharingElements = false;

    //We use this in the 'print' function to see if something is a Paragraph or Section or other type of Element;
    private String getElementType()
    {
        String elementType =  (this).getClass().getName();

        //ElementType is something like 'com.company.Element', i want it to be only 'Element';
        return elementType.substring( elementType.lastIndexOf('.') +1);

    }

    //We will overload this to add things like the Author list of the book;
    public String printExtraInfo(){
        return "";
    }

    private void print(int consoleIndentLevel)
    {
        boolean hasSubelements=false;

        // Indent so it looks nice when we print to console;
        for(int i=0;i<consoleIndentLevel;i++)
        {
            System.out.print("  ");
        }

        System.out.print( getElementType() +" with title: \""+this.title+"\"" + printExtraInfo() );

        //Printing the sub-elements now;
        if(this.elements.size()>0)
        {
            System.out.print( " and sub-elements: " );
            System.out.println(); hasSubelements=true;

            for(Element el : elements)
            {
                el.print(consoleIndentLevel+1);
            }
        }

        if(hasSubelements==false) {
            System.out.println();
        }
    }


    public void add(Element element)
    {
        //If sharing elements is not allowed and the book/section/chapter already has this element;
        if(this.allowSharingElements==false && this.find(element) ==true )
        {
            throw new UnsupportedOperationException("Can't add element, it already exists in the collection.");
        }

        this.elements.add(element);

        //This will be useful in the 'find' method where we have to go UP the hierarchy;
        element.parent=this;
    }


    public void remove(Element element)
    {
        this.elements.remove(element);
    }

    public Element get(int index)
    {
        if(index<elements.size())
        {
            return elements.get(index);
        }
        else throw new IndexOutOfBoundsException();
    }

    public boolean find(Element el)
    {
        boolean foundUP=findUP(el);

        //No need to look down the hierarchy if we found it already
        if(foundUP)
        {
            return true;
        }

        boolean foundDOWN=findDOWN(el);

        return foundDOWN;

    }

    private boolean findUP(Element el)
    {
        if(this.equals(el)) {return true;}

        for(Element element: this.elements)
            if(element.equals(el))
            {
                return true;
            }

        if(this.parent!=null) {
            //If we got here it means we didn't find the element and we need to go one level higher up the hierarchy
            return this.parent.findUP(el);
        }
        else
        {
            //We reached the top of the hierarchy and didn't find the element
            return false;
        }
    }

    private boolean findDOWN(Element el)
    {
        if(this.equals(el)) {return true;}

        boolean found =false;

        for(Element childElement : elements)
        {
            found = childElement.findDOWN(el);

            if(found==true)
            {
                break;
            }
        }

        return found;
    }

    @Override public boolean equals(Object o) {
       if(this.getClass().getName() == o.getClass().getName())
       {
           if(this.title == ((Element)o).title)
               return true;
       }
       return false;
    }

    public void print()
    {
        this.print(0);
    }

    public void setTitle(String title)
    {
        this.title=title;
    }

}
