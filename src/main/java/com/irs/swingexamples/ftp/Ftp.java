package com.irs.swingexamples.ftp;

import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

/**
 * Clase para la gestión de conxiones y envios por FTP.
 *
 * @author IRS
 * @version	1.0.0
 */
public class Ftp extends Thread {

    final int CONTROL_PORT = 21;
    final int BLOCK_SIZE = 8192;  // 8MB

    Socket ftpSocket = null;
    DataInputStream is = null;
    DataOutputStream os = null;
    ServerSocket dataSocket = null;

    String hostname;
    String hostOutput;
    String userCommand;
    get_reply g;

    /**
     * Constructor.
     */
    public Ftp(String hname, String uname, String upass,
               String rdir, TextArea ta_gui, TextField tf_gui) {
        hostname = hname;

        open_connection();
        login(uname, upass);
        cd(rdir);

        g = new get_reply(is, ta_gui, tf_gui);
        g.start();
    }

    public void run() {
    }

    /**
     * Metodo que abre la conexion.
     */
    public void open_connection(){
        try {
            ftpSocket = new Socket(hostname, CONTROL_PORT);
            os = new DataOutputStream(ftpSocket.getOutputStream());
            is = new DataInputStream(ftpSocket.getInputStream());
        } catch (UnknownHostException e) {
            System.err.println("Host not found");
        } catch (IOException e) {
            System.out.println("I/O failed on the connection 1");
        }
    }

    /**
     * Metodo que gestiona el puerto
     */
    public void port() {
        try {
            dataSocket = new ServerSocket(0);
            byte[] addrbytes = null;
            short addrshorts[] = new short[4];

            addrbytes = dataSocket.getInetAddress().getLocalHost().getAddress();

            for(int i = 0; i <= 3; i++) {
                addrshorts[i] = (short)addrbytes[i];
                if (addrshorts[i] < 0) {
                    addrshorts[i] += (short) 256;
                }
            }

            int localport = dataSocket.getLocalPort();
            String command = "PORT " +
                    addrshorts[0] + "," +
                    addrshorts[1] + "," +
                    addrshorts[2] + "," +
                    addrshorts[3] + "," +
                    ((localport & 0xff00) >> 8) + "," +
                    (localport & 0x00ff);

            os.writeBytes(command);
            os.writeByte('\n');
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host");
        } catch (IOException e) {
            System.err.println("I/O failed on the connection 2");
        }
    }

    /**
     * Metodo que realiza el login contra el servidor.
     * @param name Nombre del usuario.
     * @param pass Contraseña del usuario.
     */
    public void login(String name, String pass) {
        if (ftpSocket != null && os != null && is != null) {
            try {
                os.writeBytes("user " + name);
                os.writeByte('\n');
                os.writeBytes("pass " + pass);
                os.writeByte('\n');
            } catch (IOException e) {
                System.err.println("I/O failed on the connection 3");
            }
        }
    }

    /**
     * Metodo que ejecuta el comando GET de FTP.
     * @param rfname Nombre del fichero remoto.
     * @param lfname Nombre del fichero local.
     * @param rsize Tamaño del fichero remoto.
     */
    public void get(String rfname, String lfname, long rsize) {
        try {
            type("I");
            port();
            os.writeBytes("RETR " + rfname);
            os.writeByte('\n');

            int count=0;
            int amount=0;
            byte b[] = new byte[BLOCK_SIZE];
            Socket clientSocket = dataSocket.accept();
            InputStream data_is = clientSocket.getInputStream();

            RandomAccessFile file_out = new RandomAccessFile(lfname, "rw");
            while((amount = data_is.read(b)) != -1) {
                count += amount;
                file_out.write(b, 0, amount);
            }
            file_out.close();
            //System.out.println(count + " bytes transfered");

            data_is.close();
            clientSocket.close();
            dataSocket.close();
            type("A");
        } catch (IOException e) {
            System.err.println("I/O failed on the connection 4");
        }
    }

    /**
     * Metodo que ejecuta el comando REGET de FTP.
     * @param rfname Nombre del fichero remoto.
     * @param lfname Nombre del fichero local.
     * @param rsize Tamaño del fichero remoto.
     * @param lsize Tamaño del fichero local.
     */
    public void reget(String rfname, String lfname, long rsize, long lsize) {
        try{
            type("I");
            port();

            os.writeBytes("REST " + lsize);
            os.writeByte('\n');
            os.writeBytes("RETR " + rfname);
            os.writeByte('\n');

            int count=0;
            int amount=0;
            byte b[] = new byte[BLOCK_SIZE];
            Socket clientSocket = dataSocket.accept();
            InputStream data_is = clientSocket.getInputStream();

            RandomAccessFile file_out = new RandomAccessFile(lfname, "rw");
            file_out.seek(lsize);
            while((amount = data_is.read(b)) != -1) {
                count += amount;
                file_out.write(b, 0, amount);
            }
            file_out.close();
            //System.out.println(count + " bytes transfered");

            data_is.close();
            clientSocket.close();
            dataSocket.close();
            type("A");
        } catch (IOException e) {
            System.err.println("I/O failed on the connection 4");
        }
    }

