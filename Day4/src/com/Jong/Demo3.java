package com.Jong;

import java.util.ArrayList;
import java.util.Collections;

public class Demo3 {
    public static void main(String[] args) {

        ArrayList<String> flavors = new ArrayList<>();
        flavors.add("Lemon");
        flavors.add("Apple");
        flavors.add("MangoPeachPotato");

        //before sort
        System.out.println("before sort...");
        for (String flavor : flavors) {
            System.out.println(flavor);
        }
        //after sort
        System.out.println("after sort");
        Collections.sort(flavors);
        for (String flavor : flavors) {
            System.out.println(flavor);
        }
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(89);
        numbers.add(22);
        numbers.add(1);
        numbers.add(50);
        numbers.add(6);

        // before sort
        System.out.println("before sorting...");
        for (int number : numbers) {
            System.out.println(number);
        }

        // after sort
        Collections.sort(numbers);
        System.out.println("after sorting...");
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
