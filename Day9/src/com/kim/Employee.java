package com.kim;

import java.sql.SQLException;
import java.util.List;

public class Employee implements EmployeeDao{

    private int id;
    private String password;

    public Employee() { //construct
    }


    public Employee(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public void addEmployee(Employee employee) throws SQLException {

    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {

    }

    @Override
    public List<Employee> getEmployees() {
        return null;
    }

    @Override
    public Employee employeeById(int id) {
        return null;
    }
}

