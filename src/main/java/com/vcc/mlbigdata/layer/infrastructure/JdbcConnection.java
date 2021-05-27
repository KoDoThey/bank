package com.vcc.mlbigdata.layer.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    public static Connection getJdbcConnection(){
        final String url = "jdbc:mysql://localhost:3306/bankAccount";
        final String user = "root";
        final String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load Driver
            return DriverManager.getConnection(url, user, password); //open connection
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}


