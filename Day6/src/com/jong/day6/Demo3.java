package com.jong.day6;


import java.util.ArrayList;
import java.util.Collections;

class Employee implements Comparable<Employee>{
    public int id;
    public String name;
    public int age;


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee o) {
        if(age > o.age)
            return 1;
        else if (age<o.age)
            return -1;
        else
        return 0;
    }
}
public class Demo3 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(34, "Moomoo", 5));
        employees.add(new Employee(33, "Lulu", 7));
        employees.add(new Employee(25, "Fleek", 108));
        System.out.println("before sorting...");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        Collections.sort(employees);
        Collections.reverse(employees);
        System.out.println("after sorting...");
        for (Employee employee : employees) {
            System.out.println(employee);
        }


    }


    }


