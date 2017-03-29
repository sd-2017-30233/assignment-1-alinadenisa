package main.presentation.view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by iliesalinadenisa on 27/03/2017.
 */
public class AdminView extends JFrame {

    private JFrame frame = new JFrame();
    private JPanel panel;
    private JButton createUserButton;
    private JButton updateUserButton;
    private JButton viewUserButton;
    private JButton deleteUserButton;

    private JTextField usernameUserField;
    private JTextField passwordUserField;
    private JTextField nameUserField;
    private JTextField roleUserField;

    //private JTextArea textArea;

    public AdminView() {
        initComponents();
    }

    private void initComponents() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Administrator");
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        panel = new JPanel();
        frame.add(panel);
        panel.setVisible(true);
        panel.setLayout(null);

        JLabel userAccountLabel = new JLabel("User Accounts");
        JLabel usernameUserLabel = new JLabel("Username");
        JLabel passwordUserLabel = new JLabel("Password");
        JLabel nameUserLabel = new JLabel("Name");
        JLabel roleUserLabel = new JLabel("Role");

        panel.add(userAccountLabel);
        panel.add(usernameUserLabel);
        panel.add(passwordUserLabel);
        panel.add(nameUserLabel);
        panel.add(roleUserLabel);

        userAccountLabel.setBounds(50, 50, 150, 30);
        usernameUserLabel.setBounds(50, 100, 150, 30);
        passwordUserLabel.setBounds(50, 150, 150, 30);
        nameUserLabel.setBounds(50, 200, 150, 30);
        roleUserLabel.setBounds(50, 250, 150, 30);

        createUserButton = new JButton("Create User");
        updateUserButton = new JButton("Update User");
        viewUserButton = new JButton("View User ");
        deleteUserButton = new JButton("Delete User");

        createUserButton.setBounds(300, 100, 130, 30);
        updateUserButton.setBounds(300, 150, 130, 30);
        viewUserButton.setBounds(300, 200, 130, 30);
        deleteUserButton.setBounds(300, 250, 130, 30);

        panel.add(createUserButton);
        panel.add(updateUserButton);
        panel.add(viewUserButton);
        panel.add(deleteUserButton);

        usernameUserField = new JTextField();
        passwordUserField = new JTextField();
        nameUserField = new JTextField();
        roleUserField = new JTextField();

        usernameUserField.setBounds(120, 100, 150, 30);
        passwordUserField.setBounds(120, 150, 150, 30);
        nameUserField.setBounds(120, 200, 150, 30);
        roleUserField.setBounds(120, 250, 150, 30);

        panel.add(usernameUserField);
        panel.add(passwordUserField);
        panel.add(nameUserField);
        panel.add(roleUserField);

        JSeparator separtor = new JSeparator(JSeparator.VERTICAL);
        separtor.setBounds(440, 50, 10, 450);
        panel.add(separtor);
    }

    public void clear(){
        usernameUserField.setText("");
        passwordUserField.setText("");
        nameUserField.setText("");
        roleUserField.setText("");
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void addCreateUserListener(ActionListener a) {
        createUserButton.addActionListener(a);
    }

    public void addUpdateUserListener(ActionListener a) {
            updateUserButton.addActionListener(a);
        }

    public void addViewUserListener(ActionListener a) {
        viewUserButton.addActionListener(a);
    }

    public void addDeleteUserListener(ActionListener a) {
        deleteUserButton.addActionListener(a);
    }

    public JButton getCreateUserButton() {
        return createUserButton;
    }

    public void setCreateUserButton(JButton createUserButton) {
        this.createUserButton = createUserButton;
    }

    public JButton getUpdateUserButton() {
        return updateUserButton;
    }

    public void setUpdateUserButton(JButton updateUserButton) {
        this.updateUserButton = updateUserButton;
    }

    public JButton getViewUserButton() {
        return viewUserButton;
    }

    public void setViewUserButton(JButton viewUserButton) {
        this.viewUserButton = viewUserButton;
    }

    public JButton getDeleteUserButton() {
        return deleteUserButton;
    }

    public void setDeleteUserButton(JButton deleteUserButton) {
        this.deleteUserButton = deleteUserButton;
    }

    public JTextField getUsernameUserField() {
        return usernameUserField;
    }

    public void setUsernameUserField(JTextField usernameUserField) {
        this.usernameUserField = usernameUserField;
    }

    public JTextField getPasswordUserField() {
        return passwordUserField;
    }

    public void setPasswordUserField(JTextField passwordUserField) {
        this.passwordUserField = passwordUserField;
    }

    public JTextField getNameUserField() {
        return nameUserField;
    }

    public void setNameUserField(JTextField nameUserField) {
        this.nameUserField = nameUserField;
    }

    public JTextField getRoleUserField() {
        return roleUserField;
    }

    public void setRoleUserField(JTextField roleUserField) {
        this.roleUserField = roleUserField;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
