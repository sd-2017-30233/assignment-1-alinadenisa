package main.dataacces.model;

/**
 * Created by iliesalinadenisa on 26/03/2017.
 */
public class Client {
        private int id;
        private String name;
        private int cardNo;
        private int cnp;

    public Client(String name, int card, int identificationNr, int cont) {
    }
    public  Client(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public int getCnp() {
        return cnp;
    }

    public void setCnp(int cnp) {
        this.cnp = cnp;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cardNo=" + cardNo +
                ", cnp=" + cnp +
                '}';
    }
}
