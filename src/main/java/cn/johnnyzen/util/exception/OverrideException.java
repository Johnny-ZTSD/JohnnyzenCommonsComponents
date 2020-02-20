package cn.johnnyzen.util.exception;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2019/6/24  17:58:56
 * @Description: ...
 */

public class OverrideException extends Exception{
    public OverrideException(){
        super("Not be implements and need be override!");
    }
    public OverrideException(String message){
        super(message);
    }
}
