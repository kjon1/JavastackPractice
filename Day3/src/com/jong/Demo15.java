package com.jong;

import java.sql.SQLOutput;

public class Demo15 {
    public static void main(String[] args) {
        System.out.println("Performance test");
        long startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer("Hello");
        for(int i=0; i<88000; i++){
            stringBuffer.append("World");

        }
        System.out.println("stringbuffer time: "+ (System.currentTimeMillis()
         - startTime)+  " ms");
        System.out.println("*************************");

        startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder("HELLO");
        for(int i=0; i<88000; i++){
            stringBuilder.append(" world");
        }
        System.out.println("Time taken by StringBuilder: "+ (System.currentTimeMillis()- startTime)+ " ms");
    }
}
