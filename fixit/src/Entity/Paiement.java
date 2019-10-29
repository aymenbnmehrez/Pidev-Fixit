/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author aymen
 */
public class Paiement {
    private String cardNumber;
    private int expYear;
    private int expMonth;
    private String cvc;
    private int Price;

    public String getCardNumber() {
        return cardNumber;
    }

    public int getExpYear() {
        return expYear;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public int getPrice() {
        return Price;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    public void setExpMonth(int expMonth) {
        this.expMonth = expMonth;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public Paiement() {
    }

    public Paiement(String cardNumber, int expYear, int expMonth, int Price) {
        this.cardNumber = cardNumber;
        this.expYear = expYear;
        this.expMonth = expMonth;
        this.Price = Price;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public Paiement(String cardNumber, int expYear, int expMonth, String cvc, int Price) {
        this.cardNumber = cardNumber;
        this.expYear = expYear;
        this.expMonth = expMonth;
        this.cvc = cvc;
        this.Price = Price;
    }
    
    
}
