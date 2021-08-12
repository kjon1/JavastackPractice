package com.kim.dao;

import com.kim.Account;
import com.kim.ConnectionFactory;
import com.kim.Customer;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;
import java.time.LocalDate;

import static com.kim.Menus.custLogin;
import static com.kim.Menus.customerMenu;

public class CustomerDaoImp implements CustomerDao {
    private static Statement statement = null;
    Connection connection = null;

    LocalDate date = LocalDate.now();


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

            System.out.println("Login success.");
            String sql = "select * from customer where cid = " + cid;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                //cid = resultSet.getInt(1);
                String fName = (rs.getString(3));
                System.out.println("       * * * * *");
                System.out.println("Hello, " + fName + ".");

                customerMenu();
                return null;
            }

        } else {
            System.out.println("Login failed: CID or password not found or does not match.");
            custLogin();
        }

        return null;

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
    public void viewBalance(Account account) {

    }

    @Override
    public void postTransfer(BigDecimal transferAmount, int target, int an) throws SQLException {

        String check = "select * from account where accountnumber = " + target; //check if target exists
        Statement s = connection.createStatement();
        ResultSet rs1 = s.executeQuery(check);
        if (rs1.next()) {

            String bal = "select * from account where accountnumber = " + an;
            Statement s2 = connection.createStatement();
            ResultSet rs2 = s2.executeQuery(bal);
            if (rs2.next()) {
                double balA = rs2.getDouble("balance");
                BigDecimal balance = BigDecimal.valueOf(balA);

                if (transferAmount.compareTo(balance) < 0) {
                    String sql = "update account set balance = balance - ? where accountNumber = ?";
                    PreparedStatement p = connection.prepareStatement(sql);
                    p.setBigDecimal(1, transferAmount);
                    p.setInt(2, an);
                    int count = p.executeUpdate();
                    if (count > 0)
                        System.out.println("$ " + transferAmount + " has been withdrawn from your account");
                    System.out.println("Money transfer is in progress pending approval from the receiver.");

                    String pending = "insert into transfers (poster, getter, amount) values (?, ?, ?)";

                    PreparedStatement ps1 = connection.prepareStatement(pending);
                    ps1.setInt(1, an);
                    ps1.setInt(2, target);
                    ps1.setBigDecimal(3, transferAmount);
                    ps1.executeUpdate();

                    String pstimex = "Insert into transactions (account, amount, type, date) values (?, ?, ?, ?)";
                    PreparedStatement pstime = connection.prepareStatement(pstimex);
                    pstime.setInt(1, an);
                    pstime.setBigDecimal(2, transferAmount);
                    pstime.setString(3, "Transfer Out");
                    pstime.setDate(4, Date.valueOf(date));
                    pstime.executeUpdate();


                } else {
                    System.out.println("your account balance is insufficient to cover this transfer. transfer cancelled.");
                }

            }

        } else {
            System.out.println("Transfer failed. Target account does not exist.");


        }
    }

    @Override
    public void processTransfer(int an) throws SQLException {
        Scanner sc = new Scanner(System.in);

        String scan = "select * from transfers where getter = " + an;
        Statement s1 = connection.createStatement();
        ResultSet rs1 = s1.executeQuery(scan);
        if (rs1.next()) {

            String get = "select * from transfers where getter = " + an;
            Statement s2 = connection.createStatement();
            ResultSet rs2 = s2.executeQuery(get);
            if (rs2.next()) {
                int sender = rs2.getInt(1);
                double balA = rs2.getDouble("amount");
                BigDecimal amt = BigDecimal.valueOf(balA);
                System.out.println("You have a pending transfer of " + "$" + amt + "  from account " + sender + ":");
                System.out.println("Would you like to accept the transfer? Y / N :");
                String reply = sc.next();
                String y = "y";
                if (reply.equals(y)) {

                    String getit = "update account set balance = balance + ? where accountNumber = ?";
                    PreparedStatement pox = connection.prepareStatement(getit);
                    pox.setBigDecimal(1, amt);
                    pox.setInt(2, an);
                    int count = pox.executeUpdate();
                    if (count > 0)
                        System.out.println("Success!" + "$ " + amt + " has been posted to your account.");
                    String pstimex = "Insert into transactions (account, amount, type, date) values (?, ?, ?, ?)";
                    PreparedStatement pstime = connection.prepareStatement(pstimex);
                    pstime.setInt(1, an);
                    pstime.setBigDecimal(2, amt);
                    pstime.setString(3, "Transfer In");
                    pstime.setDate(4, Date.valueOf(date));
                    pstime.executeUpdate();
                    String s = "select * from account where accountnumber = " + an;
                    Statement statement = connection.createStatement();
                    ResultSet rsx = statement.executeQuery(s);
                    if (rsx.next()) {
                        BigDecimal balx = (rsx.getBigDecimal(2));
                        System.out.println("Your new account balance is: " + balx);
                        System.out.println();
                        System.out.println("Press \"Enter\" to continue.");
                        Scanner enterkey = new Scanner(System.in);
                        enterkey.nextLine();
                    }

                } else {
                    System.out.println("You declined the transfer.");
                    String sql = "update account set balance = balance + ? where accountNumber = ?";
                    PreparedStatement p = connection.prepareStatement(sql);
                    p.setBigDecimal(1, amt);
                    p.setInt(2, sender);
                    int count = p.executeUpdate();

                    System.out.println("You have declined the transfer." + "$ " + amt + " is being returned to the origin account " + sender);
                    String pstimex = "Insert into transactions (account, amount, type, date) values (?, ?, ?, ?)";
                    PreparedStatement pstime = connection.prepareStatement(pstimex);
                    pstime.setInt(1, an);
                    pstime.setBigDecimal(2, amt);
                    pstime.setString(3, "Transfer Rejected");
                    pstime.setDate(4, Date.valueOf(date));
                    pstime.executeUpdate();

                }


            } else {

            }

        } else {
            System.out.println("No pending transfers.");
        }
    }

    @Override
    public void userLogin(String username, String pw) throws SQLException {
        Customer customer = new Customer();
        String query = "select from user where usertype = ? AND password = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, pw);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {

            System.out.println("Login success.");

        }

    }
}



