package tn.esprit.spring.service;

import java.util.Properties;

import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import java.io.File;
import java.util.Properties;
@Service
public class EmailService {

    public boolean sendEmail(String subject, String message, String to)
    {
        boolean foo = false; // Set the false, default variable "foo", we will allow it after sending code process email

        String senderEmail = "mohamedsouguir123456789@gmail.com"; // your gmail email id
        String senderPassword = "azerty1997$$"; // your gmail id password

        // Properties class enables us to connect to the host SMTP server
        Properties properties = new Properties();

        // Setting necessary information for object property

        // Setup host and mail server
        properties.put("mail.smtp.auth", "true"); // enable authentication
        properties.put("mail.smtp.starttls.enable", "true"); // enable TLS-protected connection
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Mention the SMTP server address. Here Gmail's SMTP server is being used to send email
        properties.put("mail.smtp.port", "587"); // 587 is TLS port number
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // get the session object and pass username and password
        Session session = Session.getDefaultInstance(properties, new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication(){

                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {

            MimeMessage msg = new MimeMessage(session); // Create a default MimeMessage object for compose the message

            msg.setFrom(new InternetAddress(senderEmail)); // adding sender email id to msg object

            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // adding recipient to msg object

            msg.setSubject(subject); // adding subject to msg object
            msg.setText(message); // adding text to msg object

            Transport.send(msg); // Transport class send the message using send() method
            System.out.println("Email Sent Wtih Attachment Successfully...");

            foo = true; // Set the "foo" variable to true after successfully sending emails

        }catch(Exception e){

            System.out.println("EmailService File Error"+ e);
        }

        return foo; // and return foo variable
    }
    

    public boolean sendWithAttachment(String subject, String message, String to)
    {
        boolean foo = false; // Set the false, default variable "foo", we will allow it after sending code process email

        String senderEmail = "         "; // your gmail email id
        String senderPassword = "         "; // your gmail id password

        //Properties class enables us to connect to the host SMTP server
        Properties properties = new Properties();

        //Setting necessary information for object property

        //Setup host and mail server
        properties.put("mail.smtp.auth", "true"); // enable authentication
        properties.put("mail.smtp.starttls.enable", "true"); // enable TLS-protected connection
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Mention the SMTP server address. Here Gmail's SMTP server is being used to send email
        properties.put("mail.smtp.port", "587"); // 587 is TLS port number
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // get the session object and pass username and password
        Session session = Session.getDefaultInstance(properties, new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication(){

                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {

            MimeMessage msg = new MimeMessage(session); // Create a default MimeMessage object for compose the message

            msg.setFrom(new InternetAddress(senderEmail)); // adding sender email id to msg object

            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // adding recipient to msg object

            msg.setSubject(subject); // adding subject to msg object

            // sets file location
            String path = "C:\\Users\\WSI\\Desktop\\donnee.pdf";

            MimeMultipart mimeMultipart = new MimeMultipart(); // create MimeMultipart object

            MimeBodyPart textMime = new MimeBodyPart(); // create first MimeBodyPart object textMime for containing the message

            MimeBodyPart fileMime = new MimeBodyPart(); //create second MimeBodyPart object fileMime for containing the file

            textMime.setText(message); //sets message to textMime object

            File file = new File(path); //Initialize the File and Move Path variable
            fileMime.attachFile(file); //attach file to fileMime object

            //The mimeMmultipart adds textMime and fileMime to the
            mimeMultipart.addBodyPart(textMime);
            mimeMultipart.addBodyPart(fileMime);

            msg.setContent(mimeMultipart); // Sets the mimeMultipart the contents of the msg

            Transport.send(msg); // Transport class send the message using send() method
            System.out.println("Email Sent With Attachment Successfully...");

            foo = true; // Set the "foo" variable to true after successfully sending emails with attchment

        }catch(Exception e){

            System.out.println("EmailService File Error"+ e);
        }

        return foo; // and return foo variable
    }
/*
    public boolean sendHtmlTemplate(String subject, String message, String to)
    {
        boolean foo = false; // Set the false, default variable "foo", we will allow it after sending code process email

        String senderEmail = "sirine.kraiem@esprit.tn"; // your gmail email id
        String senderPassword = "193JFT4593"; // your gmail id password


        //Properties class enables us to connect to the host SMTP server
        Properties properties = new Properties();

        // Setting necessary information for object property

        // Setup host and mail server
        properties.put("mail.smtp.starttls.enable", "true"); // enable TLS-protected connection
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Mention the SMTP server address. Here Gmail's SMTP server is being used to send email
        properties.put("mail.smtp.port", "587"); // 587 is TLS port number
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // get the session object and pass username and password
        Session session = Session.getDefaultInstance(properties, new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication(){

                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {

            MimeMessage msg = new MimeMessage(session); // Create a default MimeMessage object for compose the message

            MimeMessageHelper helper = new MimeMessageHelper(msg, true); // create MimeMessageHelper class

            helper.setFrom(new InternetAddress(senderEmail)); // adding sender email id to helper object

            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); //adding recipient to msg object

            helper.setSubject(subject); // adding subject to helper object

            MimeMultipart mimeMultipart = new MimeMultipart(); // create MimeMultipart object

            MimeBodyPart textMime = new MimeBodyPart(); // create first MimeBodyPart object textMime for containing the message

            MimeBodyPart messageBodyPart = new MimeBodyPart(); // create second MimeBodyPart object messageBodyPart for containing the html format data

            textMime.setText(message); // sets message to textMime object

            // create message within html format tag and assign to the content variable
            String content = "<br><br><b>Hi friends</b>,<br><i>This email is HTML template style</i>";

            // sets html format content to the messageBodyPart object
            messageBodyPart.setContent(content,"text/html; charset=utf-8");

            //The mimeMultipart adds textMime and messageBodypart to the
            mimeMultipart.addBodyPart(textMime);
            mimeMultipart.addBodyPart(messageBodyPart);

            msg.setContent(mimeMultipart); // Set the mimeMultipart the contents of the msg

            Transport.send(msg); // Transport class send the message using send() method
            System.out.println("Email Sent With HTML Template Style Successfully...");

            foo = true; // Set the "foo" variable to true after successfully sending emails

        }catch(Exception e){

            System.out.println("EmailService File Error"+ e);
        }

        return foo; //and return foo variable
    }

    public boolean sendEmailInlineImage(String subject, String message, String to)
    {
        boolean foo = false; // Set the false, default variable "foo", we will allow it after sending code process email

        String senderEmail = ""; // your gmail email id
        String senderPassword = ""; // your gmail id password

        //Properties class enables us to connect to the host SMTP server
        Properties properties = new Properties();

        // Setting necessary information for object property

        // Setup host and mail server
        properties.put("mail.smtp.auth", "true"); //enable authentication
        properties.put("mail.smtp.starttls.enable", "true"); // enable TLS-protected connection
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Mention the SMTP server address. Here Gmail's SMTP server is being used to send email
        properties.put("mail.smtp.port", "587"); // 587 is TLS port number
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // get the session object and pass username and password
        Session session = Session.getDefaultInstance(properties, new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication(){

                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {

            MimeMessage msg = new MimeMessage(session); //compose the message (multi media, text )

            MimeMessageHelper helper = new MimeMessageHelper(msg, true); // create MimeMessageHelper class

            helper.setFrom(new InternetAddress(senderEmail)); //adding sender email id to helper object

            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); //adding recipient to msg object

            helper.setSubject(subject); // adding subject to helper object

            // sets file path location
            String path = "C:\\Users\\Public\\Downloads\\onlyxcodes-logo.png";

            MimeMultipart mimeMultipart = new MimeMultipart(); // create MimeMultipart object

            MimeBodyPart textMime = new MimeBodyPart(); // create first MimeBodyPart object textMime for containing the message

            MimeBodyPart messageBodyPart = new MimeBodyPart(); // create second MimeBodyPart object messageBodyPart for containing the html format message

            MimeBodyPart fileMime = new MimeBodyPart(); // create third MimeBodyPart object fileMime for containing the file

            textMime.setText(message); // sets message to the textMime object

            // create message within html format tag and assign to the content variable
            String content = "<br><b>Hi friends</b>,<br><i>look at this nice logo :)</i>"
            + "<br><img src='cid:image52'/><br><b>Your Regards Onlyxcodes</b>";

            // sets html format content to the messageBodyPart object
            messageBodyPart.setContent(content,"text/html; charset=utf-8");

            File file = new File(path); //Initialize the File and Move Path variable
            fileMime.attachFile(file); //attach file to fileMime object

            helper.addInline("image52", file); //inline image attach using addInline() method

            //The mimeMultipart adds textMime, messageBodypart and fileMime to the
            mimeMultipart.addBodyPart(textMime);
            mimeMultipart.addBodyPart(messageBodyPart);
            mimeMultipart.addBodyPart(fileMime);

            msg.setContent(mimeMultipart); // Set the mimeMultipart the contents of the msg

            Transport.send(msg); // Transport class send the message using send() method
            System.out.println("Email Sent With Inline Image Successfully...");

            foo = true; // Set the "foo" variable to true after successfully sending emails with attchment

        }catch(Exception e){

            System.out.println("EmailService File Error"+ e);
        }

        return foo; //and return foo variable
    }*/
}
