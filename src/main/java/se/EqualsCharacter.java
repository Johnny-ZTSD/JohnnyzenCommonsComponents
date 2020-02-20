package se;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2020/2/20  18:22:09
 * @Description: 等问题
 */

public class EqualsCharacter {
    public static void main(String[] args) {
        Double a = 2.0;
        double b = 2;
        Double a2 = 2.0;
        double b2 = 2;

        float c = 20.0f;
        Boolean d = true;
        boolean e = false;
        System.out.println(a==b); // 包装类对象 VS 基本数据类型
        System.out.println(a==a2);// 包装类对象 VS 包装类对象
        System.out.println(b==b2);// 基本数据类型 VS 基本数据类型
    }
}
