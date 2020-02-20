package se.smallProjectDemo.BankWithdrawals;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2020/2/18  00:45:08
 * @Description: ...
 */

public class Bank {
    private double balance; //存款余额

    public Bank(double balance){
        this.balance = balance;
    }

    public void deposite(double dAmount){ //存钱
        if (dAmount >0.0d){
            balance += dAmount;
        }
    }

    public void withdraw(double dAmount) throws InsufficientFundsException {//取钱
        if(balance<dAmount){
            throw new InsufficientFundsException(this, dAmount);
        }
        balance = balance - dAmount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
