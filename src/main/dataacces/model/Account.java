package main.dataacces.model;

import java.sql.Date;

/**
 * Created by iliesalinadenisa on 26/03/2017.
 */
public class Account {
    private int id;
    private String type;
    private int amount;
    private java.sql.Date creationDate;
    private int clientId;

    public Account() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", creationDate=" + creationDate +
                ", clientId=" + clientId +
                '}';
    }
}
