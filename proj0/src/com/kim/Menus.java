package com.kim;

import com.kim.dao.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.Executor;

import com.kim.ConnectionFactory;

import static com.kim.AccountOperations.*;
import static com.kim.dao.CustomerDaoFactory.cDao;
import static com.kim.dao.EmployeeDaoFactory.dao;

public class Menus {

    private static int Id;
    private static int Pin;


    public static void eMenu() throws SQLException {

        Scanner s = new Scanner(System.in);
        LocalDate localdate = LocalDate.now();
        boolean run = true;

        int eInput = 0;
        do {
            System.out.println("                  ");
            System.out.println(" 5IVE STAR BANK  * * * * *    ");
            System.out.println("-----------------------------------");
            System.out.println("         Employee Menu");
            System.out.println();
            System.out.println("1. Customer account approval");
            System.out.println("2. View accounts by customer");
            System.out.println("3. View transaction log");
            System.out.println("4. Add new employee");
            System.out.println("5. Logout and return to main menu");
            System.out.println();
            System.out.println();
            System.out.println("          * * * * *");

            eInput = s.nextInt();
            switch (eInput) {
                case 1:
                    approveBankAccount();
                    break;
                case 2:
                    System.out.println("Enter customer ID number:");
                    while (!s.hasNextInt()) {
                        System.out.println();
                        System.out.println();
                        s.next();
                    }
                    int cid = s.nextInt();
                    dao.getAccounts(cid);
                    eMenu();
                    break;

                case 3:
                    dao.getTransactions();
                    System.out.println();
                    System.out.println("Press \"Enter\" to continue.");
                    Scanner enterkey = new Scanner(System.in);
                    enterkey.nextLine();
                    break;

                case 4:
                    System.out.println("  ---New Employee Form---");
                    System.out.println("Enter employee ID:");
                    int empid = s.nextInt();
                    System.out.println("Choose a PIN: ");
                    int pin = s.nextInt();
                    System.out.println("Enter employee job title:");
                    String jobtitle = s.next();
                    Employee employee = new Employee();
                    dao.addEmployee(employee);
                    break;
                case 5:
                    System.out.println("Logging out of Bank Management Portal.");
                    System.out.println("Logged out.");
                    System.out.println("Returning to Main Menu. One moment....");
                    System.out.println();
                    run = false;
                    initialMenu();

                default:
                    System.out.println("Please select a valid entry.");
                    break;


            }
        }            while (run = true) ;

    }

