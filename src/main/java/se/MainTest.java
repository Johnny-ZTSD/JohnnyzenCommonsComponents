package se;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2020/2/17  17:10:40
 * @Description: ...
 */

public class MainTest {
    public static void main(String[] args) {
        try{
            //可能产生异常的代码段
        } catch (Exception e){//e为异常类型的实例对象
            //异常处理
        } //[finally {
        //不管是否发生异常，总要执行的代码段
        //} ]
        int x = 5/0;
        System.out.println(x);
    }
}
