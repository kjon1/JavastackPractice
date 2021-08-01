package com.jong;

public class Demo2 {
    public static void main(String[] args) {
        String str = "hello";
        str.concat("stupid");
        System.out.println(str);

        String str1 = "hello";
        str1 = str.concat(" stupid");
        System.out.println(str1);
    }
}
