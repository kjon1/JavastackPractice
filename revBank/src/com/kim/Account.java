package com.kim;

import java.math.BigDecimal;

public class Account {
    int accountNumber;
    BigDecimal balance;
    int accountPin;
    int userId;
    String status;


    public Account(int accountNumber, BigDecimal balance, int accountPin, int userId, String status) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountPin = accountPin;
        this.userId = userId;
        this.status = status;
    }

    public Account() {

    }

    public Account(int accountNumber, String status) {
    }

    public Account(String status) {
    }

    public Account(int accountNumber, BigDecimal bal, String status) {
    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getAccountPin() {
        return accountPin;
    }

    public void setAccountPin(int accountPin) {
        this.accountPin = accountPin;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", accountPin=" + accountPin +
                ", userId=" + userId +
                ", status='" + status + '\'' +
                '}';
    }
}
