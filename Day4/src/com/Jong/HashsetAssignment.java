package com.Jong;


import java.util.HashSet;
import java.util.Iterator;

public class HashsetAssignment {
    public static void main(String[] args) {

        HashSet<String> hs = new HashSet<>();
        hs.add("Buddy");
        hs.add("Caldron");
        hs.add("Decker");
        hs.add("Fox");

        System.out.println(hs);

        hs.add("Snoopy");
        System.out.println(hs);

        Iterator<String> iterator = hs.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        hs.size();
        System.out.println(hs.size());

        hs.clear();
        System.out.println(hs);






    }
}
