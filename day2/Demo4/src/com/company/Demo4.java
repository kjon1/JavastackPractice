package com.company;

class Employee{
    public int empId;
    public String name;
    public static String companyName = "Revature";

    public Employee(int empId, String name){
        this.empId = empId;
        this.name = name;
    }
    public void printInfo(){
        System.out.println("Id: "+ empId+ ", Name: "+ name+ ", Company Name: "+ companyName);
    }
}

public class Demo4 {

    public static void main(String[] args) {
	// write your code here
        Employee emp1 = new Employee(1, "Mooloo");
        emp1.printInfo();
        Employee.companyName = "AAA";
        emp1.printInfo();
    }
}
