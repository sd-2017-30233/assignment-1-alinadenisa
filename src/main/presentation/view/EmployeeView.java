package main.presentation.view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by iliesalinadenisa on 28/03/2017.
 */
public class EmployeeView extends JFrame {

    private JFrame frame = new JFrame();
    private JPanel panel;
    private JButton createClientButton;
    private JButton updateClientButton;
    private JButton viewClientButton;

    private JButton createAccountButton;
    private JButton updateAccountButton;
    private JButton viewAccountButton;
    private JButton deleteAccountButton;
    private JButton transferMoneyButton;

    private JTextField nameClientField;
    private JTextField cardNoClientField;
    private JTextField cnpClientField;
    private JTextField accountClientField;

    private JTextField typeAccountField;
    private JTextField amountAccountField;
    private JTextField creationDateAccountField;
    private JTextField numeTransferField;
    private JTextArea textArea;

    public EmployeeView() {
        initComponents();
    }

    private void initComponents() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Employee");
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        panel = new JPanel();
        frame.add(panel);
        panel.setVisible(true);
        panel.setLayout(null);

        JLabel clientLabel = new JLabel("Client");
        JLabel nameClientLabel = new JLabel("Name");
        JLabel cardNoClientLabel = new JLabel("CardNo");
        JLabel cnpClientLabel = new JLabel("CNP");
        JLabel accountClientLabel = new JLabel("Account");

        JLabel accountLabel = new JLabel("Account");
        JLabel typeAccountLabel = new JLabel("Type");
        JLabel amountAccountLabel = new JLabel("Amount");
        JLabel creationDateAccountLabel = new JLabel("CreationDate");
        JLabel numeTransferLabel = new JLabel("Nume transfer");

        panel.add(clientLabel);
        panel.add(nameClientLabel);
        panel.add(cardNoClientLabel);
        panel.add(cnpClientLabel);
        panel.add(accountClientLabel);

        panel.add(accountLabel);
        panel.add(typeAccountLabel);
        panel.add(amountAccountLabel);
        panel.add(creationDateAccountLabel);
        panel.add(numeTransferLabel);

        clientLabel.setBounds(50, 50, 150, 30);
        nameClientLabel.setBounds(50, 100, 150, 30);
        cardNoClientLabel.setBounds(50, 150, 150, 30);
        cnpClientLabel.setBounds(50, 200, 150, 30);
        accountClientLabel.setBounds(50, 250, 150, 30);

        accountLabel.setBounds(400, 50, 150, 30);
        typeAccountLabel.setBounds(400, 100, 150, 30);
        amountAccountLabel.setBounds(400, 150, 150, 30);
        creationDateAccountLabel.setBounds(400, 200, 150, 30);
        numeTransferLabel.setBounds(400,250,150,30);
        createClientButton = new JButton("Create Client");
        updateClientButton = new JButton("Update Client");
        viewClientButton = new JButton("View Client ");

        createAccountButton = new JButton("Create Account");
        updateAccountButton = new JButton("Update Account");
        viewAccountButton = new JButton("View Account ");
        deleteAccountButton = new JButton("Delete Account");
        transferMoneyButton = new JButton("Transfer money");

        createClientButton.setBounds(220, 100, 150, 30);
        updateClientButton.setBounds(220, 150, 150, 30);
        viewClientButton.setBounds(220, 200, 150, 30);

        createAccountButton.setBounds(600, 100, 150, 30);
        updateAccountButton.setBounds(600, 150, 150, 30);
        viewAccountButton.setBounds(600, 200, 150, 30);
        deleteAccountButton.setBounds(600, 250, 150, 30);
        transferMoneyButton.setBounds(600,300,150,30);

        panel.add(createClientButton);
        panel.add(updateClientButton);
        panel.add(viewClientButton);
        panel.add(createAccountButton);
        panel.add(updateAccountButton);
        panel.add(viewAccountButton);
        panel.add(deleteAccountButton);
        panel.add(transferMoneyButton);

        nameClientField = new JTextField();
        cardNoClientField = new JTextField();
        cnpClientField = new JTextField();
        accountClientField = new JTextField();

        typeAccountField = new JTextField();
        amountAccountField = new JTextField();
        creationDateAccountField = new JTextField();
        numeTransferField = new JTextField();

        nameClientField.setBounds(120, 100, 80, 30);
        cardNoClientField.setBounds(120, 150, 80, 30);
        cnpClientField.setBounds(120, 200, 80, 30);
        accountClientField.setBounds(120, 250, 80, 30);

        typeAccountField.setBounds(500, 100, 80, 30);
        amountAccountField.setBounds(500, 150, 80, 30);
        creationDateAccountField.setBounds(500, 200, 80, 30);
        numeTransferField.setBounds(500,250,80,30);

