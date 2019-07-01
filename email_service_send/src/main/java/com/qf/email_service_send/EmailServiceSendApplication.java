package com.qf.email_service_send;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
@DubboComponentScan("com.qf.email")
public class EmailServiceSendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailServiceSendApplication.class, args);
    }

}
