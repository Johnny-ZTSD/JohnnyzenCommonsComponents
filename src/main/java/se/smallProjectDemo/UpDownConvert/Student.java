package se.smallProjectDemo.UpDownConvert;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2020/2/18  10:58:05
 * @Description: ...
 */

public class Student extends People {
    private String name = "sub_name";

    public Student(String name){
        super(name);
        this.name = name;
    }

    @Override //方法覆盖/方法重写
    public void speak(){ //重写 公用方法
        System.out.println(this.name+" : " + "I want to go to school!");
    }

    public void study(){ //新增 子类特有方法
        System.out.println(this.name + " is studying.");
    }
}
