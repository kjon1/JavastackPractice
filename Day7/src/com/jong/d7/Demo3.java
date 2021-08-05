package com.jong.d7;

class Calculator2<T>{
    public boolean areEqual(T a, T b){
        if (a.equals(b))
            return true;
        else
            return false;
    }

}

public class Demo3 {
    public static void main(String[] args) {
        Calculator2<String> calc = new Calculator2<>()  ;
        calc.areEqual("a", "b");

        Calculator2<Integer> calc2 = new Calculator2<>()    ;
        calc2.areEqual(10, 11);

    }
}
