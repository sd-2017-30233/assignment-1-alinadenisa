package main.business.controller;

import main.business.logic.AdminLogic;
import main.dataacces.model.Role;
import main.dataacces.model.User;
import main.presentation.view.AdminView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by iliesalinadenisa on 27/03/2017.
 */
public class AdminController {

     AdminView adminView;
     AdminLogic adminLogic;

    public AdminController(AdminView adminView,AdminLogic adminLogic) {
        this.adminView = adminView;
        this.adminLogic = adminLogic;
        this.adminView.addCreateUserListener(new CreateUserListener());
        this.adminView.addUpdateUserListener(new UpdateUserListener());
        this.adminView.addViewUserListener(new ViewUserListener());
        this.adminView.addDeleteUserListener(new DeleteUserListener());
    }

    class CreateUserListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = null;
            String password = null;
            String name = null;
            String role = null;
            username = adminView.getUsernameUserField().getText();
            password = adminView.getPasswordUserField().getText();
            name = adminView.getNameUserField().getText();
            role = adminView.getRoleUserField().getText();
            Role role1 = null;
            if (role.equals("admin")) {
                role1 = Role.ADMIN;
            } else if (role.equals("employee")) {
                role1 = Role.EMPLOYEE;
            }
            else {
                JOptionPane.showMessageDialog(null, "Nu exista acest rol", "Atentie",
                        JOptionPane.ERROR_MESSAGE);
            }
            User user = new User(username, password,name, role1);
            adminLogic.insertUser(user);
            JOptionPane.showMessageDialog(null, "User successfully added",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

            adminView.clear();
        }
    }
    class UpdateUserListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String username = null;
            String password = null;
            String name = null;
            String role = null;
            username = adminView.getUsernameUserField().getText();
            password = adminView.getPasswordUserField().getText();
            name = adminView.getNameUserField().getText();
            User user = new User();
            user.setPassword(password);
            user.setName(name);
            user.setUsername(username);
            adminLogic.updateUser(user);
            JOptionPane.showMessageDialog(null, "User successfully updated",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

            adminView.clear();
        }
    }

    class ViewUserListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String username = null;
            username = adminView.getUsernameUserField().getText();

        }
    }

    class DeleteUserListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String username = null;
            username = adminView.getUsernameUserField().getText();
            adminLogic.deleteUser(username);
            JOptionPane.showMessageDialog(null, "User successfully deleted",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

            adminView.clear();
        }
    }
}
