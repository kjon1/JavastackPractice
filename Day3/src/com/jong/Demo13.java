package com.jong;

public class Demo13 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());
        sb.append("Hello");
        System.out.println(sb.capacity());
        sb.append("welcome to java class, have a nice da");
        System.out.println(sb.capacity());
    }
}
