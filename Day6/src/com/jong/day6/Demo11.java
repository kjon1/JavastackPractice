package com.jong.day6;
interface MultipleStatement{
    String print(String message);
}

public class Demo11 {
    public static void main(String[] args) {
        MultipleStatement multipleStatement = (message) -> {
            String s1 = "statement 1, ";
            String s2 = "statement 2, ";
            String s3 = "statment 3, ";
            return s1 + s2 + s3;
        };
        System.out.println(multipleStatement.print("hi"));
        }
    }

