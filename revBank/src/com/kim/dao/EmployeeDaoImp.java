package com.kim.dao;

//import com.kim.ConnectionFactory;
import com.kim.Account;
import com.kim.ConnectionFactory;
import com.kim.Employee;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.kim.AccountOperations.bankAccountValidate;
import static com.kim.Menus.customerMenu;
import static com.kim.Menus.eMenu;

public class EmployeeDaoImp implements EmployeeDao {

    private static Statement statement = null;
    Connection connection = null;
    private int pin;
    private Account Accounts;

    public EmployeeDaoImp() {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    //@Override
    //public void viewBalance(double balance) {

    //}

    @Override
    public Employee getEmployeeById(int id, int pin) throws SQLException {
        Employee employee = new Employee();

        String validate = "select id, pin from bank.employee where id = ? AND pin = ? ";
        PreparedStatement statement = connection.prepareStatement(validate);
        statement.setInt(1, id);
        statement.setInt(2, pin);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {

            //if (resultSet != null) {
            // int eid = resultSet.getInt(1);
            //  int epin = resultSet.getInt(2);
            // String role = resultSet.getString(3);

            // employee = new Employee(id, pin);
            System.out.println("Successfully logged in! Welcome Employee.");
            //+ employee.getRole());
            eMenu();
            return employee;


        } else {
            return null;
        }
    }


    @Override
    public Employee validateEmp(int id, int pin) throws SQLException {

        try {
            String sql = "select employeeId,employeePin from employee where employeeId=? and employeePin=? ";
            Statement statement = connection.createStatement();
            //statement.setInt(1, employeeId);
            //statement.setInt(2, employeePin);
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();


            id = resultSet.getInt(1);
            pin = resultSet.getInt(2);
            String role = resultSet.getString(3);
            Employee employee = new Employee(id, pin, role);

            if (resultSet != null)
                System.out.println("welcome employee");
            eMenu();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return null;

    }


    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "Insert into employee (id, pin, role) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, employee.getId());
        preparedStatement.setInt(2, employee.getPin());
        preparedStatement.setString(3, employee.getRole());

        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("Employee saved. ");
        else
            System.out.println("Oops, an error occurred");

    }

    @Override
    public void accountApproval(Account account) throws SQLException {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter account to approve or reject:");
            int an = sc.nextInt();
            String s = "select * from account where accountnumber = " + an;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(s);
            if (rs.next()) {
                System.out.println("Choose new status APPROVED or REJECTED");
                String accountStatus = sc.next();
                String sql = "update account set status = ? where accountNumber = ?";
                PreparedStatement p = connection.prepareStatement(sql);
                String status;
                p.setString(1, accountStatus);
                p.setInt(2, an);
                int count = p.executeUpdate();
                if (count > 0)
                    System.out.println("Account updated. ");
            } else {
                System.out.println("Error: account not found.");
                eMenu();
            }
            System.out.println();

            eMenu();

        } catch (SQLException e) {
            e.printStackTrace();


        }

    }


    @Override
    public void viewCustomerAccounts() {

    }


    @Override
    public List<Employee> getEmployees() {
        return null;
    }

    @Override
    public void getAccounts(int cid, Account account) throws SQLException {

    }

    @Override
    public void getAccounts(int cid) throws SQLException {

        List<String> itemList = new ArrayList<String>();
        try {
            String sql = "select * from account where userid = " + cid;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                do {
                    System.out.println("          Accounts List");
                    String cuAccounts = "Account #: " + rs.getString(1) +
                            "    Balance: $ " +
                            rs.getString(2) +
                            "    Approval Status: " +
                            rs.getString(5);
                    itemList.add(cuAccounts);
                    System.out.println("...................................................................");
                    System.out.println(cuAccounts);
                } while (rs.next());
            } else {
                System.out.println("No accounts found for that customer.");
                System.out.println("Returning to employee menu.");
                eMenu();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void depositFunds(Account account) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Please enter account number of the account for deposit:");
            int an = sc.nextInt();
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

                String sql = "update account set balance = balance + ? where accountNumber = ?";
                PreparedStatement p = connection.prepareStatement(sql);
                p.setBigDecimal(1, depo);
                p.setInt(2, an);
                int count = p.executeUpdate();
                if (count > 0)
                    System.out.println("Deposit success." + "$" + depo + " was deposited to your account.");
                bankAccountValidate();
                //System.out.println("Returning to employee portal.");

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error: account not updated");
        }

    }

    @Override
    public void viewBalance(int an) throws SQLException {
        Scanner s = new Scanner(System.in);
       // System.out.println("Enter account to check");
       // int accnum = s.nextInt();
        String sql = "select * from account where accountnumber = " + an;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        if (rs.next()) {
            System.out.println("Your Account Summary...");
            System.out.println("-------------------------------");
            System.out.println("Account No:  " + rs.getInt("accountnumber"));
            System.out.println("Account Balance: " + "$ " + rs.getString(2));
            System.out.println();
            System.out.println();
            System.out.println("Press \"Enter\" to return to your banking services page.");
            Scanner enterkey = new Scanner(System.in);
            enterkey.nextLine();


        }else{
            System.out.println("sorry, a strange error occurred.");
            customerMenu();
        }

    }
    }










