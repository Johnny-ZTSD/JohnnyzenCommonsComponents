package se.smallProjectDemo.BankWithdrawals;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2020/2/18  00:48:20
 * @Description: ...
 */

public class InsufficientFundsException extends Throwable {
    private Bank excepBank; //银行对象
    private double excepAmount; //提款数

    public InsufficientFundsException(Bank excepBank, double excepAmount) {
        this.excepBank = excepBank;
        this.excepAmount = excepAmount;
    }

    public String excepMessage(){
        String str = "Fail to withdraw!\nThe balance is "+excepBank.getBalance()+"\nThe withdraw was "+excepAmount;
        return str;
    }
}
