package com.jong;

public class Demo18 {
    public static void main(String[] args) {


            int a =20;

        int b=10;
        int c=0;

        try{
            c =a/b;
        }
        catch (ArithmeticException exception){
            System.out.println(exception.getMessage());
        }
        catch (Exception exception){

        }
        System.out.println(c);
    }
}
