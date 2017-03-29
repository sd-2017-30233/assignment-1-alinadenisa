package main.business.logic;

import main.dataacces.dao.UserDao;
import main.dataacces.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iliesalinadenisa on 27/03/2017.
 */
public class AdminLogic  {
    UserDao userDao = new UserDao();


    public void insertUser(User user){
        userDao.addUser(user);
    }

    public void updateUser(User user){
        userDao.updateUser(user);
    }

    public void deleteUser(String username){
        userDao.deleteUser(username);
    }

    public List<User> findAllUsers(){
        List<User> users = new ArrayList<>();
        users = userDao.findAll();
        return users;
    }

}
