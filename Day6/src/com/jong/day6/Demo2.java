package com.jong.day6;

import java.util.ArrayList;
import java.util.Collections;

public class Demo2 {
    public static void main(String[] args) {

        ArrayList<String> letters = new ArrayList<>();
        letters.add("b");
        letters.add("z");
        letters.add("a");

        System.out.println("before sort");
        for (String l:letters){
            System.out.println(l);
        }
        Collections.sort(letters);
        System.out.println("after sort:");
        for (String l:letters){
            System.out.println(l);
        }
    }
}