        panel.add(nameClientField);
        panel.add(cardNoClientField);
        panel.add(cnpClientField);
        panel.add(accountClientField);

        panel.add(typeAccountField);
        panel.add(amountAccountField);
        panel.add(creationDateAccountField);
        panel.add(numeTransferField);

        textArea = new JTextArea(5,20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(textArea);
        panel.add(scrollPane);

        textArea.setVisible(true);
        textArea.setBounds(50,320,200,100);

    }
    public void clear(){
        nameClientField.setText("");
        cardNoClientField.setText("");
        cnpClientField.setText("");
        accountClientField.setText("");

        typeAccountField.setText("");
        amountAccountField.setText("");
        creationDateAccountField.setText("");
        numeTransferField.setText("");
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void addCreateClientListener(ActionListener a) {
        createClientButton.addActionListener(a);
    }

    public void addUpdateClientListener(ActionListener a) {
        updateClientButton.addActionListener(a);
    }

    public void addViewClientListener(ActionListener a) {
        viewClientButton.addActionListener(a);
    }
    public void addCreateAccountListener(ActionListener a) {
        createAccountButton.addActionListener(a);
    }

    public void addUpdateAccountListener(ActionListener a) {
        updateAccountButton.addActionListener(a);
    }

    public void addViewAccountListener(ActionListener a) {
        viewAccountButton.addActionListener(a);
    }

    public void addDeleteAccountListener(ActionListener a) {
        deleteAccountButton.addActionListener(a);
    }

    public void addTransferMoneyListener(ActionListener a){transferMoneyButton.addActionListener(a);}

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JTextArea getTextArea() { return textArea;  }

    public void setTextArea(JTextArea textArea) { this.textArea = textArea; }

    public JButton getCreateClientButton() {
        return createClientButton;
    }

    public void setCreateClientButton(JButton createClientButton) {
        this.createClientButton = createClientButton;
    }

    public JButton getUpdateClientButton() {
        return updateClientButton;
    }

    public void setUpdateClientButton(JButton updateClientButton) {
        this.updateClientButton = updateClientButton;
    }

    public JButton getViewClientButton() {
        return viewClientButton;
    }

    public void setViewClientButton(JButton viewClientButton) {
        this.viewClientButton = viewClientButton;
    }

    public JButton getCreateAccountButton() {
        return createAccountButton;
    }

    public void setCreateAccountButton(JButton createAccountButton) {
        this.createAccountButton = createAccountButton;
    }

    public JButton getUpdateAccountButton() {
        return updateAccountButton;
    }

    public void setUpdateAccountButton(JButton updateAccountButton) {
        this.updateAccountButton = updateAccountButton;
    }

    public JButton getViewAccountButton() {
        return viewAccountButton;
    }

    public void setViewAccountButton(JButton viewAccountButton) {
        this.viewAccountButton = viewAccountButton;
    }

    public JButton getDeleteAccountButton() {
        return deleteAccountButton;
    }

    public void setDeleteAccountButton(JButton deleteAccountButton) {
        this.deleteAccountButton = deleteAccountButton;
    }

    public JTextField getNameClientField() {
        return nameClientField;
    }

    public void setNameClientField(JTextField nameClientField) {
        this.nameClientField = nameClientField;
    }

    public JTextField getCardNoClientField() {
        return cardNoClientField;
    }

    public void setCardNoClientField(JTextField cardNoClientField) {
        this.cardNoClientField = cardNoClientField;
    }

    public JTextField getCnpClientField() {
        return cnpClientField;
    }

    public void setCnpClientField(JTextField cnpClientField) {
        this.cnpClientField = cnpClientField;
    }

    public JTextField getAccountClientField() {
        return accountClientField;
    }

    public void setAccountClientField(JTextField accountClientField) {
        this.accountClientField = accountClientField;
    }

    public JTextField getTypeAccountField() {
        return typeAccountField;
    }

    public void setTypeAccountField(JTextField typeAccountField) {
        this.typeAccountField = typeAccountField;
    }

    public JTextField getAmountAccountField() {
        return amountAccountField;
    }

    public void setAmountAccountField(JTextField amountAccountField) {
        this.amountAccountField = amountAccountField;
    }

    public JTextField getCreationDateAccountField() {
        return creationDateAccountField;
    }

    public void setCreationDateAccountField(JTextField creationDateAccountField) {
        this.creationDateAccountField = creationDateAccountField;
    }

    public JButton getTransferMoneyButton() {
        return transferMoneyButton;
    }

    public void setTransferMoneyButton(JButton transferMoneyButton) {
        this.transferMoneyButton = transferMoneyButton;
    }

    public JTextField getNumeTransferField() {
        return numeTransferField;
    }

    public void setNumeTransferField(JTextField numeTransferField) {
        this.numeTransferField = numeTransferField;
    }
}