        public static void custLogin() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer();
        CustomerDao cDao = CustomerDaoFactory.getCustomerDao();
         //   System.out.println("Welcome!");
        System.out.print("Please enter your CID: ");
        while (!sc.hasNextInt()) {
            System.out.println();
            System.out.println("Invalid input type, try again");
            sc.next();
        }
        int cid = sc.nextInt();
        System.out.println("Please enter your password:");
        String pw = sc.next();
        customer = cDao.getCustomerById(cid, pw);
        //if (customer != null) {
         //   System.out.println("");
         //   customerMenu();
        //} else {
            System.out.println("Sorry, user not found or ID and/or password does not match.");
            System.out.println("Returning to main screen....");
            System.out.println();
            //  initialMenu();
            custLogin();
        }
    //}
    //System.out.println("oops not functional yet");
    public static void newCustomer () throws SQLException {
            Scanner sc = new Scanner(System.in);
            CustomerDao cDao = CustomerDaoFactory.getCustomerDao();
            System.out.println(" 5SB");
            System.out.println("-------New Customer Registration Page--------");
            System.out.println("               * * * * * ");
            System.out.println();
            System.out.println("Please enter your SSN: it will act as your customer ID:");
            while (!sc.hasNextInt()) {
                System.out.println();
                System.out.println("Invalid input type, try again");
                sc.next();
            }
            int inputCid = sc.nextInt();
            System.out.println("");
            System.out.println();
            System.out.println("Please enter the new password for your account:");
            //System.out.println("For security purposes, it is recommended your password");
            //System.out.println("includes upper and lower case letters and a mix of numbers and letters.");
            String inputPw = sc.next();
            System.out.println("");
            System.out.println();
            System.out.println("Please enter your first name:");
            String inputFname = sc.next();
            System.out.println("Please enter your last name:");
            String inputLname = sc.next();
            System.out.println("One moment while we create your new customer account........");
            //System.out.println("Thank you" + "," + inputFname + );
            Customer customer = new Customer();
            customer.setCId(inputCid);
            customer.setPw(inputPw);
            customer.setFirstName(inputFname);
            customer.setLastName(inputLname);
            cDao.newCustomer(customer);
            System.out.println();
            //System.out.println("Your customer ID is: " + inputCid + "." + "Your customer account password is:" + inputPw);
            System.out.println("Thank you, " + inputFname + " for joining 5ive Star Bank.");
            System.out.println("Press \"Enter\" to proceed to Customer login page and login with your new credentials.");
            Scanner enterkey = new Scanner(System.in);
            enterkey.nextLine();

            custLogin();
        }

        public static void employeeLogin () throws SQLException {
            Scanner sc = new Scanner(System.in);
            Employee employee = new Employee();
            EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
            System.out.print("Enter Employee Id: ");
            while (!sc.hasNextInt()) {
                System.out.println();
                System.out.println("Invalid input type, try again");
                sc.next();
            }
            int id = sc.nextInt();
            System.out.println("Enter PIN:");
            while (!sc.hasNextInt()) {
                System.out.println();
                System.out.println("Invalid input type, try again");
                sc.next();
            }
            int pin = sc.nextInt();
            employee = dao.getEmployeeById(id, pin);
            if (employee != null) {
                System.out.println("...... ...... ........ .......");
                eMenu();
            } else {
                System.out.println("Sorry, user not found: ID or PIN is invalid.");
                //  initialMenu();
                employeeLogin();
            }

        }

        public static void aboutFrostBank () throws SQLException {
            System.out.println("                      About Us");
            System.out.println("5ive Star Bank is a premium but fictional bank founded in 2021 in order to demonstrate a model");
            System.out.println("of a basic bank program implementing Java and MySql database for Mr V's Java full stack batch. ");
            System.out.println("The program is continually evolving to become the ultimate solution for the");
            System.out.println("enterprising banking customer of tomorrow. ");
            System.out.println("Also the training program put together by the folks at Revature is very exciting and we learn something new");
            System.out.println("every single day.");
            System.out.println("");
            System.out.println("");
            System.out.println("     Press \"Enter\" to return to main menu.");
            Scanner enterkey = new Scanner(System.in);
            enterkey.nextLine();
            initialMenu();

        }
        public static void customerMenu () throws SQLException {
            Scanner s = new Scanner(System.in);
            boolean run = true;

            int input = 0;
            do {
                System.out.println("_________________________");
                System.out.println(" 5SB   ");
                System.out.println("  -----------------------");
                System.out.println("    Customer Portal");
                System.out.println("        * * * * *");
                System.out.println();
                System.out.println("1. Login to banking account");
                System.out.println("2. Apply for a new bank account.");

                System.out.println("0. Logout ");
                input = s.nextInt();


                switch (input) {
                    case 1:
                        bankAccountValidate();
                        break;
                    case 2:
                        newBankAccount();  //initialize
                        break;

                    case 3:
                        System.out.println("Enter origin account number.");
                        System.out.println("Enter destination account number:");
                        break;

                    case 4:
                        System.out.println("");
                        System.out.println();
                        break;
                    case 5:

                        break;

                    case 0:
                        System.out.println("You have successfully logged out.");

                        initialMenu();

                    default:
                        System.out.println("Invalid entry.");

                }
            } while (run);
        }

        public static void initialMenu () throws SQLException {
            Scanner sc = new Scanner(System.in);
            int in = 0;
            do {
                System.out.println("________________________________________________");
                System.out.println(" 5IVE STAR BANK           Banking for the Future");
                System.out.println("               * * * * *");
                System.out.println();
                System.out.println(" ------------- MAIN MENU---------------");
                System.out.println();
                System.out.println("        1. Existing Customer Login");
                System.out.println("        2. New Customer Registration");
                System.out.println("        3. Employee Login");
                System.out.println("        4. About");
                System.out.println("        5. Exit ");
                System.out.println();
                System.out.println("               * * * * *");
                System.out.println("2021 5ive Star Bank               Member FBIC ");
                System.out.println("______________________________________________");
                in = sc.nextInt();
                if (in < 1 || in > 5) {
                    System.out.println("Oops, invalid entry. ");
                }
            } while (in < 1 || in > 5);
            switch (in) {
                case 1:
                    custLogin();
                    break;
                case 2:
                    newCustomer();
                    break;
                case 3:
                    System.out.println("Loading Bank Management System...one moment");
                    employeeLogin();
                    break;
                case 4:
                    aboutFrostBank();
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Goodbye");

            }

        }


    public static void usermenu () throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("     Welcome to 5ive Star Bank ");
        System.out.println("             * * * * *      ");
        System.out.println();
        System.out.println("Hello, guest. Please enter username:");
        String username = scanner.next();
        System.out.println("Enter password:");
        String pw = scanner.next();
        //cDao.userLogin(username, pw);
        initialMenu();





    }

}







