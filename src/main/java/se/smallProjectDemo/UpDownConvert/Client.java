package se.smallProjectDemo.UpDownConvert;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2020/2/18  11:12:59
 * @Description: 推荐文章： 8.7.3 上下转型和多态！ https://www.cnblogs.com/bchen/p/7423316.html
 */

public class Client {
    /**
     * output: 小明 : I want to go to school!  -- speak()
     */
    public static void upCast(){
        People people = new Student("小明"); //向上转型
        people.speak();  //调用父/子类的公用方法（可能方法已被子类方法覆盖override)
    }

    /**
     * output01: 小明 : I want to go to school!  -- speak()
     * output02: 小明 is studying.  -- study()
     */
    public static void downCast001(){
        People people = new Student("小明"); //1 向上转型 (向下转型的 前提条件/铺垫)
        Student student = (Student) people; //2 向下强制转型 (可能存在ClassCastException的风险)
        student.speak();
        student.study(); //调用子类的特有方法 【向下转型的初衷】
    }

    /**
     * output01: 小明 : I want to go to school!  -- speak()
     * output02: 小明 is studying.  -- study()
     */
    public static void downCast002(){
        People people = new Student("小明"); //1 向上转型 (向下转型的 前提条件/铺垫)
        if(people instanceof People){
            Student student = (Student) people; //2 向下强制转型 (【避免】可能存在【ClassCastException】的风险)
            student.speak();
            student.study(); //调用子类的特有方法 【向下转型的初衷】
        }
    }

    public static void main(String[] args) {
        upCast();
        downCast001();
        downCast002();
    }
}
