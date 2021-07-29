package com.jong;
//3 ways to create a string in java
public class Demo1 {
    public static void main(String[] args) {
        String s1 = "Hello"; //create string using java string literal
        char ch[] = {'H', 'e', 'l', 'l', 'o' };

        String s2 = new String(ch); //convert char array to string
        String s3 = new String("World"); //create java string using new keyword

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
