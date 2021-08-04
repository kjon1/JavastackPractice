package com.jong.day6;

import java.util.concurrent.Callable;

class Calculator {

    public static int count = 0;

    // instance of the class
    private static Calculator instance = null;

    Calculator() {
        count++;
        System.out.println("Count: " + count);
        System.out.println("Constructor called");
    }

    public static Calculator getInstance() {
        if (instance == null)
            instance = new Calculator();
        return instance;
    }
}

public class Demo5 {
    public static void main(String[] args) {
        Calculator c1= Calculator.getInstance();
        Calculator c2 = Calculator.getInstance();

        //Calculator cc = new Calculator();
        Calculator cd = new Calculator();
    }
}
