//package il.co.boj.tester;
//
//import lombok.extern.log4j.Log4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//import java.io.IOException;
//import java.util.Date;
//import java.util.Properties;
//
///**
// * Created by ofer on 07/09/17.
// */
//@Component
//@Log4j
//public class EmailSenderCopy {
//
//    @Autowired
//    EmailTesterConfig config;
//
//    public boolean sendEmailWithAttachments(String[] attachFiles)   {
//
//        boolean send = true;
//
//        //get details from properties
//
//        String host = config.getHost();
//        String port = config.getPort();
//        String toAddress = config.toAddress;
//        String subject = config.getSubject();
//        String message = config.getMessage();
//        final String userName = config.getUserName();
//        final String password = config.getPassword();
//
//        try {
//
//            // sets SMTP server properties
//            Properties properties = new Properties();
//            properties.put("mail.smtp.host", host);
////            properties.put("mail.smtp.port", port);
//            properties.put("mail.smtp.auth", "true");
//            properties.put("mail.smtp.starttls.enable", "true");
//            properties.put("mail.user", userName);
//            properties.put("mail.password", password);
//
//            properties.put("mail.active", "true");
//            properties.put("mail.server.ssl", "true");
////            properties.put(" mail.server.from", "yoslev@gmail.com");
//
//            properties.put("mail.smtp.port", "587");
//
//
//
//
//
//            // creates a new session with an authenticator
//            Authenticator auth = new Authenticator() {
//                public PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(userName, password);
//                }
//            };
//            Session session = Session.getInstance(properties, auth);
//            // creates a new e-mail message
//            Message msg = new MimeMessage(session);
//            msg.setFrom(new InternetAddress("yoslev@gmail.com"));
//            InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
//            msg.setRecipients(Message.RecipientType.TO, toAddresses);
//            msg.setSubject(subject);
//            msg.setSentDate(new Date());
//            // creates message part
//            MimeBodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setContent(message, "text/html");
//            // creates multi-part
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(messageBodyPart);
//            // adds attachments
//            if (attachFiles != null && attachFiles.length > 0) {
//                for (String filePath : attachFiles) {
//                    MimeBodyPart attachPart = new MimeBodyPart();
//                    try {
//                        attachPart.attachFile(filePath);
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                    multipart.addBodyPart(attachPart);
//                }
//            }
//            // sets the multi-part as e-mail's content
//            msg.setContent(multipart);
//            // sends the e-mail
//            Transport.send(msg);
//            log.debug("successfully sent Email");
//            return send;
//        }
//        catch (Exception e) {
//            send = false;
//            log.debug("Could not send Email. " + e.getMessage());
//            return send;
//        }
//
//    }
//
//    /**
//     * Test sending e-mail with attachments
//     */
////    public static void main(String[] args) {
////
////        EmailSender emailSender = new EmailSender();
////
////        // SMTP info
////        String host = "smtp.gmail.com"; // localhost
////        String port = "587";
////        String mailFrom = "your-email-address";
////        String password = "your-email-password";
////
////        // message info
////        String mailTo = "your-friend-email";
////        String subject = "New email with attachments";
////        String message = "I have some attachments for you.";
////
////        // attachments
////        String[] attachFiles = new String[3];
////        attachFiles[0] = "e:/Test/Picture.png";
////        attachFiles[1] = "e:/Test/Music.mp3";
////        attachFiles[2] = "e:/Test/Video.mp4";
////
////        // sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
////        // subject, message, attachFiles);
////        boolean send = emailSender.sendEmailWithAttachments(attachFiles);
////        if (send) {
////            System.out.println("Email sent.");
////        } else {
////            System.out.println("Could not send email.");
////        }
////
////    }
//}
