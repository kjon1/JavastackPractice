package com.Jong;

import java.util.Iterator;
import java.util.LinkedList;

public class Demo7 {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Smarty");
        names.add("Decker");
        names.add("Walrus");

        Iterator<String>   iterator = names.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
