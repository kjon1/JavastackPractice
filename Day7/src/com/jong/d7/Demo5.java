package com.jong.d7;

class GenericMethodDemo{

    public static <E> void printArray(E[] elements){
        for(E element: elements){
            System.out.println(element);
        }
        System.out.println("******");
    }

}

public class Demo5 {
    public static void main(String[] args) {
        Integer[] intArray = { 100,200,300,400 };
        Character[] charArray = { 'A', 'B', 'C', 'D' };

        GenericMethodDemo.printArray(intArray);
        GenericMethodDemo.printArray(charArray);

    }
}
