package com.kim.dao;

public class AccountDaoFactory {

    public static AccountDao aDao;
    private AccountDaoFactory(){}
    public static AccountDao getAccountDao(){
        if(aDao==null)
            aDao = new AccountDaoImp();
        return aDao;
    }
}
