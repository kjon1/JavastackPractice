package com.Jong;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo1 {
    public static void main(String[] args) {
        ArrayList<String> mList = new ArrayList<String>();

        mList.add("Nancy");
        mList.add("Shoot");
        mList.add("Maka");

        //System.out.println(mList);

        Iterator iterator = mList.iterator();
        //hasNext() will check if iterator has the element
        while (iterator.hasNext()){
            System.out.println(iterator.next()); //print element and move cursor to next
        }
        for (String name: mList){
            System.out.println(name);
        }

    }
}
