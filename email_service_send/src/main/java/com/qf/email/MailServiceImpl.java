package com.qf.email;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by  .Life on 2019/06/29/0029 12:57
 */
@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public String  sendEmail(String email) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        String code = Utils.verifyCode();

        try {
            //发送方邮箱
            mimeMessageHelper.setFrom("xlgfwb@sina.cn");
            //收件人邮箱
            mimeMessageHelper.addTo(email,"幸运用户");
            //设置标题
            mimeMessageHelper.setSubject("艾欧里亚官方邮箱");
            //设置内容
            mimeMessageHelper.setText("<h2>亲爱的召唤师： 您好！</h2><br/><span style=\"display:block;text-indent:2em;\">欢迎注册艾欧里亚召唤师，您的验证码是</span>"+code,true);
            mimeMessageHelper.setSentDate(new Date());

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return code;
    }

}
