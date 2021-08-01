package com.jong;

public class Demo9 {
    public static void main(String[] args) {
        String str = "Hello";
        String str2 = "Stupid";
        String str3 = "Hellostupid";

        String str4 = str + str2;

        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str3.equals(str4));
        System.out.println(str3 == str4);

    }
}
