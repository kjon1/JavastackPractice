package com.Jong;

import java.util.PriorityQueue;

public class Demo13 {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();
        q.add("Cat");
        q.add("Bull");
        q.add("Lamb");
        q.add("Ram");

        for (String name: q){
            System.out.println(name);
        }
        System.out.println("head:"+ q.element());
        System.out.println("head:"+ q.peek());
        System.out.println(q.remove());
        System.out.println(q.poll());


        System.out.println("*****************");
        for(String name: q){
            System.out.println(name);
        }
    }
}
