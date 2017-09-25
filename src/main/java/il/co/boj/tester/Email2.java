//package il.co.boj.tester;
//
//import lombok.extern.log4j.Log4j;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Date;
//import java.util.Optional;
//import java.util.Properties;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * Created by ofer on 07/09/17.
// */
//@Component
//@Log4j
//public class Email2 {
//
//
//    private Properties props = new Properties();
//    Authenticator auth       = null;
//    Session session    = null;
//    private final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
//
//    //--Mail server details---------------------------------------------------------------------------------------------------------------
////    @Value("${send.mail.active}")
//    private String sendMailActiveStr;
//    private boolean sendMailActive;
//
//
//
//    //-----------------------------------------------------------------------------------------------------------------
//    @PostConstruct
//    public void init(){
//        sendMailActive = Optional.ofNullable( true ).map((s)->Boolean.valueOf(s)).orElse(false);
////        log.debug("EmailUtil.init() - "
////                + "sendMailActive:[" + sendMailActive
////                + "], mailServerHost:[" + mailServerHost
////                + "], mailServerPort:[" + mailServerPort
////                + "], mailServerUser:[" + mailServerUser
////                + "], mailServerPassword:[" + mailServerPassword
////                + "], mailServerSsl:[" + mailServerSsl
////                + "], mailServerFromEmail:[" + mailServerFromEmail + "]");
//
////        if ( sendMailActive && mailServerHost == null ){
////            log.debug("EmailUtil.init() - mailServerHost should not be null when sendMailActive is true, check application.properties file. setting sendMailActive to false.");
////            sendMailActive = false;
////        }
////
////        if ( sendMailActive && mailServerPort == null ){
////            log.debug("EmailUtil.init() - mailServerPort should not be null when sendMailActive is true, check application.properties file. setting sendMailActive to false.");
////            sendMailActive = false;
////        }
////
////        if ( sendMailActive && mailServerUser == null ){
////            log.debug("EmailUtil.init() - mailServerUser should not be null when sendMailActive is true, check application.properties file. setting sendMailActive to false.");
////            sendMailActive = false;
////        }
////
////
////        if ( sendMailActive && mailServerPassword == null ){
////            log.debug("EmailUtil.init() - mailServerPassword should not be null when sendMailActive is true, check application.properties file. setting sendMailActive to false.");
////            sendMailActive = false;
////        }
//        //mailServerPassword =
////        Encryptor aes = null;
////        try {
////            aes = new Encryptor();
////            mailServerPassword = aes.decrypt(mailServerPassword);
////        } catch ( Exception e ) {
////            log.error("EmailUtil.init() - aes.decrypt for mailServerPassword - Exception:" + e.getMessage(), e);
////        }
////        log.debug("EmailUtil.init() - mailServerssap. " + mailServerPassword);
//
//
////        if ( sendMailActive && mailServerSsl == null ){
////            log.debug("EmailUtil.init() - mailServerSsl should not be null when sendMailActive is true, check application.properties file. setting sendMailActive to false.");
////            sendMailActive = false;
////        }
//
//
////        if ( sendMailActive && mailServerFromEmail == null ){
////            log.debug("EmailUtil.init() - mailServerFromEmail should not be null when sendMailActive is true, check application.properties file. setting sendMailActive to false.");
////            sendMailActive = false;
////        }
//
//        props.put("mail.smtp.host"               , "smtp.gmail.com"); // "smtp.gmail.com"); //SMTP Host
//        props.put("mail.smtp.socketFactory.port" , "465"); //"465"); //SSL Port
//        props.put("mail.smtp.port"               , "465"); //"465"); //SMTP Port
//        props.put("mail.smtp.auth"               , true); //"true"); //Enabling SMTP Authentication
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
//
//        auth = new Authenticator() {
//            //override the getPasswordAuthentication method
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("yoslev@gmail.com", "Q1Q1Q1Q1");
//            }
//        };
//        session = Session.getDefaultInstance(props, auth);
//        log.debug("EmailUtil.init() - init completed.");
//    }
//    //-----------------------------------------------------------------------------------------------------------------
//    /**
//     *
//     * FFB-222 - payment has to send mail when payment transaction fails or any other failure.
//     *
//     * @param toEmail
//     * @param subject
//     * @param body
//     * @return
//     */
//    public boolean sendEmail(String toEmail, String subject, String body) {
//
//        boolean wasEmailSent = false;
//
//        log.debug("EmailUtil.sendEmail() - toEmail:[" + toEmail + "], subject:[" + subject + "], body:[" + body + "], ");
//        if (sendMailActive == false){
//            log.debug("EmailUtil.sendEmail() - sendMailActive == false, skipping send mail.");
//            return false;
//        }
//        if (!validMailFormat(toEmail) ){
//            log.debug("EmailUtil.sendEmail() - invalid eMail Format toEmail:[" + toEmail + "], skipping send mail.");
//            return false;
//        }
//        try {
//            MimeMessage msg = new MimeMessage(session);
//            // set message headers
//            msg.addHeader("Content-type"             , "text/HTML; charset=UTF-8");
//            msg.addHeader("format"                   , "flowed");
//            msg.addHeader("Content-Transfer-Encoding", "8bit");
//
//            msg.setFrom(new InternetAddress("yoslev@gmail.com") ); //"no_reply@journaldev.com", "NoReply-JD"));
//
//            msg.setSubject   (subject, "UTF-8");
//            msg.setText      (body   , "UTF-8");
//            msg.setSentDate  (new Date());
//            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
//
//            log.debug("EmailUtil.sendEmail() - Message is ready");
//            Transport transport = session.getTransport("smtp");
//
////			transport.connect("smtp.gmail.com", "info@creditplace.co.il", "Q1Q1Q1Q1");
//            transport.connect("smtp.gmail.com", "info@creditplace.co.il", "Q1Q1Q1Q1");
//            try {
//                log.debug("EmailUtil.sendEmail() - calling transport.sendMessage()");
//                transport.sendMessage(msg, msg.getAllRecipients());
//                wasEmailSent  = true; // assume it was sent
//            }
//            catch (Exception err) {
//                wasEmailSent = false; // assume it's a fail
//            }
//            transport.close();
//            log.debug("EmailUtil.sendEmail() - Message was [" + (wasEmailSent ? "SUCCESSFULLY" : "NOT" )+ "] sent");
//        } catch (Exception e) {
//            log.error("EmailUtil.sendEmail() - Exception:[" + e.getMessage() + "] sent", e);
//        }
//        return wasEmailSent;
//    }
//    //-----------------------------------------------------------------------------------------------------------------
//    private boolean validMailFormat(String emailStr) {
//        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
//        return matcher.find();
//    }
//    //-----------------------------------------------------------------------------------------------------------------
//}
