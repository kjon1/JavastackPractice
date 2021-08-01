package com.jong;

public class Demo4 {
    public static void main(String[] args) {
        String s1 = "Bob";
        String s2 = "Bob";
        String s3 = new String("Bob");

        System.out.println(s1 == s2); //true both refer to same instance
        System.out.println(s1 == s3);  //false because s3 is instance created in normal heap
    }
}
