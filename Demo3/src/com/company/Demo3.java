package com.company;

class Calculator{
    //nonstatic method
    public void addNumber(int num1, int num2){
        System.out.println(num1+num2);
    }
    //static method
    public static void subNumber(int num1, int num2){
        System.out.println(num1-num2 );
    }
}

public class Demo3 {

    public static void main(String[] args) {
	// write your code here
        Calculator cal = new Calculator();
        cal.addNumber(20,10);
    }
}
