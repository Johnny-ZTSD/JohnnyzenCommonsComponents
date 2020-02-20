package se.smallProjectDemo.TryFinally;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2020/2/19  10:33:23
 * @Description: ...
 */

public class Main {

    public static int test(){
        int i = 0;
        try{
            i = 1;
            System.out.println("try01");
//            if(i>0)
                return i;
//            System.out.println("try02");
        } catch (Exception e){
            throw new RuntimeException();
        } finally {
            i = 2;
            System.out.println("finally");
//            return i;
        }
//        i = 4;
//        return i;
    }

    public static int getX(){
        // TODO Auto-generated method stub
        try {
            System.out.println("Try~"); //step:1
            return 0;//step:3
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            System.out.println("Finally~"); //step:2
//            return 1; //step:3
        }
        System.out.println("Method~"); //step:3
        return 3;//step:4
    }


    public static void main(String[] args) {
//        System.out.println(test());
        System.out.println(getX());
    }
}
