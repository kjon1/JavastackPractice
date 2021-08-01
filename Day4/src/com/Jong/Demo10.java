package com.Jong;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Demo10 {
    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();
        set.add("Alpha");
        set.add("Bravo");
        set.add("Charlie");
        set.add("Doodoo");
        set.add("Enema");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        LinkedHashSet<String> set2 = new LinkedHashSet<>();
        set2.add("Alpha");
        set2.add("Bravo");
        set2.add("Charlie");
        set2.add("Doodoo");
        set2.add("Enema");

        Iterator<String> iterator2 = set2.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }

}
