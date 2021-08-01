package com.Jong;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Assign4to5 {
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


//assign4 retrieve elemtn of specified index from arrayList
        //System.out.println(flavors.get(4));

        //assign5 update specific array element by given element
       flavors.removeIf(flavor -> flavor.contains("Nut"));

        System.out.println(flavors);

        flavors.remove("Vanilla Bean");
        System.out.println(flavors);


    }


}