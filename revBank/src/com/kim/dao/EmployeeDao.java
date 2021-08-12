package com.kim.dao;

import com.kim.Account;
import com.kim.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {


    //void viewBalance(double balance);


     Employee getEmployeeById(int id, int pin) throws SQLException;



     Employee validateEmp(int id, int pin) throws SQLException;



    void addEmployee(Employee employee) throws SQLException;

    void accountApproval(Account account) throws SQLException;

    void viewCustomerAccounts();  //return accountnumber, balance, based on userid which equals cid











        List<Employee> getEmployees();

    void getAccounts(int cid, Account account) throws SQLException;

    void getAccounts(int cid) throws SQLException;

    void depositFunds(Account account);

    void viewBalance(int account) throws SQLException;

}
