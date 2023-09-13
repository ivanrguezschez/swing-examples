package com.irs.swingexamples.mail;

import java.util.Properties;

/**
 * Clase que envia un email, se realiza autenticacion.
 *
 * @author IRS
 * @version 1.0.0, 23/03/2005
 */
public class MailAuthApp {

    static Properties propiedades = null;

    static {
        propiedades = new java.util.Properties();
        try {
            propiedades.load(ClassLoader.getSystemResourceAsStream("mail.properties"));
        } catch (java.io.IOException e) {
            System.out.println("No se encuentra el fichero de propiedades de mail: " + e.toString());
            System.exit(1);
        }
    }

    public MailAuthApp() {
        String subject = "Subject";

        System.out.println("Enviando Mail .....");

        boolean mailOK = MailUtil.sendMail(propiedades.getProperty("email.host"),
                propiedades.getProperty("email.from"),
                propiedades.getProperty("email.to"),
                subject,
                propiedades.getProperty("email.message"));

        System.out.println("Mail enviado: " + mailOK);
    }

    public static void main(String[] args) {
        new MailAuthApp();
    }
}
