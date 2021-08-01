package com.jong.day5;

import java.io.File;

public class Demo18 {
    public static void main(String[] args) {
        int count =0;
        File f = new File("db");
        String[] list = f.list();
        for (String s: list){
            count++;
            System.out.println(s);
        }

        System.out.println("total num of file and folder is "+ count);
    }
}
