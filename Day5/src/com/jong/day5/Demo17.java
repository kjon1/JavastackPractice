package com.jong.day5;

import java.io.File;
import java.io.IOException;

public class Demo17 {
    public static void main(String[] args) {
        File blowfish = new File("db");
        blowfish.mkdir();
        File megafish = new File("db", "superman.txt");
        try {
            megafish.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
