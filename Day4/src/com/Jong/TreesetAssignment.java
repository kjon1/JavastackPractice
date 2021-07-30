package com.Jong;

import java.util.Collections;
//import java.util.List;
import java.util.TreeSet;

public class TreesetAssignment {
    public static void main(String[] args) {

        TreeSet<String> ts = new TreeSet<>();
        ts.add("White");
        ts.add("Platinum");
        ts.add("Turquoise");
        ts.add("Gold");

//print treeset
        System.out.println(ts);
//iterate through treeSet
        for(String name: ts){
            System.out.println(name);
        }

        //copy to new treeSet
        TreeSet<String>ts2 = new TreeSet<>(ts);
        System.out.println(ts2);

        //reverse treeSet

        //Collections.reverse((List<?>) ts2);
        //System.out.println(ts2);

        //get first and last elements in treeset ts
        System.out.println("Last element is: "+ ts.pollLast());
        System.out.println("First element is: "+ ts.pollFirst());
    }

}
