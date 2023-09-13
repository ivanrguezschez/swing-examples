package com.irs.swingexamples.ftp;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Aplicacion cliente FTP.
 *
 * @author IRS
 * @version	1.0.0
 */
public class JFtp extends Frame {

    java.awt.FileDialog openFileDialog1;
    java.awt.List list_lfile;
    java.awt.List list_ldir;
    java.awt.List list_file;
    java.awt.List list_dir;
    java.awt.TextField text_ldir;
    java.awt.TextField text_dir;
    java.awt.Button button_open;
    java.awt.Button button_close;
    java.awt.Button button_exit;
    java.awt.Button button_up;
    java.awt.Button button_down;
    java.awt.TextArea ta_reply;

    Ftp ftp;
    String hostname;
    String username;
    String password;
    String local_dir;
    String local_separator;
    String local_dirlist[];
    long   local_dirsize[];
    String remote_dir;
    String remote_separator;
    String remote_dirlist[];
    long   remote_dirsize[];
    boolean haveConnection;

    /**
     * Constructor.
     */
    public JFtp() {
        haveConnection = false;

        setLayout(null);
        addNotify();
        //setSize(getInsets().left + getInsets().right + 446, getInsets().top + getInsets().bottom + 400);
        setSize(450, 450);
        setTitle("JFTP");

        list_lfile = new java.awt.List(0, false);
        list_lfile.reshape(insets().left + 12,insets().top + 168,160,110);
        list_lfile.setBackground(Color.white);
        add(list_lfile);
        list_file = new java.awt.List(0, false);
        list_file.reshape(insets().left + 252,insets().top + 168,160,110);
        list_file.setBackground(Color.white);
        add(list_file);
        list_ldir = new java.awt.List(0, false);
        list_ldir.reshape(insets().left + 12,insets().top + 96,160,71);
        list_ldir.setBackground(Color.white);
        add(list_ldir);
        list_dir = new java.awt.List(0, false);
        list_dir.reshape(insets().left + 252,insets().top + 96,160,71);
        list_dir.setBackground(Color.white);
        add(list_dir);

        text_ldir = new java.awt.TextField();
        text_ldir.reshape(insets().left + 12,insets().top + 62,180,36);
        add(text_ldir);
        text_dir = new java.awt.TextField();
        text_dir.reshape(insets().left + 252,insets().top + 62,180,36);
        add(text_dir);

        button_open = new java.awt.Button("Open");
        button_open.reshape(insets().left + 12,insets().top + 12,72,38);
        add(button_open);
        button_close = new java.awt.Button("Close");
        button_close.reshape(insets().left + 96,insets().top + 12,72,38);
        add(button_close);
        button_exit = new java.awt.Button("Exit");
        button_exit.reshape(insets().left + 180,insets().top + 12,72,38);
        add(button_exit);

        button_up = new java.awt.Button("->");
        button_up.reshape(insets().left + 204,insets().top + 120,36,36);
        add(button_up);
        button_down = new java.awt.Button("<-");
        button_down.reshape(insets().left + 204,insets().top + 180,36,36);
        add(button_down);

        button_up.disable();
        button_down.disable();
        button_close.disable();

        ta_reply = new java.awt.TextArea();
        ta_reply.reshape(insets().left + 12, insets().top + 300, 420, 100);
        ta_reply.setEditable(false);
        add(ta_reply);
    }

    public JFtp(String title) {
        this();
        setTitle(title);
    }

    public synchronized void show() {
        move(50, 50);
        super.show();
    }

    public boolean handleEvent(Event event) {
        if (event.id == Event.WINDOW_DESTROY) {
            hide();         // hide the Frame
            dispose();      // free the system resources
            System.exit(0); // close the application
            return true;
        }
        return super.handleEvent(event);
    }

