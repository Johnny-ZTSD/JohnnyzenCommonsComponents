package cn.johnnyzen.util.mail;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2019/4/22  10:05:51
 * @Description: ...
 */
@Component
@ConfigurationProperties(prefix="mail")
public class MailProperties {

    /* 项目上下文名 */
//    @Value("${server.servlet.contextPath}")
//    private String contextPath;

//    /* 项目运行端口 */
////    @Value("${server.port}")
//    private String port;
//
//    /* 协议，如：http、https[443] */
//    private String protocol;
//
//    /* 本项目所在服务器域名或IP */
//    private String serverDomain;

    /* 请求激活服务的URI */
//    private String actionPath;

    /*
     * 指定发送邮件的主机:smtp.qq.com(QQ)|smtp.163.com(网易)
     **/
    private String host;

    /**
     * 邮件的主题(即 标题)
     */
//    private String subject;

    private String senderEmail;

    /**
     * 发件人邮箱的授权码
     */
    private String authCode;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    @Override
    public String toString() {
        return "MailProperties{" +
//                "contextPath='" + contextPath + '\'' +
//                ", port='" + port + '\'' +
//                ", protocol='" + protocol + '\'' +
//                ", serverDomain='" + serverDomain + '\'' +
//                ", actionPath='" + actionPath + '\'' +
                ", host='" + host + '\'' +
//                ", subject='" + subject + '\'' +
                ", senderEmail='" + senderEmail + '\'' +
                ", authCode='" + authCode + '\'' +
                '}';
    }
}
