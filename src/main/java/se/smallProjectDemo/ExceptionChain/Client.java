package se.smallProjectDemo.ExceptionChain;

import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2020/2/18  12:56:09
 * @Description: 异常链化
 * + https://www.oschina.net/question/2376912_2287532?sort=time
 */

public class Client {
    public static void main(String[] args) {
        System.out.println("请输入2个正整型的加数");
        int result;
        try
        {
            result = Operator.add();
            System.out.println("结果:"+result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
