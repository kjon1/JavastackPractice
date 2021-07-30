package com.Jong;

import java.util.HashSet;
import java.util.Iterator;

public class Demo9 {
    public static void main(String[] args) {
        //create hashset and add elements
        HashSet<String> set = new HashSet<>();
        set.add("Flo");
        set.add("Myra");
        set.add("Glook");
        set.add(null);

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        set.remove("Glook");
        System.out.println(set);
        // removeAll()
        // removeIf()
        // clear()

    }
}
