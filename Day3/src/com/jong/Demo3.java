package com.jong;

public class Demo3 {
    public static void main(String[] args) {

        String s1 = "fat";
        String s2 = "fat";
        String s3 = new String("Fat");
        String s4 = "booboo";

        System.out.println(s2); //true
        System.out.println(s3); //true
        System.out.println(s4);  //false

        String s5 = "FAT";
        System.out.println(s1.equals(s5)); //false
        System.out.println(s1.equalsIgnoreCase(s5)); //true , we ignored uppercase
    }
}
