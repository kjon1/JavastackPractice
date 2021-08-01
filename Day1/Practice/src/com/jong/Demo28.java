package com.jong;

class Parent1{
    public void display(){
        System.out.println("display parent");
    }
}

class Child1 extends Parent1{
    public void display(){
        System.out.println("child display");
    }
}

public class Demo28 {
    public static void main(String[] args) {
        Child1 c1 = new Child1();
        c1.display();

        Parent1 p1 = new Parent1();
        p1.display();
    }
}
