package com.vcc.mlbigdata.layer.infrastructure;

import com.vcc.mlbigdata.layer.application.domain.model.Account;

import java.sql.*;

public class ResponseRepository {

    static String DB_URL = "jdbc:mysql://localhost:3306/bankaccount";
    static String USER_NAME = "root";
    static String PASSWORD = "";

    public Account getAccountID(long accountID){
        String selectID = "select accountID from account where accountID = ?";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

            PreparedStatement pstmt = conn.prepareStatement(selectID);
            pstmt.setLong(1, accountID);
            pstmt.execute();

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Account acc = new Account();
                rs.getLong("accountID");
                acc.setAccountID(accountID);
                System.out.println(rs.getLong(1));
                return acc;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
