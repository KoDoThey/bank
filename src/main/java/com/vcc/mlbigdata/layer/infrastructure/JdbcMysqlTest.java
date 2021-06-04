package com.vcc.mlbigdata.layer.infrastructure;

import com.vcc.mlbigdata.layer.application.domain.model.Account;

import java.sql.*;

public class JdbcMysqlTest {
    private static String DB_URL = "jdbc:mysql://localhost:3306/bankaccount";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";

    public Account insert(long accountID, String accountName, double availableBalances) {
        String sqlInsert = "INSERT INTO account VALUES(?, ?, ?)";
        String selectAll = "SELECT * FROM account";
        try {
            // connect to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

            // crate statement to insert
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);
            stmt.setLong(1, accountID);
            stmt.setString(2, accountName);
            stmt.setDouble(3, availableBalances);
            stmt.execute();

            // select all
            stmt = conn.prepareStatement(selectAll);

            // get data from table 'account'
            ResultSet rs = stmt.executeQuery();
            // show data
            while (rs.next()) {
                Account acc = new Account();
                rs.getDouble("accountID");
                acc.setAccountID(accountID);

                System.out.println(rs.getLong(1) + "  " + rs.getString(2) + "  " + rs.getDouble(3));
                return acc;
            }

            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void selectOne(long accountID) {
        String selectOne = "SELECT * FROM account WHERE accountID = ?";
        try {
            // connect to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

            //select one
            PreparedStatement stmtSelectOne = conn.prepareStatement(selectOne);
            stmtSelectOne.setLong(1, accountID);
            stmtSelectOne.execute();
            ResultSet resultSet = stmtSelectOne.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getLong(1));
            }

            stmtSelectOne.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void selectAll() {
        String selectAll = "SELECT * FROM account";
        try {
            // connect to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(selectAll);

            // select all
            stmt = conn.prepareStatement(selectAll);

            // get data from table 'account'
            ResultSet rs = stmt.executeQuery();
            // show data
            while (rs.next()) {
                System.out.println(rs.getLong(1) + "  " + rs.getString(2) + "  " + rs.getDouble(3));
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        }
