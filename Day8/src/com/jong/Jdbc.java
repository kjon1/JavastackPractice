package com.jong;

import java.sql.*;

public class Jdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Class.forName("jdbc:mysql://localhost:3306/biglittlebank");

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/biglittlebank", "root", "blam");
        Statement stmt = c.createStatement();

        ResultSet rs = stmt.executeQuery("select * from customer");
        while (rs.next()) {
            System.out.println("id: " + rs.getInt(1) + ", Name:" + rs.getString(2) +
                    ", Password: " + rs.getString(3));
        }
        c.close();
    }

    }

