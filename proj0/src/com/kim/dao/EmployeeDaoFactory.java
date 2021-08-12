package com.kim.dao;

public class EmployeeDaoFactory {

    public static EmployeeDao dao;
    private EmployeeDaoFactory(){}
    public static EmployeeDao getEmployeeDao(){
        if(dao==null)
            dao = new EmployeeDaoImp();
        return dao;
    }
}
