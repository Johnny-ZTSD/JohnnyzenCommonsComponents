package se.smallProjectDemo.BankWithdrawals;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2020/2/18  00:52:52
 * @Description: ...
 */

public class Client {
    public static void main(String[] args) {
        Bank bank = new Bank(1500);
        bank.deposite(50); //存50元钱
        try {//【顶层Client 捕获/处理异常】
            bank.withdraw(2000); //取款2000元 【底层Bank 抛出异常】
        } catch (InsufficientFundsException e) {
            System.err.println(e.toString());
            System.err.println(e.excepMessage());
            e.printStackTrace();
        }
    }
}
