package cn.johnnyzen.util.mail;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2019/4/22  10:04:55
 * @Description:
 * + 必填选项
 *  + reciverEmail
 *  + subject
 *  + mailContent
 * + Demo[发送注册激活码邮件]
 *   mailUtil.setReciverEmail(email);//设置收件人邮箱
 *   mailUtil.setSubject("用户注册");
 *   mailUtil.setMailContent(MailContentService.generateMailContentOfUserAccountActivateByActivateCode(user.getActivateCode()));//设置激活码
 *   new Thread(mailUtil).start();//保存成功则通过线程的方式给用户发送一封邮件
 */

@Component
public class MailUtil implements Runnable {
    @Autowired
    private MailProperties mailProperties;

    private String reciverEmail = null;// 收件人邮箱

    /**
     * 格式类别默认： HTML ("text/html;charset=UTF-8")
     */
    private String mailContent = null;// 邮件内容

    private String subject = null;//邮件主题

    public MailUtil(){}

    public MailUtil(String reciverEmail) {
        this();
        this.reciverEmail = reciverEmail;
    }

    public void setReciverEmail(String reciverEmail){
        this.reciverEmail = reciverEmail;
    }

    /**
     * 仅当 reciverEmail 和 activateCode配置完成，方可运行成功
     */
    public void run() {
        if(this.getReciverEmail() == null){
            throw new RuntimeException("[MailUtil.run] reciverEmail is null!");
        }
        if(this.getSubject() == null){
            throw new RuntimeException("[MailUtil.run] subject is null!");
        }
        if(this.getMailContent() == null){
            throw new RuntimeException("[MailUtil.run] mailContent is null!");
        }
        // 1.创建连接对象javax.mail.Session
        // 2.创建邮件对象 javax.mail.Message
        // 3.发送一封激活邮件
        String from = mailProperties.getSenderEmail();// 发件人电子邮箱
        String host = mailProperties.getHost(); // 指定发送邮件的主机smtp.qq.com(QQ)|smtp.163.com(网易)

        Properties properties = System.getProperties();// 获取系统属性
        properties.setProperty("mail.smtp.host", host);// 设置邮件服务器
        properties.setProperty("mail.smtp.auth", "true");// 打开认证

        try {
            //QQ邮箱需要下面这段代码，163邮箱不需要
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);

            // 1.获取默认session对象
            Session session =
                    Session.getDefaultInstance(properties, new Authenticator() {
                        public PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(
                                    mailProperties.getSenderEmail(),
                                    mailProperties.getAuthCode()); // 发件人邮箱账号、授权码
                        }
                    });

            // 2.创建邮件对象
            Message message = new MimeMessage(session);
            // 2.1设置发件人
            message.setFrom(new InternetAddress(from));
            // 2.2设置接收人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(reciverEmail));
            // 2.3设置邮件主题
            message.setSubject(this.getSubject());
            // 2.4设置邮件内容
            message.setContent(this.getMailContent(), "text/html;charset=UTF-8");
            // 3.发送邮件
            Transport.send(message);
            System.out.println("[MailUtil] 邮件成功发送!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public MailProperties getMailProperties() {
        return mailProperties;
    }

    public void setMailProperties(MailProperties mailProperties) {
        this.mailProperties = mailProperties;
    }

    public String getReciverEmail() {
        return reciverEmail;
    }
}