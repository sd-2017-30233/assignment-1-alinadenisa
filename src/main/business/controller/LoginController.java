package main.business.controller;

import main.dataacces.dao.UserDao;
import main.business.logic.AdminLogic;
import main.business.logic.EmployeeLogic;
import main.dataacces.model.Role;
import main.dataacces.model.User;
import main.presentation.view.AdminView;
import main.presentation.view.EmployeeView;
import main.presentation.view.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by iliesalinadenisa on 29/03/2017.
 */
public class LoginController {
    private Login login;
    private UserDao userDao;

    public LoginController(Login login,UserDao userDao){
        this.login = login;
        this.userDao = userDao;
        this.login.addLoginUserListener(new CreateLoginListener());

    }
    class CreateLoginListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String username = null;
            String password = null;
            username = login.getUsernameTextField().getText();
            password = login.getPasswordTextField().getText();
            User user = userDao.getUserByUsername(username);
            if ((username.equals(user.getUsername())) && (password.equals(user.getPassword()))){
                if (user.getRole().equals(Role.ADMIN)) {
                    AdminView adminView = new AdminView();
                    AdminLogic adminLogic = new AdminLogic();
                    AdminController adminController = new AdminController(adminView,adminLogic);
                }
                else if (user.getRole().equals(Role.EMPLOYEE)){
                    EmployeeView employeeView = new EmployeeView();
                    EmployeeLogic employeeLogic = new EmployeeLogic();
                    EmployeeController employeeController = new EmployeeController(employeeView,employeeLogic);
                }
            }
        }
    }
}




