package com.client.clientServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;

@Service
public class MailServiceClass {
    @Autowired
    private JavaMailSender javaMailSender;

    public void verifyCode() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("shankarsmtpexample@gmail.com");
        message.setTo("shankarsmtpexample@gmail.com");
//        message.setCc("shankarkj439@gmail.com");
        message.setBcc("shankarkj439@gmail.com");
//        message.setSentDate(31.11.2021);
        message.setSubject("Verification mail");
        message.setText("Hai this is me SHANKAR, this message is from spring boot application");
        javaMailSender.send(message);
    }

    public void sendFile() throws MessagingException, IOException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo("shankarsmtpexample@gmail.com");
        helper.setSubject("Verification of File");
        helper.setText("<h1>This is the message as HTML format and see the attached file</h1>", true);
        FileSystemResource resource = new FileSystemResource(new File("C:\\Users\\shank\\Pictures\\Screenshots\\Screenshot11.png"));
        helper.addAttachment("Screenshot11.png", resource);
        javaMailSender.send(message);
    }
}
