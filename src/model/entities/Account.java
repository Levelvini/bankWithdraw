package model.entities;

import model.exceptions.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private double balance;
    private double withdrawLimite;

    public Account(){
    }

    public Account(int number, String holder, double balance, double withdrawLimite) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimite = withdrawLimite;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawLimite() {
        return withdrawLimite;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setWithdrawLimite(double withdrawLimite) {
        this.withdrawLimite = withdrawLimite;
    }

    public void deposit(double amount){
        balance += amount;
    }
    public  void withdraw(double amount){
        validadeWithdraw(amount);
        balance -= amount;
    }
    private void validadeWithdraw(double amount) {
    if (amount > getWithdrawLimite()){
        throw new DomainException("o valor incerido excede o limite de saque, tente novamente!!");
    }if (amount > balance){
        throw new DomainException("saldo insuficiente!!");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", holder='" + holder + '\'' +
                ", balance=" + balance +
                ", withdrawLimite=" + withdrawLimite +
                '}';
    }
}
