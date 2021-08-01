package com.jong.day5;

import java.io.File;

public class Demo19 {
    public static void main(String[] args) {
        int count = 0;
        File f = new File("db");
        String[] list = f.list();
        for (String s: list){
            File blowfish = new File(f, s);
            if (blowfish.isFile()){
                count++;
                System.out.println(s);
            }
        }
    }
}
