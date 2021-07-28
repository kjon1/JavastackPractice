package com.jong;

class Employee{
    public int empId;
    public String firstName;
    public String lastName;
    public String email;

    public void getFullName(){
        System.out.println(this.firstName + " "+this.lastName  );
    }
}

class FullTimeEmployee extends Employee {
    public int annualSalary;
}
class PartTimeEmployee extends Employee{
    public int hourlySalary;

}


public class Demo22 {
    public static void main(String[] args) {
        FullTimeEmployee fte = new FullTimeEmployee();
        fte.firstName = "Baba";
        fte.lastName = "Yaga";

        PartTimeEmployee pte = new PartTimeEmployee();
        pte.firstName = "Lala";
        pte.lastName = "Looloo";

        Employee e = new Employee();

    }

}
