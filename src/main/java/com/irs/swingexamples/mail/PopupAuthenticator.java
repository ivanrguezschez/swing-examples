package com.irs.swingexamples.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.swing.*;
import java.util.StringTokenizer;

/**
 * Popup para autenticarse introduciendo el usuario y la contraseña.
 *
 * @author IRS
 * @version 1.0.0, 20/09/2004
 */
public class PopupAuthenticator extends Authenticator {

    public PasswordAuthentication getPasswordAuthentication() {
        String username, password;

        String result = JOptionPane.showInputDialog("Enter 'username,password'");

        StringTokenizer st = new StringTokenizer(result, ",");
        username = st.nextToken();
        password = st.nextToken();

        return new PasswordAuthentication(username, password);
    }
}
