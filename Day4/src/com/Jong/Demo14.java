package com.Jong;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo14 {
    public static void main(String[] args) {
        Deque<String> d = new ArrayDeque<>();
        d.add("Mo");
        d.add("Sy");
        d.add("Amortid");

        for (String name: d){
            System.out.println(name);
        }
    }
}
