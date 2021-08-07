package com.kim;

import java.sql.SQLException;

public class EmployeeDaoFactory {

    private static EmployeeDao dao;
    private EmployeeDaoFactory(){}

    public static EmployeeDao getEmployeeDao() throws SQLException {
        if(dao==null)
            dao = new EmployeeDaoImp();
        return dao;
    }
}
