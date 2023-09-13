package com.irs.swingexamples.mail;

import javax.mail.*;
import java.util.Properties;

/**
 * Clase que obtiene los correos electrónicos de la bandeja de entrada, se realiza autenticacion.
 *
 * @author IRS
 * @version 1.0.0, 20/09/2004
 */
public class Fetch {
    public static void main(String args[]) throws Exception {
        //String host = args[0];
        String host = "pop.correo.yahoo.es";

        // Get system properties
        Properties props = System.getProperties();
        props.put("mail.pop3.host", host);

        // Setup authentication, get session
        Authenticator auth = new PopupAuthenticator();
        Session session = Session.getDefaultInstance(props, auth);

        // Get the store
        Store store = session.getStore("pop3");
        store.connect();

        // Get folder
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        // Get directory
        Message message[] = folder.getMessages();
        for (int i=0, n=message.length; i<n; i++) {
            System.out.println(i + ": "
                    + message[i].getFrom()[0]
                    + "\t" + message[i].getSubject());
            String content =
                    message[i].getContent().toString();
            if (content.length() > 200) {
                content = content.substring(0, 200);
            }
            System.out.print(content);
        }

        // Close connection
        folder.close(false);
        store.close();
        System.exit(0);
    }
}
