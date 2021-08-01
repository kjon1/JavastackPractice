package com.Jong;

import sun.awt.image.ImageWatched;

import java.sql.SQLOutput;
import java.util.LinkedList;

public class Demo8 {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Micah");
        names.add("Sloop");
        names.add("Wolf");
        System.out.println(names);

        //add element at specific position
        names.add(0, "Cat");

        //add second list
        LinkedList<String> namesNew = new LinkedList<>();
        namesNew.add("Barbie");
        namesNew.add("Ling ");

        names.addAll(0, namesNew);
        System.out.println(names);

        //addFirst
        names.addFirst("first");
        System.out.println(names);

        names.addLast("last");
        System.out.println(names);

        // remove()
        // remoteFirst()
        // removeLast()
        // removeFirstOccurrence()
        // removeLastOccurrence()

        //names.add("Wolf");
        //names.removeLastOccurrence("Wolf");

        //for (int i=names.size() -1; i>0; i--){
         //   System.out.println(names.get(i));
        //}

    }
}
