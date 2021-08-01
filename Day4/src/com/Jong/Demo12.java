package com.Jong;

import sun.reflect.generics.tree.Tree;
import java.sql.SQLOutput;

import java.util.TreeSet;

public class Demo12 {
    public static void main(String[] args) {

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(1);
        ts.add(2);
        ts.add(3);
        ts.add(412);
        ts.add(5);
        for (int number: ts){
            System.out.println(number);
        }
        System.out.println("Lowest: "+ ts.pollFirst());
        System.out.println("Highest: "+ ts.pollLast());
    }
}
