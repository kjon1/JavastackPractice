package com.jong.d7;

class Employee{
    String name;
    public <T> Employee(T name){
        this.name = name.toString();
    }
}


public class Demo6 {
    public static void main(String[] args) {
        Employee e1= new Employee("Benja");
        Employee e2 = new Employee(456);
    }
}
