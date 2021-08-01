package com.Jong;

import java.util.ArrayList;

public class Demo4 {
    public static void main(String[] args) {

        ArrayList<String>   names = new ArrayList<>();
        names.add("Ava");
        names.add("Moomoo");
        names.add("Calyphon");
        names.add("Dedra");

        //System.out.println(names.size());

        for (int i=0; i<names.size(); i++){
            System.out.println(names.get(i));
        }
        //foreach (we usually use foreach not iterator u noobs)
        names.forEach(name ->{
            System.out.println(name);
        });
    }
}
