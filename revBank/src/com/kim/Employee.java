package com.kim;

public class Employee {

    int id;
    int pin;
    String role;

    public Employee() {
    }


    public Employee(int id, int pin, String role) {
        this.id = id;
        this.pin = pin;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", pin=" + pin +
                ", role='" + role + '\'' +
                '}';
    }
}



