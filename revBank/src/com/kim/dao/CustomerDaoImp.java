package com.kim.dao;

import com.kim.Account;
import com.kim.ConnectionFactory;
import com.kim.Customer;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

import static com.kim.Menus.customerMenu;

public class CustomerDaoImp implements CustomerDao {
    private static Statement statement = null;
    Connection connection = null;

    public CustomerDaoImp() throws SQLException {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void newCustomer(Customer customer) throws SQLException {
        Scanner s = new Scanner(System.in);
        String sql = "Insert into customer (cId, pw, firstName, lastName) values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, customer.getCId());
        preparedStatement.setString(2, customer.getPw());
        preparedStatement.setString(3, customer.getFirstName());
        preparedStatement.setString(4, customer.getLastName());


        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("Thank you, your customer account has been successfully created.");
        else
            System.out.println("Sorry, an unexpected error has occurred.");


    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {

    }


    @Override
    public Customer getCustomerById(int cid, String pw) throws SQLException {
        Customer customer = new Customer();

        String validateSql = "select cid, pw from bank.customer where cid = ? AND pw = ? ";
        PreparedStatement statement = connection.prepareStatement(validateSql);
        statement.setInt(1, cid);
        statement.setString(2, pw);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {

            //if (resultSet != null) {

            //cid = resultSet.getInt(1);
            //pw = resultSet.getString(2);
            //firstName = resultSet.getString(3);

            System.out.println();
            System.out.println("Login success! Welcome back, valued customer.");
            System.out.println("We are happy to see you again.");
            //+ employee.getRole());
            customerMenu();
            return customer;


        } else {
            return null;
        }
    }

    @Override
    public void viewBalance() throws SQLException {
        //Account account = new Account();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter account number");
        int an = sc.nextInt();
        String sql = "select * from account where accountnumber = ?";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            BigDecimal bal = (rs.getBigDecimal(2));
            System.out.println("Your account balance is: " + bal);
        }
    }

    @Override
    public void depositFunds(Account account) throws SQLException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account number for deposit");
        int an = sc.nextInt();
        System.out.println("enter deposit amount");
        System.out.println(" Note: minimum deposit amount is $ 100.00");
        BigDecimal depo = null;
        while (!sc.hasNextInt()) {
            System.out.println();
            System.out.println("Invalid input type, try again:");
            sc.next();
            depo = sc.nextBigDecimal();
            BigDecimal minDeposit = BigDecimal.valueOf(100.00);

            while (depo.compareTo(minDeposit) < 0) {
                System.out.println("Sorry, minimum deposit amount is $100.");
                System.out.println();
                System.out.println("Please choose the amount you wish to deposit:");
                sc.next();
            }
            depo = sc.nextBigDecimal();
        }

        String depositFund = " update account set balance = balance+ ? where accountnumber = ?";
        PreparedStatement st1 = connection.prepareStatement(depositFund);
        st1.setBigDecimal(1, depo);
        st1.setInt(2, an);
        int count = st1.executeUpdate();
        if (count > 0) {
            System.out.println("You successfully deposited " + "$ " + depo + "to your account.");


        } else {
            System.out.println("account not found");
            customerMenu();
        }
    }



            @Override
            public void viewBalance (Account account){

            }

        }

