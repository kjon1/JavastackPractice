package com.jong.day5;

import java.io.File;

public class Demo16 {
    public static void main(String[] args) {
        File f = new File("db");
        System.out.println(f.exists());
        f.mkdir();
    }
}
