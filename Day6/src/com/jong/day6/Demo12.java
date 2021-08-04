package com.jong.day6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

class Customer{
    public int id;
    public String name;
    public int age;

    public Customer(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Demo12 {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer(2, "maluk", 2));
        customers.add(new Customer(1, "MAMALUK", 40));
        System.out.println("before sorting");
        for (Customer customer: customers){
            System.out.println(customer);
        }
        Collections.sort(customers, (c1, c2) -> {
            return c1.name.compareTo(c2.name);
        });
        System.out.println("after sort.." );
        for (Customer customer: customers){
            System.out.println(customer);
        }
    }
}
