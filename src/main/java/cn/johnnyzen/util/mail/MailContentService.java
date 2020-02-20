package cn.johnnyzen.util.mail;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2019/6/29  13:55:02
 * @Description: ...
 */

public class MailContentService {

    /**
     * 生成用户注册激活的邮件内容[通过激活码链接 -> 激活账户]
     * @param protocol http
     * @param serverDomain localhost or johnnyzen.cn # 本服务器域名或者IP
     * @param port 9000
     * @param actionPath /register-activate/view
     * @param contextPath /poms
     * @param activateCode 235273796
     * @return
     */
    public static String generateMailContentOfUserAccountActivateByLink(String protocol,String serverDomain,String port,String contextPath, String actionPath, String activateCode){
        if(actionPath.startsWith("/")){//判断actionPath有无/符去，如果有统一除/
           actionPath = actionPath.substring(1);
        }
        String url = protocol + "://"
                + serverDomain + ":"
                + port + "/"
                + contextPath + "/"
                + actionPath
                + "?code=" + activateCode;
        String content =
                "<html><head></head><body><h1>This is a account activate email,please click this link if you like activate your account.</h1><h3>" +
                        "<a href='" + url + "'>" + url + "</href></h3></body></html>";
        return content;
    }

    /**
     * 生成用户注册激活的邮件内容[通过发送激活码 -> 激活账户]
     */
    public static String generateMailContentOfUserAccountActivateByActivateCode(String emailCode){
        String content="用户注册最新激活码:" + emailCode;
        return content;
    }

    /**
     * 生成找回密码[申请]的邮件内容[通过发送激活码 -> 找回密码申请]
     */
    public static String generateMailContentOfFindBackPasswordApplyByEmailCode(String emailCode){
        String content="找回密码 最新激活码:" + emailCode;
        return content;
    }

    /**
     * 生成找回密码[随机密码]的邮件内容[通过发送新密码 -> 重置密码]
     */
    public static String generateMailContentOfFindBackPasswordResetPasswordBNewPassword(String newPassword){
        String content="账户最新密码:" + newPassword;
        return content;
    }
}
