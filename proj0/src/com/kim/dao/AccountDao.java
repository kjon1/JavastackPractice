package com.kim.dao;

import com.kim.Account;

import java.math.BigDecimal;
import java.sql.SQLException;

public interface AccountDao {

    void newAccount(Account account) throws SQLException;
    void deposit();
     void withdraw();
     void transfer();
     double viewBalance();
     Account bankAccountLogin(int accountNumber, int accountPin, String status) throws SQLException;

     //employee functions



 //update to approved where accountnumber =

    void approveAccount(int accountnumber, String status) throws SQLException;

    void depositFund(BigDecimal depo, int an) throws SQLException;

    void withdrawFund(BigDecimal withdraw, int an) throws SQLException;


    //also, when logging into bank account it will first check accounstatus
    //if accountstatus = pending, sout(pending approval) custmenu()
    //else allow transaction to proceed



}










