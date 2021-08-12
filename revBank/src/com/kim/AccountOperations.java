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
        System.out.println("Press \"Enter\" to return to Customer Portal.");
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
        //if (account != null) {
        boolean run = true;
        while(run){
            System.out.println();
            System.out.println("---------------------------------");
            System.out.println("   5ive Star Banking Services");
            System.out.println("          * * * * * ");
            System.out.println();
            System.out.println(" What would you like to do today?");
            System.out.println();
            System.out.println("   1. View balance.");
            System.out.println("   2. Make a deposit.");
            System.out.println("   3. Make a withdrawal.");
            System.out.println("   4. Transfer funds.");
            System.out.println("   5. Logout");
            System.out.println("______________________________");
            int input = sc.nextInt();
            EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
            switch (input) {
                case 1://account = new Account();
                    dao.viewBalance(an);
                    break;

                    case 2:
                    System.out.println("Please enter the amount you wish to deposit:");
                    while (!sc.hasNextInt()) {
                        System.out.println();
                        System.out.println("Invalid input type, try again:");
                        sc.next();
                    }
                    BigDecimal depo = sc.nextBigDecimal();
                    BigDecimal minDeposit = BigDecimal.valueOf(00.00);
                    while (depo.compareTo(minDeposit) < 0) {
                        System.out.println("Sorry, deposit amount must be greater than $0.");
                        System.out.println("Enter deposit amount: ");
                        depo = sc.nextBigDecimal();
                    }
                    aDao.depositFund(depo, an);    //send deposit amount and target account to aDao
                    break;

                case 3:
                    System.out.println("Please enter the amount you wish to withdraw:");
                    while (!sc.hasNextInt()) {
                        System.out.println();
                        System.out.println("Invalid input type, try again:");
                        sc.next();
                    }
                    BigDecimal withdraw = sc.nextBigDecimal();
                    BigDecimal negativeBlocker = BigDecimal.valueOf(0.50);
                    while (withdraw.compareTo(negativeBlocker) < 0) {
                        System.out.println("Sorry, the minimum withdrawal amount is $0.50");
                        System.out.println("Please enter withdrawal amount: ");
                        withdraw = sc.nextBigDecimal();
                    }
                    aDao.withdrawFund(withdraw, an); //send withdraw amount and target account to
                    break;
                case 4:
                    System.out.println("Enter amount you wish to transfer:");
                    BigDecimal transfer = sc.nextBigDecimal();
                    BigDecimal minTransfer = BigDecimal.valueOf(1000.00);
                    while (transfer.compareTo(minTransfer) < 0) {
                        System.out.println("Sorry, minimum transfer amount is $ 1,000.00");
                        System.out.println("Please enter transfer amount: ");
                        transfer = sc.nextBigDecimal();
                    }
                    System.out.println("Please enter the account number of the account you would like to transfer to:");
                    int target = sc.nextInt();
                    




                case 5:
                    System.out.println("Goodbye!");
                    run = false;
                    customerMenu();
                    break;

                    default:
                        System.out.println("Invalid choice, please choose an option from the menu");

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




