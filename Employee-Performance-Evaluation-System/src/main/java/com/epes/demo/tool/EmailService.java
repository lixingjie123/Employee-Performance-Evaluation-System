package cn.ces.tool;



import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.Properties;
import java.util.Random;

/**
 * Description:
 * Date: 2018/7/2
 * Time: 5:45
 */

public final class EmailService {
    private static Random random = new Random();


    /**
     * @param formAddress 邮件地址
     * @param username 发送方账户
     * @param password 发送方密码
     * @param toAddress 收件地址
     * @param subject   邮件主题
     * @param context   邮件内容
     * @throws Exception
     */
    public static void sendEmail(String formAddress, String username, String password, String toAddress, String subject, String context)throws Exception{
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        // props.setProperty("mail.smtp.port", "465")
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        // 表示SMTP发送邮件，需要进行身份验证
        properties.setProperty("mail.transport.protocol", "smtp");
        // 设置传输协议
        properties.put("mail.smtp.auth", "true");
        // QQ邮箱的服务器 如果是企业邮箱或者其他邮箱得更换该服务器地址
        properties.put("mail.smtp.host", "smtp.qq.com");

        Session session = Session.getInstance(properties);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(MimeUtility.encodeText(formAddress)));
        message.setSubject(subject);
        message.setText(context);
        //获取发送对象
        Transport transport = session.getTransport();

        //发送邮件的用户名和密码
        transport.connect(username,password);
        Address[] addresses = {new InternetAddress(toAddress)};
        transport.sendMessage(message,addresses);
    }

    /**
     * 数字随机码
     * @return
     */
    public static String getCode(){
        StringBuilder code = new StringBuilder();
        for (int i=0;i<6;i++){
            int r = random.nextInt(9);
            code.append(r);
        }
        return code.toString();
    }
}
