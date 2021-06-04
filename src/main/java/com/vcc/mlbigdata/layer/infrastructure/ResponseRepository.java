package com.vcc.mlbigdata.layer.infrastructure;

import com.vcc.mlbigdata.layer.application.domain.model.Account;

import java.sql.*;

public class ResponseRepository {

    static String DB_URL = "jdbc:mysql://localhost:3306/bankaccount";
    static String USER_NAME = "root";
    static String PASSWORD = "";

    public Account getAccountID(long accountID){
        String selectID = "select * from account where accountID = ?";
        Account account = new Account();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

            PreparedStatement pstmt = conn.prepareStatement(selectID);
            pstmt.setLong(1, getAccountID());
            pstmt.execute();

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Account acc = new Account();
                rs.getLong("accountID");
                acc.setAccountID(accountID);
                System.out.println(rs.getLong(1));
                pstmt.close();
                return acc;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Account insertOne(long accountID, String accountName, double availableBalances) {
        String insertOne = "insert into ACCOUNT values (\"?\",\"?\",?)";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(insertOne);
            pstmt.setLong(1,accountID);
            pstmt.setString(2,accountName);
            pstmt.setDouble(3, availableBalances);
            pstmt.execute();

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Account acc = new Account();
                rs.getLong("accountID");
                rs.getString("accountName");
                rs.getDouble("availableBalances");
                acc.setAccountID(accountID);
                acc.setAccountName(accountName);
                acc.setAvailableBalances(availableBalances);
                System.out.println(rs.getLong(1) +"\t"+ rs.getString(2) +"\t"+ rs.getDouble(3));
                pstmt.close();
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
