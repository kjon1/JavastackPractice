package com.Jong;

import java.util.ArrayList;
import java.util.Collections;

public class Assign6789 {
    public static void main(String[] args) {
        ArrayList<String> flavors = new ArrayList<>();

        flavors.add("Chocolate");
        flavors.add("Vanilla Bean");
        flavors.add("Strawberry");
        flavors.add("Oreo");
        flavors.add("Moose");

        //prints out the arrayList
        //System.out.println(flavors);

        //assign6 remove third element from arraylist
        //flavorList.remove(2);
        //System.out.println(flavors);

        //assign7 search an element in arraylist
        /*for(String element : flavors){
            if(element.contains("Bean")){
                System.out.println("Search results: " + element);
            }   */

            //assign8 sort arraylist
            System.out.println("Before sort...");
            for(String flavor: flavors ){
                System.out.println(flavor);
            }
            System.out.println("After sorting...");
            Collections.sort(flavors);
            for (String flavor: flavors){
                System.out.println(flavor);
            }
            //assign9 copy arraylist to new
        System.out.println("copying to new arraylist");

            ArrayList<String> newFlavors = new ArrayList<>(flavors);
        System.out.println(newFlavors);
        }



    }

