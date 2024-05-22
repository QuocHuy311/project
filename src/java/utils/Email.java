/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.DataHandler;
import javax.activation.DataSource;

/**
 *
 * @author minhl
 */
public class Email {
    
    static final String email = "HuyNVQHE172684@fpt.edu.vn";
    static final String password = "nuej mbff fmqe ibjk";
    
    public static boolean sendEmail(String to, String title, String content) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

//        Properties props = new Properties();
//        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
//        props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
        // Create Athenticator
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
            
        };

        // Create session
        Session session = Session.getInstance(properties, authenticator);

        // Create message
        MimeMessage message = new MimeMessage(session);
        
        try {

            //type content
            message.addHeader("Content-type", "text/HTML; charset=UTF-8");

            //from
            message.setFrom(email);

            //to
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            //subject email
            message.setSubject(title);

            //Day send
            message.setSentDate(new Date());

            //content
            message.setContent(content, "text/HTML; cconharset=UTF-8");

            //send email 
            Transport.send(message);
            System.out.println("Send email success");
            return true;
        } catch (Exception e) {
            System.out.println("Something wrong");
            e.printStackTrace();
            return false;
        }
    }
    
}
