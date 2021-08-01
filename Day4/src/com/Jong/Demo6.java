package com.Jong;

import java.util.ArrayList;

public class Demo6 {
    public static void main(String[] args) {

        ArrayList<String>names = new ArrayList<>();
        names.add("Turup");
        names.add("Makavic");
        names.add("Syrius");
        System.out.println(names);
        //get element on specified index
        System.out.println(names.get(1));

        //add the element on a specific index
        names.add(1, "Mula");
        System.out.println(names);

        //merge 2 lists
        ArrayList<String>newNames = new ArrayList<>();
        newNames.add("Babushka");
        newNames.add("Cinammon Bun");
        names.addAll(newNames);

        //add second list element to specified position
        names.addAll(0, newNames);

        System.out.println(names);

        //remove
        names.removeIf(name -> name.contains("Syrius"));
        System.out.println(names);

        //
    }
}
