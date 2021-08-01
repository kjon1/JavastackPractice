package com.jong;

class Customer{
    public void display(){
        System.out.println("display...");
    }
}

public class Demo26 {
    public static void main(String[] args) {
        String str = "Maven";
        System.out.println(str.length());

        String str2 = null;
        try {
            System.out.println(str2.length());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        Customer c = new Customer();
        c.display();

        Customer c2 = null;
        c2.display();

    }
}
