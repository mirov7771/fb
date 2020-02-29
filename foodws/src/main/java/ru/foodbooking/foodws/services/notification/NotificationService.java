package ru.foodbooking.foodws.services.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.foodbooking.foodws.config.FBConfig;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private FBConfig fbConfig;

    public void sendNotification(String emailTo,String subject, String text) throws MailException
    {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(emailTo);
        mail.setSubject(subject);
        mail.setText(text);
        mail.setFrom(fbConfig.getMailUsername());

        javaMailSender.send(mail);
    }

}
