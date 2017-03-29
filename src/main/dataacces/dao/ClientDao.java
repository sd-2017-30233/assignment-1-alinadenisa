package main.dataacces.dao;

import main.dataacces.model.Client;
import main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by iliesalinadenisa on 27/03/2017.
 */
public class ClientDao {
    private Connection connection ;

    public ClientDao() {
        connection = DBUtil.getConnection();
        System.out.println("Conexiunea :" + connection);
    }
    public void addClient(Client client) {
        try {
            PreparedStatement statement =
                    connection.prepareStatement("insert into client(name,cardNo,cnp) values (?, ?, ?)");
            statement.setString(1, client.getName());
            statement.setInt(2,client.getCardNo());
            statement.setInt(3, client.getCnp());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateClient(Client client){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update client set  cardNo=?, cnp=?" +
                            " where name=?");
            // Parameters start with 1
            preparedStatement.setInt(1, client.getCardNo());
            preparedStatement.setInt(2, client.getCnp());
            preparedStatement.setString(3,client.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteClient(String name){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from client where name=?");
            // Parameters start with 1
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Client getClientById(int clientId) {
        Client client = new Client();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from client where id=?");
            preparedStatement.setInt(1, clientId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setCardNo(rs.getInt("cardNo"));
                client.setCnp(rs.getInt("cnp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return client;
    }
    public Client getClientByName(String name){
        Client client = new Client();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from client where name=?");
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setCardNo(rs.getInt("cardNo"));
                client.setCnp(rs.getInt("cnp"));
            }

        }
         catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }
}
