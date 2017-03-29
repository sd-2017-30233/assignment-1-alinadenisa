package main.business.logic;

import main.dataacces.dao.AccountDao;
import main.dataacces.dao.ClientDao;
import main.dataacces.model.Account;
import main.dataacces.model.Client;

/**
 * Created by iliesalinadenisa on 28/03/2017.
 */
public class EmployeeLogic {
    ClientDao clientDao = new ClientDao();
    AccountDao accountDao = new AccountDao();

    public void addClient(Client client){
        clientDao.addClient(client);
    }

    public void updateClient(Client client){
        clientDao.updateClient(client);
    }

    public Client viewClient(String name){
        return clientDao.getClientByName(name);
    }

    public Client getClientByName (String name) {
        return clientDao.getClientByName(name);
    }

    public void addAccount(Account account,Client client){
        accountDao.addAccount(account,client);
    }

    public void updateAccount(Account account,Client client){
        accountDao.updateAccount(account,client);
    }

    public Account getAccountByIdClient(int clientId){
        return accountDao.getAccountByIdClient(clientId);
    }

    public void deleteAccount(int clientId,String type){
        accountDao.deleteAccount(clientId,type);
    }


}
