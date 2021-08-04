package com.jong.day6;
import javax.swing.*;

interface Square{
    void draw();

}

public class Demo9 {
    public static void main(String[] args) {


        Square square = () -> {
            System.out.println("drawing...");};

        square.draw();
    }
}
