package com.kim.dao;

import com.kim.Account;
import com.kim.ConnectionFactory;
import com.kim.Customer;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

import static com.kim.AccountOperations.bankAccountValidate;
import static com.kim.Menus.customerMenu;

public class AccountDaoImp implements AccountDao {

    private static Statement statement = null;
    Connection connection = null;

    public AccountDaoImp() {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public void newAccount(Account account) throws SQLException {
        Scanner s = new Scanner(System.in);
        String sqlA = "Insert into account (accountNumber, balance, accountpin, userid) values (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sqlA);

        ps.setInt(1, account.getAccountNumber());
        ps.setBigDecimal(2, account.getBalance());
        ps.setInt(3, account.getAccountPin());
        ps.setInt(4, account.getUserId());
        //ps.setString(5, account.getStatus());


        int count = ps.executeUpdate();
        if (count > 0)
            System.out.println("Your new banking account has been successfully created.");
        else
            System.out.println("Sorry, an unexpected error has occurred.");
        bankAccountValidate();


    }

    @Override
    public void deposit() {

    }

    @Override
    public void withdraw() {

    }

    @Override
    public void transfer() {

    }

    @Override
    public double viewBalance() {
        return 0;
    }

    @Override
    public Account bankAccountLogin(int accountNumber, int accountPin, String status) throws SQLException {

        Account account = new Account();
        Scanner sc = new Scanner(System.in);

        String validation = "select accountnumber, accountpin, status from bank.account where accountnumber = ? AND accountpin = ? AND status = ?";
        PreparedStatement statement = connection.prepareStatement(validation);
        statement.setInt(1, accountNumber);
        statement.setInt(2, accountPin);
        statement.setString(3, status);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {

            //if (resultSet != null) {

            int an = resultSet.getInt(1);
            //pw = resultSet.getString(2);
            String approveStat = resultSet.getString(3);
            //BigDecimal bal = resultSet.getBigDecimal(2);


            System.out.println("Login success!");
            String query = "select * from account where accountnumber = " + an;
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {

                int accountNum = rs.getInt(1);
                BigDecimal bal = rs.getBigDecimal(2);
                System.out.println("Your balance is " + bal);
            }
        }
        return account;
    }






    @Override
    public void approveAccount(int accountnumber, String status) throws SQLException {

        //String update = "select status from bank.account where accountNumber = ? ";
        //PreparedStatement statement = connection.prepareStatement(update);
        // ResultSet resultSet = statement.executeQuery();
        // if(resultSet.next()) {
        Scanner sc = new Scanner(System.in);
        int accountNumber = sc.nextInt();

        try {
            String sql = "update account set status = ? where accountNumber = ?";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setString(1, status);
        p.setInt(2, accountNumber);
        int count = p.executeUpdate();
        if (count > 0)
        System.out.println("Account updated. ");
        //System.out.println("Returning to employee portal.");
    }
        catch (SQLException e)
    {
            e.printStackTrace();
            System.out.println("Error: account not updated");


        }

    }


    public void depositFunds(Customer customer) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Please enter account number of the account for deposit:");
            int an = sc.nextInt();
            System.out.println("enter amount to deposit");
            BigDecimal depo = sc.nextBigDecimal();

            String sql = "update account set balance = balance + ? where accountNumber = ?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setBigDecimal(1,depo);
            p.setInt(2, an);
            int count = p.executeUpdate();
            if (count > 0)
                System.out.println("Deposit success. ");
            bankAccountValidate();
            //System.out.println("Returning to employee portal.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: account not updated");
        }

    }
}