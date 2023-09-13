package com.irs.swingexamples.mail;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Clase MailUtil clase de utilidad que realiza el envio de email's
 *
 * @author IRS
 * @version 1.0.0, 20/09/2004
 */
public class MailUtil {

    public static boolean sendMail(String host, String from, String to,
                                   String subject, String mensaje) {
        boolean resultado = true;
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.auth", "true");
            Session s = Session.getInstance(props,null);

            InternetAddress fromAddress = new InternetAddress(from);

            InternetAddress[] toAddress = new InternetAddress[1];
            toAddress[0] = new InternetAddress(to);

            MimeMessage message = new MimeMessage(s);
            message.setFrom(fromAddress);
            message.addRecipient(Message.RecipientType.TO, toAddress[0]);

            message.setSubject(subject);
            message.setText(mensaje);
            //Transport.send(message);

            Transport transport = s.getTransport("smtp");
            transport.connect(host, "usr", "pwd");
            transport.sendMessage(message, toAddress);

        } catch (Exception e) {
            System.out.println(e);
            resultado = false;
        }

        return resultado;
    }
}
