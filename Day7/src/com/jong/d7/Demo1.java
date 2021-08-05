package com.jong.d7;

class Calculator{
    //
    public boolean areEqual(Object a, Object b){
    if (a.equals(b))
    return true;
    else
    return false;
    }
}

public class Demo1 {
    public static void main(String[] args) {
        Calculator c= new Calculator();
        boolean result = c.areEqual("A", 10);
        if (result)
            System.out.println("number are equal");
        else
            System.out.println("not qual");
    }
}