    public boolean action(Event event, Object arg) {
        if (event.target instanceof Button) {
            String button_name = (String) arg;
            if(button_name.equals("Exit")) {
                close_connection();
                hide();
                dispose();
                System.exit(0);
            } else if (button_name.equals("Open")) {
                OpenConnectionDialog o = new OpenConnectionDialog(this, true);
                o.show();
            } else if (button_name.equals("Close")) {
                close_connection();
            } else if (button_name.equals("->")) {
                upload();
            } else if (button_name.equals("<-")) {
                download();
            }
        } else if (event.target instanceof java.awt.List) {
            if (event.target == list_ldir) {
                if (((String) arg).equals("..")) {
                    local_dir = local_dir.substring(
                            0, local_dir.lastIndexOf(local_separator));
                } else {
                    local_dir = local_dir + local_separator + (String) arg;
                }
                list_local_dir();
            } else if (event.target == list_dir) {
                ftp.cd((String) arg);
                list_remote_dir();
            }
        }
        return super.action(event, arg);
    }

    // ***********************************************
    // close connection
    // ***********************************************
    public void close_connection() {
        if (haveConnection) {
            text_dir.setText("");
            list_file.clear();
            list_dir.clear();

            button_close.disable();
            button_up.disable();
            button_down.disable();

            ftp.close_connection();
            haveConnection=false;
        }
    }

    // ***********************************************
    // open connection
    // ***********************************************
    public void open_connection() {
        ftp = new Ftp(hostname,username,password,remote_dir,ta_reply,text_dir);
        if (ftp.ftpSocket != null) {
            list_remote_dir();
            list_local_dir();

            button_close.enable();
            button_up.enable();
            button_down.enable();
            haveConnection=true;
        }
    }

    public static void main(String args[]) {
        JFtp j = new JFtp();
        j.init();
        j.show();
    }

    public void init() {
        local_dir = System.getProperty("user.dir");
        local_separator = System.getProperty("file.separator");

        list_local_dir();
        remote_separator = "/";
    }

