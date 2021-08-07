package com.kim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class EmployeeDaoImp implements EmployeeDao{

    Scanner sc = new Scanner(System.in);

    private static Statement statement = null;

    Connection connection = null;
    private String Id;
    private String Password;

    public EmployeeDaoImp() {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        System.out.println("enter employee id");
        Id = sc.next();
        System.out.println("enter employee pw");
        Password = sc.next();
        String sql = "insert into employee (id, password) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, employee.getId());
        preparedStatement.setString(2, "password");
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("employee updated");
        else
            System.out.println("Oops! something went wrong");
    }




    @Override
    public void updateEmployee(Employee employee) {

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
