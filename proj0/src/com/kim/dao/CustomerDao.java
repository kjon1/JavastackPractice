package com.kim.dao;

import com.kim.Account;
import com.kim.Customer;

import java.math.BigDecimal;
import java.sql.SQLException;

public interface CustomerDao {

    void newCustomer(Customer customer) throws SQLException; //mvp
    void updateCustomer(Customer customer) throws SQLException;
    Customer getCustomerById(int id, String pw) throws SQLException; //cust login= mvp

    void viewBalance() throws SQLException;
    void depositFunds(Account account) throws SQLException;


    void viewBalance(Account account);

    void postTransfer(BigDecimal transferAmount, int target, int an) throws SQLException;

    void processTransfer(int an) throws SQLException;

    void userLogin(String username, String pw) throws SQLException;
}
