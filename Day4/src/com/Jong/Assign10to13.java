package com.Jong;

import java.util.ArrayList;
import java.util.Collections;

public class Assign10to13 {
    public static void main(String[] args) {
        ArrayList<String> flavors = new ArrayList<>();

        flavors.add("Chocolate");
        flavors.add("Vanilla Bean");
        flavors.add("Strawberry");
        flavors.add("Oreo");
        flavors.add("Moose");

        //prints out the arrayList
        System.out.println(flavors);

        //assign 10 shuffle array list
        //Collections.shuffle(flavors);
        //System.out.println(flavors);

        // #11 reverse elements in arraylist
        //Collections.reverse(flavors);
       // System.out.println(flavors);

       // #12 extract a portion of arraylist
       // for (int i=2; i<5; i++){
        //    System.out.println(flavors.get(i));
       // }


//  #13 swap 2 elements in array list
        Collections.swap(flavors, 0, 4);
        System.out.println(flavors);



    }
}
