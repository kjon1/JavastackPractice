package com.jong.hashmap;

import java.util.*;

public class HashM {
    public static void main(String[] args) {

        Map hm = new HashMap<>();
        hm.put("Iphone", 1000);
        hm.put("Galaxy", 700);
        hm.put("Xperia", 500);
        hm.put("Nokia", 250);
        System.out.println(hm);

        //Set set = hm.entrySet();
        //Iterator i = set.iterator();

        //ASSOCIATE SPECIFIY KEY WITH NEW VALUE PAIR UPDATE

        hm.put("Iphone", 929);
        System.out.println(hm);

        //this method to get the number of key value pairs in hasmap hm  using hm.size();
        System.out.println(hm.size());

        //copy all mapping pairs to new hashmap
        HashMap<String, Integer> hm2 = new HashMap<>();
        hm2.putAll(hm);
        System.out.println(hm2);

    }


}
