package com.jong.day5;

import java.io.FileWriter;
import java.io.IOException;

public class Demo21 {
    public static void main(String[] args) throws IOException {
        //first check if the stupid already make a file same name
        //or create new file
        FileWriter fw = new FileWriter("data2.txt", true);
        fw.write(010101010101);
        fw.write(47474747);
        fw.write("shutup stupid goodbye have a nice day");
        fw.write("\n");;
        char[] c1 = {'a', 'b', 'c'};
        fw.write(c1);
        fw.write("\n");

        fw.flush();
        fw.close();

    }
}