    // ***********************************************
    // sort, sort a string array and return it
    // ***********************************************
    public String[] sort(String list[]) {
        String temp;

        for (int i = 0; i < list.length-1; i++) {
            for (int j = i+1; j < list.length; j++) {
                if ((list[i].compareTo(list[j])) > 0) {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        return list;
    }

    // *******************************************************
    // list local directory information
    // *******************************************************
    public void list_local_dir() {
        list_ldir.clear();
        list_lfile.clear();

        File file = new File(local_dir);
        if (!file.exists()) {
            local_dir = System.getProperty("user.dir");
            file = new File(local_dir);
        }

        if (local_dir != local_separator) {
            list_ldir.addItem("..");
        }

        text_ldir.setText(local_dir);
        local_dirlist = sort(file.list());
        local_dirsize = new long[local_dirlist.length];
        for (int i = 0; i < local_dirlist.length; i++) {
            File f = new File(local_dir +local_separator +local_dirlist[i]);

            local_dirsize[i] = f.length();
            if (f.isDirectory()) {
                list_ldir.addItem(local_dirlist[i]);
            } else {
                list_lfile.addItem(local_dirlist[i]);
            }
        }
    }

    // *******************************************************
    // list remote directory information
    // *******************************************************
    public void list_remote_dir() {
        String full_list[] = ftp.list();
        remote_dirlist = new String[full_list.length - 1];
        remote_dirsize = new long[full_list.length - 1];

        list_dir.clear();
        list_file.clear();

        if (!text_dir.getText().equals(remote_separator)) {
            list_dir.addItem("..");
        }

        for(int i = 1; i < full_list.length; i++) {
            if (full_list[i].length() > 54) {
                remote_dirlist[i-1] = full_list[i].substring(54);
                remote_dirsize[i-1] = Long.valueOf(
                        full_list[i].substring(32, 40).trim()).longValue();

                if (full_list[i].charAt(0) == 'd') {
                    if (!remote_dirlist[i-1].equals(".")
                            && !remote_dirlist[i-1].equals("..")) {
                        list_dir.addItem(remote_dirlist[i - 1]);
                    }
                } else {
                    list_file.addItem(remote_dirlist[i - 1]);
                }
            }
        }
    }

    // *******************************************************
    // get file size
    // *******************************************************
    public long get_local_size(String name) {
        int index=-1;
        for (int i = 0; i < local_dirlist.length; i++) {
            if (local_dirlist[i].equals(name)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            return local_dirsize[index];
        } else {
            return -1;
        }
    }

    public long get_remote_size(String name) {
        int index=-1;
        for (int i = 0; i < remote_dirlist.length; i++) {
            if (remote_dirlist[i].equals(name)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            return remote_dirsize[index];
        } else {
            return -1;
        }
    }

    /*
     * Metodos para el tratamiento del fichero de log's
     */
    public boolean check_ftp_log(String filename) {
        String line;
        boolean temp = false;
        try {
            FileInputStream fileIn = new FileInputStream("jftp_log.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(fileIn));
            while ((line = in.readLine()) != null && temp != true) {
                if (line.equals(filename)) {
                    temp = true;
                }
            }
            in.close();
            fileIn.close();
        } catch (IOException e) {
            System.err.println(e);
        }
        return temp;
    }

    public void write_ftp_log(String filename) {
        try {
            java.util.List list = new ArrayList();
            String line;

            FileInputStream fileIn = new FileInputStream("jftp_log.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(fileIn));
            while((line = in.readLine()) != null) {
                list.add(line);
            }
            in.close();
            fileIn.close();

            FileOutputStream fileOut = new FileOutputStream("jftp_log.txt");
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fileOut));
            for(int i = 0; i < list.size(); i++) {
                out.write(list.get(i).toString());
                out.newLine();
            }
            out.write(filename);
            out.newLine();
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void clear_ftp_log(String filename) {
        try {
            java.util.List list = new ArrayList();
            String line;

            FileInputStream fileIn = new FileInputStream("jftp_log.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(fileIn));
            while((line = in.readLine()) != null) {
                if(!line.equals(filename))
                    list.add(line);
            }
            in.close();
            fileIn.close();

            FileOutputStream fileOut = new FileOutputStream("jftp_log.txt");
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fileOut));
            for(int i = 0; i < list.size(); i++) {
                out.write(list.get(i).toString());
                out.newLine();
            }
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    /**
     * Metodo que realiza la bajada de documentos via FTP.
     */
    public void download() {
        String list[] = list_file.getSelectedItems();

        for (int i = 0; i < list.length; i++) {
            String rname = text_dir.getText() + remote_separator + list[i];
            String lname = local_dir + local_separator + list[i];
            long rsize = get_remote_size(list[i]);
            long lsize = get_local_size(list[i]);

            if (!check_ftp_log("GET " + rname + " " + rsize)
                    || lsize == -1 || lsize >= rsize) {
                write_ftp_log("GET " + rname + " " + rsize);

                if (lsize >= 0) {
                    (new File(local_dir + local_separator + list[i])).delete();
                }
                ftp.get(rname, lname, rsize);
            } else {
                System.out.println("Reget");
                ftp.reget(rname, lname, rsize, lsize);
            }
            clear_ftp_log("GET " + rname + " " + rsize);
        }
        list_local_dir();
    }

    /**
     * Metodo que realiza la subida de documentos via FTP.
     */
    public void upload() {
        String list[] = list_lfile.getSelectedItems();

        for (int i = 0; i < list.length; i++) {
            String rname = text_dir.getText() + remote_separator + list[i];
            String lname = local_dir + local_separator + list[i];
            long rsize = get_remote_size(list[i]);
            long lsize = get_local_size(list[i]);

            if (!check_ftp_log("PUT " + rname + " " + lsize)
                    || rsize == -1 || rsize >= lsize) {
                write_ftp_log("PUT " + rname + " " + lsize);

                //if(rsize >= 0)
                //   ftp.delete(rname);

                ftp.put(rname, lname, rsize );
            } else {
                System.out.println("Reput");
                ftp.reput(rname, lname, rsize, lsize);
            }
            clear_ftp_log("PUT " + rname + " " + lsize);
        }
        list_remote_dir();
    }
}
