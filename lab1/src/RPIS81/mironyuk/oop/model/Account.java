package RPIS81.mironyuk.oop.model;



public class Account {
    String number;
    double balance;

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number=number;
    }

    public double getBalance()
    {
        return balance;
    }
    public void setBalance(double balance)
    {
        this.balance=balance;
    }

    public Account()
    {
        number="";
        balance=0.0;
    }

    public Account(String number, double balance)
    {
        this.number=number;
        this.balance=balance;
    }
}