    /**
     * Metodo que ejecuta el comando PUT de FTP.
     * @param rfname Nombre del fichero remoto.
     * @param lfname Nombre del fichero local.
     * @param lsize Tamaño del fichero local.
     */
    public void put(String rfname, String lfname, long lszie) {
        try{
            type("I");
            port();
            //os.writeBytes("STOR " + rfname);
            os.writeBytes("APPE " + rfname);
            os.writeByte('\n');

            int count=0;
            int amount=0;
            byte b[] = new byte[BLOCK_SIZE];
            Socket clientSocket = dataSocket.accept();
            OutputStream data_os = clientSocket.getOutputStream();

            RandomAccessFile file_in = new RandomAccessFile(lfname, "r");
            while((amount = file_in.read(b)) != -1) {
                //try{ sleep(20); }
                //catch (InterruptedException e) { System.out.println("?");}

                count += amount;
                data_os.write(b, 0, amount);
            }
            file_in.close();
            //System.out.println(count + " bytes transfered");

            data_os.close();
            clientSocket.close();
            dataSocket.close();
            type("A");
        } catch (IOException e) {
            System.err.println("I/O failed on the connection 4 (put)");
        }
    }

    /**
     * Metodo que ejecuta el comando REPUT de FTP.
     * @param rfname Nombre del fichero remoto.
     * @param lfname Nombre del fichero local.
     * @param rsize Tamaño del fichero remoto.
     * @param lsize Tamaño del fichero local.
     */
    public void reput(String rfname, String lfname, long rsize, long lsize) {
        try{
            type("I");
            port();
            os.writeBytes("APPE " + rfname);
            os.writeByte('\n');

            int count=0;
            int amount=0;
            byte b[] = new byte[BLOCK_SIZE];
            Socket clientSocket = dataSocket.accept();
            OutputStream data_os = clientSocket.getOutputStream();

            RandomAccessFile file_in = new RandomAccessFile(lfname, "r");
            file_in.seek(rsize);
            while((amount = file_in.read(b)) != -1) {
                //try{ sleep(20); }
                //catch (InterruptedException e) { System.out.println("?");}

                count += amount;
                data_os.write(b, 0, amount);
            }
            file_in.close();
            System.out.println(count + " bytes transfered");

            data_os.close();
            clientSocket.close();
            dataSocket.close();
            type("A");
        } catch (IOException e) {
            System.err.println("I/O failed on the connection 4 (put)");
        }
    }

    /**
     * Metodo que ejecuta el comando CD de FTP.
     * @param dir Nombre del directorio base.
     */
    public void cd(String dir) {
        try {
            os.writeBytes("CWD " + dir);
            os.writeByte('\n');
            pwd();
        } catch (IOException e) {
            System.err.println("I/O failed on the connection 5");
        }
    }

    /**
     * Metodo que ejecuta el comando LIST de FTP.
     * @return Una lista de los ficheros listados.
     */
    public String[] list() {
        Vector list=new Vector();

        try {
            String line;

            port();
            os.writeBytes("LIST");
            os.writeByte('\n');

            Socket clientSocket = dataSocket.accept();
            DataInputStream data_is = new DataInputStream(clientSocket.getInputStream());
            while((line = data_is.readLine()) != null) {
                list.addElement(line);
            }

            data_is.close();
            clientSocket.close();
            dataSocket.close();
            pwd();
        } catch (IOException e) {
            System.err.println("I/O failed on the connection 7");
        }

        String list2[] = new String[list.size()];
        for(int i=0; i<list2.length; i++) {
            list2[i] = list.elementAt(i).toString();
        }
        return list2;
    }

    /**
     * Metodo que ejecuta el comando TYPE de FTP.
     * @param code Tipo de transferencia.
     */
    public void type(String code) {
        try {
            os.writeBytes("TYPE " + code);
            os.writeByte('\n');
        } catch (IOException e) {
            System.err.println("I/O failed on the connection 8");
        }
    }

    // ************************************
    // get_1reply (get one line reply message)
    // ************************************
    public void get_1reply() {
        try {
            hostOutput = is.readLine();
        } catch (IOException e) {
            System.err.println("I/O failed on the connection 9");
        }
    }

    /**
     * Metodo que cierra la conexion FTP.
     */
    public void close_connection() {
        try {
            os.writeBytes("QUIT");
            os.writeByte('\n');
            os.close();
            is.close();
            ftpSocket.close();
        } catch (IOException e) {
            System.err.println("I/O failed on the connection 6");
        }
    }

    /**
     * Metodo que apaga la sesion FTP.
     */
    public void shutdown() {
        try {
            os.close();
            is.close();
            ftpSocket.close();
        } catch (IOException e) {
            System.err.println("I/O failed on the connection 10");
        }
    }

    /**
     * Metodo que ejecuta el comando PWD de FTP.
     */
    public void pwd() {
        try {
            os.writeBytes("PWD");
            os.writeByte('\n');
        } catch (IOException e) {
            System.err.println("I/O failed on the connection 11");
        }
    }

    /**
     * Metodo que ejecuta el comando DELETE de FTP.
     * @param filename Nombre del fichero a eliminar.
     */
    public void delete(String filename) {
        try {
            os.writeBytes("DELE " + filename);
            os.writeByte('\n');
        } catch (IOException e) {
            System.err.println("I/O failed on the connection 11");
        }
    }

}

// ************************************
// get_reply
//    get reply message using threads
//    update (TextArea) and (TextFiled)
//    automatic.
// ************************************
class get_reply extends Thread {
    String hostOutput;
    TextArea hostreply;
    TextField hostdir;
    Ftp ftp;
    DataInputStream reply=null;

    public get_reply(DataInputStream is, TextArea ta, TextField tf) {
        reply = is;
        hostreply = ta;
        hostdir = tf;
    }
    public void run() {
        try {
            while((hostOutput = reply.readLine()) != null) {
                hostreply.appendText(hostOutput + '\n');
                if(hostOutput.substring(0,3).equals("257")) {
                    int start=0;
                    int end=0;

                    start = hostOutput.indexOf('"');
                    end = hostOutput.indexOf('"', start + 1);
                    hostdir.setText(hostOutput.substring(start + 1, end));
                }
            }
        } catch (IOException e) {
            // System.err.println("I/O failed on the connection 12");
        }
    }
}
