package com.kim;

import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;

public class Demo1234 {
    //private static Object ResultSet;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");

        String host = "jdbc:mysql://localhost:3306/";
        String database = "biglittlebank";
        String connectionString = host + database;
        String username = "root";
        String password = "blam";

        Connection conn = DriverManager.getConnection(connectionString, username, password);

        Statement statement = conn.createStatement();

        //String query = "create table employee (id INTEGER PRIMARY KEY AUTO_INCREMENT, name CHAR(20), password CHAR(12))";
        //statement.executeUpdate(query);
        //System.out.println("table created successfully");;

        //String query = "insert into employee (name, password) values (?, ?)";

        //PreparedStatement preparedStatement = conn.prepareStatement(query);

        //preparedStatement.setString(1, "flo");
        //preparedStatement.setString(2, "blank");

        //int rowAffected = preparedStatement.executeUpdate();
        //System.out.println("("+rowAffected+") rows affected");

  //      String query = "update employee set name = ?, password = ? where id = ?";
    //    PreparedStatement preparedStatement = conn.prepareStatement(query);
      //  preparedStatement.setString(1, "flux");
        //preparedStatement.setString(2, "bloonk");
    //    preparedStatement.setInt(3, 1);
    //    int rowAffected = preparedStatement.executeUpdate();
    //    System.out.println("("+rowAffected+") rows affected");

        //        String query = "delete from employee where id = ?";
//        PreparedStatement preparedStatement = conn.prepareStatement(query);
//        preparedStatement.setInt(1, 1);
//        int rowAffected = preparedStatement.executeUpdate();
//        System.out.println("(" + rowAffected + ") rows affected");
//        int rowAffected = 1;
//        System.out.println(String.format("(%d) rows affected", rowAffected));
        
        String query22 = "select * from employee";
        ResultSet resultSet = statement.executeQuery(query22 );

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String pw = resultSet.getString(3);
            System.out.println("Id = "+ id+ ", Name: "  +name+", pw: "+ password);
        }
        conn.close();

        if (conn.isClosed()) {
            System.out.println("connection closed");
        } else {
            System.out.println("connection open");
        }




    }
}
