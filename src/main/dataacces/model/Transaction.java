package main.dataacces.model;

import java.sql.Date;

/**
 * Created by iliesalinadenisa on 27/03/2017.
 */
public class Transaction {
    private int id;
    private java.sql.Date date;
    private int idUser;
    private int idAccount;

    public Transaction(int id, Date date, int idUser, int idAccount) {
        this.id = id;
        this.date = date;
        this.idUser = idUser;
        this.idAccount = idAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date=" + date +
                ", idUser=" + idUser +
                ", idAccount=" + idAccount +
                '}';
    }
}
