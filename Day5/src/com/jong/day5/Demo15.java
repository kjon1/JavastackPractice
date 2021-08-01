package com.jong.day5;

import java.io.File;
import java.io.IOException;

public class Demo15 {
    public static void main(String[] args) {
        File f = new File("data.txt");
        System.out.println(f.exists());
        try {
            f.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(f.exists());
    }
}
