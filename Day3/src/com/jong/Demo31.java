package com.jong;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class Demo31 {
    public static void main(String[] args) {
        //try block to check for exception
        try (FileOutputStream f = new FileOutputStream())  //create an object of fileoutputstream
        {
            String data = "Hello stupid"; //custom string input
            byte[] arr = data.getBytes();   //convert string to bytes
            stream.write(arr);    //text written in file
        } catch (Exception e) {  //catch block to handle exception
            System.out.println(e.getMessage());
        }
        System.out.println("resources are closed so byebye");
    }
}
