package com.jong;

interface IBankAccount{
    boolean deposit(double amount);
    boolean withdraw(double amount);
    void getBalance();

}

class SavingAccount implements IBankAccount {
    private double _balance;
    private double _dailyLimit;

    @Override
    public boolean deposit(double amount) {
        _balance += amount;
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        if (_balance < amount) {
            System.out.println("you dont have that much money");
            return false;
        } else if (_dailyLimit + amount > 1000) {
            System.out.println("you cant take out that much today");
            return false;
        } else {
            _balance -= amount;
            _dailyLimit += amount;
            System.out.println("successfully withdrawed: " + amount);
            return true;
        }
    }

    @Override
    public void getBalance() {
        System.out.println("saving account balance" + _balance);
    }
}
class CurrentAccount implements IBankAccount{
    private double _balance;

    @Override
    public boolean deposit(double amount) {
        _balance += amount;
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        if(_balance < amount){
            System.out.println("insufficient balance");
            return false;
        }else{
            _balance -= amount;
            System.out.println("successfully withdrew: "+ amount);
            return true;
        }
    }

    @Override
    public void getBalance() {
        System.out.println("Current Account balance" + _balance);
    }
}


    public class Demo20 {
        public static void main(String[] args) {
            IBankAccount savingAccount = new SavingAccount();
            IBankAccount currentAccount = new CurrentAccount();

            savingAccount.deposit(2000);
            savingAccount.withdraw(1000);
            savingAccount.getBalance();

            currentAccount.deposit(5000);
            currentAccount.withdraw(6000);
            currentAccount.withdraw(2000);
            currentAccount.getBalance();
            }

        }

