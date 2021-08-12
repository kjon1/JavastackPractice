package com.kim.dao;

import com.kim.Account;
import com.kim.ConnectionFactory;
import com.kim.Customer;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

import static com.kim.AccountOperations.bankAccountValidate;
import static com.kim.Menus.customerMenu;

public class AccountDaoImp implements AccountDao {

    private static Statement statement = null;
    Connection connection = null;
    LocalDate date = LocalDate.now();


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
        int count = ps.executeUpdate();
        if (count > 0) {
            System.out.println("Your new banking account has been successfully created.");
            System.out.println();
            System.out.println("Press \"Enter\" to continue.");
            Scanner enterkey = new Scanner(System.in);
            enterkey.nextLine();

        } else {
            System.out.println("Sorry, an unexpected error has occurred.");
        }


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
            int an = resultSet.getInt(1);
            //pw = resultSet.getString(2);
            String approveStat = resultSet.getString(3);
            System.out.println("Login success!");
            String query = "select * from account where accountnumber = " + an;
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {

                int accountNum = rs.getInt(1);
                BigDecimal bal = rs.getBigDecimal(2);
                System.out.println("-----------------------------------");
                System.out.println("Logged into account No: " + an);
            }

        } else {
            System.out.println("Login failed: account number and/or PIN does not match.");
            System.out.println();
            System.out.println("Press \"Enter\" to continue.");
            Scanner enterkey = new Scanner(System.in);
            enterkey.nextLine();
            customerMenu();

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
            System.out.println();
            System.out.println("Press \"Enter\" to continue.");
            Scanner enterkey = new Scanner(System.in);
            enterkey.nextLine();
            //System.out.println("Returning to employee portal.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: account not updated");
            System.out.println();
            System.out.println("Press \"Enter\" to continue.");
            Scanner enterkey = new Scanner(System.in);
            enterkey.nextLine();


        }

    }

    @Override
    public void depositFund(BigDecimal depo, int an) throws SQLException {
        String sql = "update account set balance = balance + ? where accountNumber = ?";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setBigDecimal(1, depo);
        p.setInt(2, an);
        int count = p.executeUpdate();
        if (count > 0)


            System.out.println("Deposit success." + "$ " + depo + " was deposited to your account.");
        String s = "select * from account where accountnumber = " + an;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(s);
        if (rs.next()) {
            BigDecimal balA = (rs.getBigDecimal(2));
            System.out.println("Your new account balance is: " + balA);
            System.out.println();
            //INSERT INTO TRANSACTION
            String pstimex = "Insert into transactions (account, amount, type, date) values (?, ?, ?, ?)";
            PreparedStatement pstime = connection.prepareStatement(pstimex);
            pstime.setInt(1, an );
            pstime.setBigDecimal(2, depo);
            pstime.setString(3, "DEPOSIT");
            pstime.setDate(4, Date.valueOf(date));
            pstime.executeUpdate();
            System.out.println("Press \"Enter\" to continue.");
            Scanner enterkey = new Scanner(System.in);
            enterkey.nextLine();
        }

    }

    @Override
    public void withdrawFund(BigDecimal withdraw, int an) throws SQLException {
        String check = "select * from account where accountnumber = " + an;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(check);
        if (rs.next()) {
            double balA = (rs.getDouble(2));
            BigDecimal balance = BigDecimal.valueOf(balA);

            if (withdraw.compareTo(balance) < 0) {

                String sql = "update account set balance = balance - ? where accountNumber = ?";
                PreparedStatement p = connection.prepareStatement(sql);
                p.setBigDecimal(1, withdraw);
                p.setInt(2, an);
                int count = p.executeUpdate();
                if (count > 0)
                    System.out.println("Withdraw success." + "$ " + withdraw + " was withdrawn from your account.");
                String pstimex = "Insert into transactions (account, amount, type, date) values (?, ?, ?, ?)";
                PreparedStatement pstime = connection.prepareStatement(pstimex);
                pstime.setInt(1, an );
                pstime.setBigDecimal(2, withdraw);
                pstime.setString(3, "Withdrawal");
                pstime.setDate(4, Date.valueOf(date));
                pstime.executeUpdate();
                /*String s1 = "select * from account where accountnumber = " + an;
                Statement s = connection.createStatement();
                ResultSet rs2 = s.executeQuery(s1);
                if (rs2.next()) {

                    //double bal = (rs.getDouble(2));
                    BigDecimal bal1 = rs.getBigDecimal(2);
                    BigDecimal bal2 = bal1-withdraw;

                    //System.out.println("Your new account balance is: " + bal);
                    System.out.println("new balance " + bal1);*/


            } else {
                System.out.println("Sorry, your account does not have the necessary funds to cover the withdrawal.");
                System.out.println();
                System.out.println("Press \"Enter\" to return to banking services page.");
                Scanner enterkey = new Scanner(System.in);
                enterkey.nextLine();
            }
        }
    }
}


