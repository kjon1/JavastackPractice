package com.Jong;

import java.util.ArrayList;
import java.util.Iterator;

public class Assign123 {
    public static void main(String[] args) {
        ArrayList<String> flavors = new ArrayList<>();

        flavors.add("White Chocolate Mint Fairy");
        flavors.add("Vanilla Bean");
        flavors.add("Orange Peach Fuzz Mango");
        flavors.add("Oreo Butter Pecan Nut Monster");
        flavors.add("Goobilicous Caramel Swirl Explosion");
        flavors.add("Nitro Polar Express AKA Klondike Magnum");

        //prints out the arrayList
        //System.out.println(flavors);

        /*Iterator iterator = flavors.iterator();
        // hasNext() will check if iterator has the element
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }   */
        System.out.println(flavors);
        //insert element at arraylist first position
        //flavors.add(0,"Super Caramel Crunch");
        //System.out.println(flavors);
    }
}
