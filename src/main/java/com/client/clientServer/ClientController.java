package com.client.clientServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;
import java.util.logging.Logger;

@RestController
public class ClientController {
    Logger logger = Logger.getLogger(ClientController.class.getName());
    @Autowired
    private MailServiceClass mailServiceClass;
//    @Autowired
//    private RestTemplate restTemplate;

//    @GetMapping("/print")
//    public String data() {
//        logger.info("client server info message");
//        String data = restTemplate.getForObject("http://localhost:8080/user/hello", String.class);
//        return data;
//    }

    @RequestMapping("/sendmail")
    public String sendmail() {
        logger.info("client server info mail message");
        mailServiceClass.verifyCode();
        return "GMAIL Sent Successfully";
    }

    @RequestMapping("/sendfile")
    public String sendfile() throws AddressException, MessagingException, IOException {
        logger.info("file sent message");
        mailServiceClass.sendFile();
        return "file sent to aforementioned";
    }
}