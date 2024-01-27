package org.example.mailsend.controller;

import org.cups4j.*;
import org.example.mailsend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/common")
public class CommonController {

    private EmailService emailService;

    @Autowired
    public CommonController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/mailcode")
    public String getEmailCode(){
        String to = "3020468470@qq.com";
        String subject = "一条测试邮件";
        String content = "测试邮件内容";
        emailService.sendSimpleMail(to, subject, content);
        return "success";
    }

}
