package com.jong;

class Calculator{
    int a =10;
    int b=20;

    public Calculator(){
        System.out.println("parameter less constructor");
    }
    public Calculator(int x, int y){
        this.a = x;
        this.b = y;
    }
    public void addNumbers(){
        System.out.println(a+b);
    }
}

public class Demo20 {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.addNumbers();

        Calculator calc2 = new Calculator();
        calc2.addNumbers();
    }

}
