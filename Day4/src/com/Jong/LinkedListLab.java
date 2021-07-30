package com.Jong;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;


public class LinkedListLab {
    public static void main(String[] args) {
        java.util.LinkedList<String> names = new java.util.LinkedList<>();
        names.add("Micah");
        names.add("Sloop");
        names.add("Wolf");

        System.out.println(names);

        names.addLast("Boofan");
        System.out.println(names);


        // Iterator<String> iterator = names.iterator();
        //while (iterator.hasNext()) {
        //    System.out.println(iterator.next());
        //}

        //for(int i=names.size() +1; i>0;i++){
       //     System.out.println(names.get(i));

        //reverse order
        Iterator iterator = names.descendingIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //add to specific index in linkedlist
        names.add(0, "Markus");
        System.out.println(names);




    }


}
