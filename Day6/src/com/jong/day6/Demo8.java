package com.jong.day6;


class SavingsAccount implements IBank{

    @Override
    public void deposit(int amount) {
        System.out.println("deposit:" + amount);
    }

    @Override
    public void withdraw(int amount) {
        System.out.println("withdraw:  " + amount);

    }
}

class CheckingAccount implements IBank{

    @Override
    public void deposit(int amount) {
        System.out.println("you deposited" + amount);

    }

    @Override
    public void withdraw(int amount) {
        System.out.println("you withdrew: "+ amount);

    }
}

class Factory{
    public static IBank getAccount(AccountType id){
        switch (id){
            case SAVINGS_ACCOUNT:
                return new SavingsAccount();
            case CHECKING_ACCOUNT:
                return new CheckingAccount();
            default:
                return null;
        }
    }
}
public class Demo8 {
    public static void main(String[] args) {
        //SavingsAccount s= new SavingsAccount();

        IBank s= Factory.getAccount(AccountType.SAVINGS_ACCOUNT);
        s.deposit(300);
        s.deposit(100);
        System.out.println(s);
        s.withdraw(220);
        System.out.println(s);

    }
}
