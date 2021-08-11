package com.kim;

import com.kim.dao.*;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

import static com.kim.Menus.customerMenu;
import static com.kim.Menus.initialMenu;
import static com.kim.dao.CustomerDaoFactory.cDao;

public class AccountOperations {

    private static Account customer;

    public static void newBankAccount() throws SQLException {

        Scanner sc = new Scanner(System.in);
        AccountDao aDao = AccountDaoFactory.getAccountDao();
        System.out.println("--------New Banking Account Registration--------");
        System.out.println();
        System.out.println("Please enter your account number:");
        while (!sc.hasNextInt()) {
            System.out.println();
            System.out.println("Invalid input type, try again");
            sc.next();
        }
        int accountnumber = sc.nextInt();
        System.out.println();
        System.out.println("Please choose the amount you wish to deposit:");
        System.out.println(" Note: your starting balance must be greater than or equal to $100.");
        while (!sc.hasNextInt()) {
            System.out.println();
            System.out.println("Invalid input type, try again:");
            sc.nextLine();
        }
        BigDecimal startbalance = sc.nextBigDecimal();
        BigDecimal minbalance = BigDecimal.valueOf(100.00);

        while (startbalance.compareTo(minbalance) < 0) {
            System.out.println("Sorry, your account starting balance must be greater than or equal to $ 100.00");
            System.out.println();
            System.out.println("Please choose the amount you wish to deposit:");
            startbalance = sc.nextBigDecimal();
        }

        System.out.println();
        System.out.println("Please choose an account pin:");
        while (!sc.hasNextInt()) {
            System.out.println();
            System.out.println("Invalid input type, try again");
            sc.next();
        }
        int accountpin = sc.nextInt();
        System.out.println("Please enter your User ID. This will be the same as your Customer ID:");
        int uid = sc.nextInt();
        System.out.println("Thank you. One moment please while we process your request...." + "....");
        System.out.println();
        Account account = new Account();
        account.setAccountNumber(accountnumber);
        account.setBalance(startbalance);
        account.setAccountPin(accountpin);
        account.setUserId(uid);
        //account.setStatus();
        aDao.newAccount(account);
        System.out.println();
        System.out.println("Account registration completed. It may take up to 72 hours for your new banking account to be approved.");
        //System.out.println("Your customer ID is: " + inputCid + "." + "Your customer account password is:" + inputPw);
        System.out.println("Press \"Enter\" to return to Customer Portal and login with your new credentials.");
        Scanner enterkey = new Scanner(System.in);
        enterkey.nextLine();

        customerMenu();


    }


    public static void bankAccountValidate() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Account account = new Account();
        AccountDao aDao = AccountDaoFactory.getAccountDao();
        System.out.print("Please enter Account Number: ");
        while (!sc.hasNextInt()) {
            System.out.println();
            System.out.println("Invalid input type, try again");
            sc.next();
        }
        int an = sc.nextInt();
        System.out.println("Please enter Account PIN:");
        while (!sc.hasNextInt()) {
            System.out.println();
            System.out.println("Invalid input type, try again");
            sc.next();
        }
        int pin = sc.nextInt();
        String stat = "APPROVED";
        account = aDao.bankAccountLogin(an, pin, stat);
        if (account != null) {

            System.out.println("     5IVE STAR BANKING SERVICES");
            System.out.println("             * * * * * ");
            System.out.println(" What would you like to do today?");
            System.out.println();
            System.out.println("1. View balance.");
            System.out.println("2. Make a deposit.");
            System.out.println("3. Make a withdrawal.");
            System.out.println("4. Transfer funds.");
            System.out.println("5. Logout");
            int input = sc.nextInt();
            EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
            switch (input) {
                case 1://account = new Account();
                    dao.viewBalance(account);
                    break;


                case 2:
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "blam");

                    System.out.println("Please enter account number of the account for deposit:");
                    while (!sc.hasNextInt()) {
                        System.out.println();
                        System.out.println("Invalid input type, try again:");
                        sc.next();
                    }
                    an = sc.nextInt();
                    System.out.println("enter amount to deposit");
                    System.out.println(" Note: minimum deposit amount is $ 100.00");
                    while (!sc.hasNextInt()) {
                        System.out.println();
                        System.out.println("Invalid input type, try again:");
                        sc.next();
                    }
                    BigDecimal depo = sc.nextBigDecimal();
                        BigDecimal minDeposit = BigDecimal.valueOf(100.00);
                        while (depo.compareTo(minDeposit) < 0) {
                            System.out.println("Sorry, minimum deposit amount is $100.");
                            System.out.println();
                            sc.next();
                        }
                        String sql = "update account set balance = balance + ? where accountNumber = ?";
                        PreparedStatement p = connection.prepareStatement(sql);
                        p.setBigDecimal(1, depo);
                        p.setInt(2, an);
                        int count = p.executeUpdate();
                        if (count > 0)
                            System.out.println("Deposit success." + "$" + depo + " was deposited to your account.");
                        connection.close();
                        bankAccountValidate();

                    }
            }
        }


        //System.out.println("Returning to employee portal.");


        //cDao = CustomerDaoFactory.getCustomerDao();

                    /*System.out.println("enter deposit amount");
                    System.out.println(" Note: minimum deposit amount is $ 20.00");
                    while (!sc.hasNextInt()) {
                        System.out.println();
                        System.out.println("Invalid input type, try again:");
                        sc.next();
                    }
                    BigDecimal depo = sc.nextBigDecimal();
                    BigDecimal minDeposit = BigDecimal.valueOf(100.00);

                    while (depo.compareTo(minDeposit) < 0) {
                        System.out.println("Sorry, minimum deposit amount is $100.");
                        System.out.println();
                        System.out.println("Please choose the amount you wish to deposit:");
                        depo = sc.nextBigDecimal();
                    }
                    //AccountDaoImp cDao = CustomerDaoFactory.cDao;*/
        //cDao.depositFunds(customer);


        //return account;


        // System.out.println("SUCCESSFULLY LOGGED ON TO ACCOUNT #" + an + "." );
            /*System.out.println(" BANKING ACCOUNT MENU");
            System.out.println("1. View balance.");
            System.out.println("2. Make a deposit.");
            System.out.println("3. Make a withdrawal.");
            System.out.println("4. Transfer funds.");
            System.out.println("5. Logout");
            int input = sc.nextInt();
            switch (input){
                case 1:
                    CustomerDao cDao = CustomerDaoFactory.getCustomerDao();
                    Customer customer = new Customer();

                    cDao.viewBalance(an);
                    System.out.println(bal);
                    break;
            }*/


        /*System.out.println("Sorry, user not found: ID or password is invalid.");
        System.out.println("If you recently signed up for an account, it may take");
        System.out.println("up to 48 hours to be approved.");
        System.out.println("");
        System.out.println();
        //  initialMenu();
        try {
            customerMenu();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/



        private static void bankAccountMenu () throws SQLException {
            CustomerDao cDao = CustomerDaoFactory.getCustomerDao();

            Scanner sc = new Scanner(System.in);

        }

        String accountStatus = null;
        int an = 0;
        String balance = null;
        //customer = new Customer();
        //cDao.viewBalance(customer);


        private static void checkStatus () {

        }

        public static void approveBankAccount () throws SQLException {
            EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
            String accountStatus = null;
            //int an = 0;
            Account account = new Account(accountStatus);
            dao.accountApproval(account);
        }
    }




