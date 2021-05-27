package com.vcc.mlbigdata.layer.infrastructure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcQuery {
    public void select(Connection connection){
        try(Statement statement = connection.createStatement()){ //to execute SQL statement
            String querry = "select accountID, accountName, availableBalances from account";
            ResultSet resultSet = statement.executeQuery(querry);
            while (resultSet.next()){
                long accountID = resultSet.getLong("accountID");
                String accountName = resultSet.getString("accountName");
                double availableBalances = resultSet.getDouble("availableBalances");
                System.out.println("STK: " + accountID + ",Tên TK: " + accountName + ", Số dư: $" + availableBalances);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Connection connection){
        try(Statement statement = connection.createStatement()){

        }
    }
}
