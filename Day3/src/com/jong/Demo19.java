package com.jong;

class EmployeeException extends RuntimeException{

}

public class Demo19 {
    public static void main(String[] args) {
        //throw new arithmeticexception
        throw new EmployeeException();
    }
}
