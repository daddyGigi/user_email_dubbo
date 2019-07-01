package com.qf.email_service_send;

import com.qf.email.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailServiceSendApplicationTests {
    @Autowired
    private JavaMailSender javaMailSender;
    @Test
    public void contextLoads() {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        try {
            //发送方邮箱
            mimeMessageHelper.setFrom("xlgfwb@sina.cn");
            //收件人邮箱
            mimeMessageHelper.addTo("1349663361@qq.com","幸运用户");
            //设置标题
            mimeMessageHelper.setSubject("艾欧里亚官方邮箱");
            //设置内容
            mimeMessageHelper.setText("<h2>亲爱的召唤师： 您好！</h2><br/><span style=\"display:block;text-indent:2em;\">欢迎注册艾欧里亚召唤师身份，您的验证码是</span>"+ Utils.verifyCode(),true);
            mimeMessageHelper.setSentDate(new Date());

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
