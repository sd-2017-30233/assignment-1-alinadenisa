package main.presentation.view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by iliesalinadenisa on 27/03/2017.
 */

public class Login extends JFrame {


    private JFrame frame = new JFrame();
    private JPanel panel;
    private JButton loginButton;
    private JTextField usernameTextField;
    private JTextField passwordTextField;     //A special JTextField but hides input text
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    public Login() {
        initComponents();
    }

    private void initComponents() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login");
        frame.setSize(900, 900);
        frame.setResizable(false);
        frame.setVisible(true);
        panel = new JPanel();
        frame.add(panel);
        panel.setVisible(true);
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");

        panel.add(usernameLabel);
        panel.add(passwordLabel);

        usernameLabel.setBounds(50,50,100,30);
        passwordLabel.setBounds(50,100,100,30);

        loginButton = new JButton("Login");
        loginButton.setBounds(50,200,100,30);

        panel.add(loginButton);

        usernameTextField = new JTextField();
        passwordTextField = new JTextField();
        usernameTextField.setVisible(true);
        passwordTextField.setVisible(true);
        usernameTextField.setBounds(150,50,100,30);
        passwordTextField.setBounds(150,100,100,30);
        panel.add(usernameTextField);
        panel.add(passwordTextField);

        System.out.println("Am ajuns aici");
    }


    public void addLoginUserListener(ActionListener a) {
        loginButton.addActionListener(a);
    }

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public void setUsernameLabel(JLabel usernameLabel) {
        this.usernameLabel = usernameLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(JTextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(JTextField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}