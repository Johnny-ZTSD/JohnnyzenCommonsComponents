package se.smallProjectDemo.ExceptionChain;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2020/2/18  13:02:19
 * @Description: ...
 */

public class Operator {

    //执行加法运算
    public static int add() throws Exception {
    //因为new的Exception类对象是【检查异常】，【必须】在方法声明处throws
        int result;
        try {
            List<Integer> nums = getInputNumbers();
            result = nums.get(0) + nums.get(1);
        } catch (InputMismatchException immExp) {
            throw new IOException("计算失败!", immExp);
            //异常的链化:以一个异常对象为参数构造新的异常对象。
        }
        return result;
    }

    //获取输入的2个整数返回
    private static List<Integer> getInputNumbers() {
    //而InputMismatchException的类对象immExp属于运行时异常【即 非检查异常】，【可以或不需】在方法声明处throws异常
        List nums = (List) new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        try {
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            nums.add(new Integer(num1));
            nums.add(new Integer(num2));
        } catch (InputMismatchException immExp) {
            //InputMismatchException < NoSuchElementException < RuntimeException < Exception < Object
            throw immExp;
        } finally {
            scan.close();
        }
        return nums;
    }
}
