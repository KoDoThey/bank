package com.vcc.mlbigdata.layer.infrastructure;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;

public class JdbcQuery {
    public void select(Connection connection){
        try(Statement statement = connection.createStatement()){ //to execute SQL statement
            String query = "select accountID, accountName, availableBalances from account";
            ResultSet resultSet = statement.executeQuery(query);
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



    /*
    public void insert (Connection connection){
        try (Statement statement = connection.createStatement()){
            String query = "insert into account values (\"?\", \"?\", ?);";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

     */

    /*
    public static int insertCandidate(long accountID, String accountName, double availableBalances) {
        // for insert a new candidate
        ResultSet rs = null;
        int candidateId = 0;

        String insertQuery = "insert into account (accountid, accountname, availablebalances) values ("?"," ?", ?);";

        try (Connection conn = JdbcConnection.getJdbcConnection();
            PreparedStatement pstmt = conn.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);) {

            // set parameters for statement
            pstmt.setLong(1, accountID);
            pstmt.setString(2, accountName);
            pstmt.setDouble(3, availableBalances);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {
                // get candidate id
                rs = pstmt.getGeneratedKeys();
                if(rs.next())
                    candidateId = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if(rs != null)  rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        //int id = insertCandidate("001", "Nguyen 001", 1000.04));
        return candidateId;
    }

     */

    /*
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void insert(long accountID, String accountName, double availableBalances){
        String INSERT_QUERY = "insert into account (accountid, accountname, availablebalances) values (\"?\", \"?\", ?);";
        jdbcTemplateObject.update(INSERT_QUERY, accountID, accountName, availableBalances);
        System.out.println("Insert Record with ID = " + accountID );
    }

     */
}
