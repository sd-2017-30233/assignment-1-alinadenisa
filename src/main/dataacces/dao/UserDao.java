package main.dataacces.dao;

import main.dataacces.model.Role;
import main.dataacces.model.User;
import main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iliesalinadenisa on 27/03/2017.
 */
public class UserDao {
    private Connection connection;

    public UserDao() {
        connection = DBUtil.getConnection();
        System.out.println("Conexiunea :" + connection);
    }

    public void addUser(User user) {
        try {
            PreparedStatement statement =
                    connection.prepareStatement("insert into employee(username,password,name,role) values (?, ?, ?, ?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            int role = 0;
            if (user.getRole().equals(Role.ADMIN)) role = 1;
            if (user.getRole().equals(Role.EMPLOYEE)) role = 2;
            statement.setInt(4, role);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update employee set name=?, password=?" +
                            " where username=?");
            // Parameters start with 1
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String username) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from employee where username=?");
            // Parameters start with 1
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                int role = rs.getInt("role");

                Role roleEnum = null;
                if (role == 1) {
                    roleEnum = Role.ADMIN;
                } else if (role == 2) {
                    roleEnum = Role.EMPLOYEE;
                }
                User user = new User(idUser, username, password, name, roleEnum);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public User getUserByUsername(String username){
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where username =?");
            preparedStatement.setString(1,username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id");
                username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                int role = rs.getInt("role");

                Role roleEnum = null;
                if (role == 1) {
                    roleEnum = Role.ADMIN;
                } else if (role == 2) {
                    roleEnum = Role.EMPLOYEE;
                }
                user.setId(idUser);
                user.setUsername(username);
                user.setPassword(password);
                user.setRole(roleEnum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

