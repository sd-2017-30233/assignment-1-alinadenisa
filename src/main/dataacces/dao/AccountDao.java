package main.dataacces.dao;

import main.dataacces.model.Account;
import main.dataacces.model.Client;
import main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by iliesalinadenisa on 27/03/2017.
 */
public class AccountDao {
    private Connection connection ;

    public AccountDao() {
        connection = DBUtil.getConnection();
        System.out.println("Conexiunea :" + connection);
    }
    public void addAccount(Account account,Client client) {
        try {
            PreparedStatement statement =
                    connection.prepareStatement( "insert into account(type,amount,creationDate,idClient) values (?, ?, ?,?)");
            statement.setString(1, account.getType());
            statement.setInt(2,account.getAmount());
            statement.setDate(3, account.getCreationDate());
            statement.setInt(4,client.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateAccount(Account account,Client client){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update account set type=?, amount=?, creationDate=?" +
                            " where idClient=?");
            // Parameters start with 1
            preparedStatement.setString(1,account.getType());
            preparedStatement.setInt(2, account.getAmount());
            preparedStatement.setDate(3, account.getCreationDate());
            preparedStatement.setInt(4, client.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAccount(int clientId,String type){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from account where idClient=? and type =?");
            // Parameters start with 1
            preparedStatement.setInt(1, clientId);
            preparedStatement.setString(2,type);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Account getAccountByIdClient(int clientId) {
        Account account = new Account();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from account where idClient=?");
            preparedStatement.setInt(1, clientId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                account.setId(rs.getInt("id"));
                account.setType(rs.getString("type"));
                account.setAmount(rs.getInt("amount"));
                account.setCreationDate(rs.getDate("creationDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

}
