package com.jong.day6;

import java.util.ArrayList;
import java.util.Collections;

public class Demo1 {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(44);
        numbers.add(12);
        numbers.add(3);
        numbers.add(100);
        System.out.println("before sort");

        for (int n: numbers){
            System.out.println(n);}

        Collections.sort(numbers);
        System.out.println("after sort:");
        for (int n:numbers){
            System.out.println(n);
        }

    }
}
