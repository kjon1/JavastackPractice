package com.jong;

interface ICustomer{

}
class User{

}
class Customer implements ICustomer{

}

public class Demo26 {
    public static void main(String[] args) {
        Customer customer = new Customer();
        ICustomer iCustomer = new Customer();
    }
}
