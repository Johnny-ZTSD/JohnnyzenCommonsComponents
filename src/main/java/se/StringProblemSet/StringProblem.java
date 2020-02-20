package se.StringProblemSet;

import cn.johnnyzen.util.print.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2020/2/20  18:46:07
 * @Description: ...
 */

public class StringProblem {

    /**
     * 问题：如何把一段逗号分割的字符串转换成一个数组?
     *
     * @param str
     */
    public static List<String> convertString(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        List<String> strs = new ArrayList<String>();
        while (stringTokenizer.hasMoreTokens()) {
            strs.add(stringTokenizer.nextToken(","));
        }
        return strs;
    }

    public static void main(String[] args) {
//        Print.print(convertString("345,4564,65r,erge43,436,dsfgt43,sdf,3465,sdf,6"));
        int a = 0;
        int b = 0;
        if ((a = 3) > 0 || (b = 3) > 0) {
            System.out.println("a:"+a + "\tb:" + b);// a:3 b:0
        }
        if ((a = 3) > 0 | (b = 3) > 0) {
            System.out.println("a:"+a + "\tb:" + b);// a:3 b:3
        }
    }
}
