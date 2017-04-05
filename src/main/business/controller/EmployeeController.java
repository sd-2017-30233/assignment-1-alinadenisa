package main.business.controller;

import main.business.logic.EmployeeLogic;
import main.dataacces.model.Account;
import main.dataacces.model.Client;
import main.presentation.view.EmployeeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by iliesalinadenisa on 27/03/2017.
 */
public class EmployeeController {
    private EmployeeView employeeView ;
    private EmployeeLogic employeeLogic;

    public EmployeeController(EmployeeView employeeView,EmployeeLogic employeeLogic) {
        this.employeeView = employeeView;
        this.employeeLogic = employeeLogic;
        this.employeeView.addCreateClientListener(new CreateClientListener());
        this.employeeView.addUpdateClientListener(new UpdateClientListener());
        this.employeeView.addViewClientListener(new ViewClientListener());

        this.employeeView.addCreateAccountListener(new CreateAccountListener());
        this.employeeView.addUpdateAccountListener(new UpdateAccountListener());
        this.employeeView.addViewAccountListener(new ViewAccountListener());
        this.employeeView.addDeleteAccountListener(new DeleteAccountListener());
        this.employeeView.addTransferMoneyListener(new TransferMoneyListener());
    }

    class CreateClientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = null;
            String cardNo = null;
            String cnp = null;
            String account = null;
            name = employeeView.getNameClientField().getText();
            cardNo = employeeView.getCardNoClientField().getText();
            cnp = employeeView.getCnpClientField().getText();
            int card = Integer.parseInt(cardNo);
            int identificationNr = Integer.parseInt(cnp);

            Client client = new Client();
            client.setName(name);
            client.setCardNo(card);
            client.setCnp(identificationNr);

            employeeLogic.addClient(client);
            JOptionPane.showMessageDialog(null, "Client successfully added",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

            employeeView.clear();
            }
        }
    class UpdateClientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = null;
            String cardNo = null;
            String cnp = null;
            name = employeeView.getNameClientField().getText();
            cardNo = employeeView.getCardNoClientField().getText();
            cnp = employeeView.getCnpClientField().getText();
            int card = Integer.parseInt(cardNo);
            int identificationNr = Integer.parseInt(cnp);
            Client client = new Client();
            client.setName(name);
            client.setCardNo(card);
            client.setCnp(identificationNr);

            employeeLogic.updateClient(client);
            JOptionPane.showMessageDialog(null, "Client successfully updated",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

            employeeView.clear();
        }
    }

    class ViewClientListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String name = null;
            name = employeeView.getNameClientField().getText();
            Client client = employeeLogic.viewClient(name);
            employeeView.getTextArea().append(client.toString());
        }
    }

    class CreateAccountListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String type = employeeView.getTypeAccountField().getText();
            String amount = employeeView.getAmountAccountField().getText();
            String creationDate = employeeView.getCreationDateAccountField().getText();
            String name = employeeView.getNameClientField().getText();
            Client client = employeeLogic.getClientByName(name);
            int clientId =client.getId();
            int suma = Integer.parseInt(amount);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            java.util.Date date = null;
            try {
                date = sdf.parse(creationDate);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            java.sql.Date sqlDate = new Date(date.getTime());

            Account account = new Account();
            account.setType(type);
            account.setAmount(suma);
            account.setCreationDate(sqlDate);
            account.setClientId(clientId);
            employeeLogic.addAccount(account,client);
            JOptionPane.showMessageDialog(null, "Account successfully added",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

            employeeView.clear();
        }
    }

    class UpdateAccountListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String type = employeeView.getTypeAccountField().getText();
            String amount = employeeView.getAmountAccountField().getText();
            String creationDate = employeeView.getCreationDateAccountField().getText();
            String name = employeeView.getNameClientField().getText();
            Client client = employeeLogic.getClientByName(name);
            int clientId =client.getId();
            int suma = Integer.parseInt(amount);
            Account account = new Account();
            account.setType(type);
            account.setAmount(suma);
            account.setClientId(clientId);
            employeeLogic.updateAccount(account,client);
            JOptionPane.showMessageDialog(null, "Account successfully updated",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

            employeeView.clear();
        }
    }

    class ViewAccountListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String name = employeeView.getNameClientField().getText();
            Client client = employeeLogic.getClientByName(name);
            int clientId =client.getId();
            Account account = employeeLogic.getAccountByIdClient(clientId);
            employeeView.getTextArea().append(account.toString() +"\n");
            employeeView.clear();
        }
    }

    class DeleteAccountListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        String name = employeeView.getNameClientField().getText();
        String type = employeeView.getTypeAccountField().getText();
        Client client = employeeLogic.getClientByName(name);
        int clientId= client.getId();
        employeeLogic.deleteAccount(clientId,type);
            JOptionPane.showMessageDialog(null, "Account successfully deleted",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

            employeeView.clear();
        }
    }

    class TransferMoneyListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String name = employeeView.getNameClientField().getText();
            String name1 = employeeView.getNumeTransferField().getText();
            String type = employeeView.getTypeAccountField().getText();
            String suma = employeeView.getAmountAccountField().getText();
            int amount = Integer.parseInt(suma);
            Client client = employeeLogic.getClientByName(name);
            int id = client.getId();
            Client client1 = employeeLogic.getClientByName(name1);
            int id1 = client1.getId();
            employeeLogic.transferMoney(id, type, id1,amount);
            JOptionPane.showMessageDialog(null, "Amount of money successfully transfered",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

            employeeView.clear();
        }
    }
}
