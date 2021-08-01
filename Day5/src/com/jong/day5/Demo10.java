package com.jong.day5;

class Bank{
    int balance = 4500;

    synchronized void withdraw(int amount){
        System.out.println("withdraw processing...ples wait");
        if (balance < amount){
            System.out.println("balance insufficient, waiting for deposit...go sit down");
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance -= amount;
        System.out.println("withdraw complete now dont go spend it all stupid");
    }
    synchronized void deposit(int amount){
        System.out.println("deposit processing...");
        balance+= amount;
        System.out.println("deposit complete!!Thank you for the deposit, next time deposit more");
        notify();
    }
}

class DepositThread extends Thread{
    Bank bank;
    public DepositThread(Bank bank){
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.deposit(7000);
    }
}
class WithdrawThread extends Thread{
    Bank bank;
    public WithdrawThread(Bank bank){
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.withdraw(9999);
    }
}
public class Demo10 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        DepositThread depositThread = new DepositThread(bank);
        WithdrawThread withdrawThread = new WithdrawThread(bank);

        withdrawThread.start();
        depositThread.start();
    }
}
