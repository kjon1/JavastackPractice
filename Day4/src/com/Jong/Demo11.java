package com.Jong;

import java.util.TreeSet;

public class Demo11 {

    public static void main(String[] args) {
        TreeSet<String> t = new TreeSet<>();
        t.add("Floop");
        t.add("Hoonter");
        t.add("Kaka");
        t.add("Ronaldo");

        for (String name: t){
            System.out.println(name);
        }
    }

}
