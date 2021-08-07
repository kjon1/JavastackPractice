package com.kim;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee) throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;

    List<Employee> getEmployees();
    Employee employeeById(int id);



}

