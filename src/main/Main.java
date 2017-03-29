package main;

import main.business.controller.LoginController;
import main.dataacces.dao.UserDao;
import main.business.logic.AdminLogic;
import main.business.logic.EmployeeLogic;
import main.presentation.view.Login;

import java.text.ParseException;

/**
 * Created by iliesalinadenisa on 27/03/2017.
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        UserDao userDao = new UserDao();
        Login login = new Login();
        LoginController loginController = new LoginController(login, userDao);

/*
        AccountDao accountDao = new AccountDao();
        Account account = new Account();
        Client client = new Client();
        String strDate = "2011-12-31 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        java.util.Date date = sdf.parse(strDate);
        java.sql.Date sqlDate = new Date(date.getTime());

        account.setType("economii");
        account.setAmount(200);
        account.setCreationDate(sqlDate);
        accountDao.addAccount(account);
    }*/
    }
}
