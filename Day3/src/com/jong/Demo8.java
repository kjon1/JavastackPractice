package com.jong;

public class Demo8 {
    public static void main(String[] args) {
        String msg = "welcome to hell";
        System.out.println(msg.substring(0, 4));

        System.out.println("original message: "+ msg);
        System.out.println("Substring starting from index 4: "+ msg.substring(4));
        System.out.println("Substring starting from index 0 to 4: "+ msg.substring(0,4));

        String str = new String("WELCOME stupid");
        System.out.println(str);
        System.out.println(str.substring(6));
    }

}
