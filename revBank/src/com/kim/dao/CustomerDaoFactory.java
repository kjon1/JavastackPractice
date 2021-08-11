package com.kim.dao;

import java.sql.SQLException;

public class CustomerDaoFactory {

    public static CustomerDao cDao;
    private CustomerDaoFactory(){}
    public static CustomerDao getCustomerDao() throws SQLException {
        if(cDao==null)
            cDao = new CustomerDaoImp();
        return cDao;
    }
}
