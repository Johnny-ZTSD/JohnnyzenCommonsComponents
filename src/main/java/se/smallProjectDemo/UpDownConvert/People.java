package se.smallProjectDemo.UpDownConvert;

import java.util.Random;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2020/2/18  10:55:06
 * @Description: 上下转型
 */

public class People {
    private String name = "parent_parent";
    private static String sProperty = "parent_staticProperty";
    private final static String fsProperty = "parent_finalStaticProperty";

    public People(String name) {
        this.name = name;
    }

    public void speak(){ //讲话 - 父子公用方法
        System.out.println(name+": "+ "I want to sleep.");
    }
}
