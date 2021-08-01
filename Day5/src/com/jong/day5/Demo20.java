package com.jong.day5;

import java.io.File;

public class Demo20 {
    public static void main(String[] args) {
        File fatman= new File("db", "superfatman.txt");
        fatman.delete();
        System.out.println(fatman.exists());
    }
}
