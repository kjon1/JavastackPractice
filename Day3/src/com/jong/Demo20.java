package com.jong;

import java.sql.SQLOutput;

class InsufficientFundsException extends Exception{
    public InsufficientFundsException(){
        System.out.println("Insufficient amount requested.");
    }
    public InsufficientFundsException(String message){
        System.out.println(message);
    }
}

class BankAccount{
    private int balance =0;
    private int accountNumber;

    public BankAccount(int accountNumber){
        this.accountNumber = accountNumber;
    }
    public void deposit(int amount){
        balance += amount;
        System.out.println("amount deposited: "+ amount);
    }
    public void withdraw(int amount) throws InsufficientFundsException{
        if(amount <= balance) {
            balance -= amount;
            System.out.println("amount debited: " + amount);
        }else {
            throw new InsufficientFundsException("you dont have that much money");
        }
    }
    public int getBalance(){
        return balance;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
}

public class Demo20 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5555);
        System.out.println(account.getBalance());
        account.deposit(500);
        try{
            account.withdraw(100);
        }catch (InsufficientFundsException e){
            e.printStackTrace();
        }
        account.deposit(300);
        try{
            account.withdraw(600);
        }catch (InsufficientFundsException e){


        }

    }
}
