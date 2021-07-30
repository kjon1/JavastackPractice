package com.Jong;

import java.util.ArrayList;

public class Demo2 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Apache");
        names.add("Baba");
        names.add("Cockerel");

        //get
        System.out.println(names.get(1));
        //set
        names.set(2, "Champagne");
        for (String name: names){
            System.out.println(name);
        }
    }
}
