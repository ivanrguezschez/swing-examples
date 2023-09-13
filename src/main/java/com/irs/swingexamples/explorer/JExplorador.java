package com.irs.swingexamples.explorer;

import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

/**
 * Clase que construye un explorador de archivos basado en Java Swing.
 *
 * @author IRS
 * @version 1.0.0
 */
public class JExplorador extends JFrame {

    public static final ImageIcon ICONO_ORDENADOR = new ImageIcon("./src/main/resources/computer.gif");
    public static final ImageIcon ICONO_DISCO = new ImageIcon("./src/main/resources/disk.gif");
    public static final ImageIcon ICONO_CARPETA = new ImageIcon("./src/main/resources/folder.gif");
    public static final ImageIcon ICONO_CARPETAABIERTA = new ImageIcon("./src/main/resources/expandedfolder.gif");

    protected JTree m_tree;
    protected DefaultTreeModel m_model;
    protected JTextField m_display;

    public JExplorador() {
        super("JExplorador");
        setSize(400,300);

        DefaultMutableTreeNode top = new DefaultMutableTreeNode(new IconData(ICONO_ORDENADOR, null, "Ordenador"));

        DefaultMutableTreeNode node;
        File[] roots = File.listRoots();
        for(int k=0; k<roots.length; k++) {
            node = new DefaultMutableTreeNode(new IconData(ICONO_DISCO, null, new FileNode(roots[k])));
            top.add(node);
            node.add(new DefaultMutableTreeNode(new Boolean(true)));
        }

        m_model = new DefaultTreeModel(top);
        m_tree = new JTree(m_model);
        m_tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        m_tree.putClientProperty("JTree.lineStyle", "Angled");
        TreeCellRenderer renderer = new IconCellRenderer();
        m_tree.setCellRenderer(renderer);
        m_tree.addTreeExpansionListener(new DirExpansionListener());
        m_tree.addTreeSelectionListener(new DirSelectionListener());
        m_tree.setShowsRootHandles(true);
        m_tree.setEditable(false);

        JScrollPane s = new JScrollPane();
        s.getViewport().add(m_tree);
        getContentPane().add(s, BorderLayout.CENTER);

        m_display = new JTextField();
        m_display.setEditable(false);
        getContentPane().add(m_display, BorderLayout.NORTH);

        WindowListener wndCloser = new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);

        setVisible(true);
    }

    DefaultMutableTreeNode getTreeNode(TreePath path) {
        return (DefaultMutableTreeNode) (path.getLastPathComponent());
    }

    FileNode getFileNode(DefaultMutableTreeNode node) {
        if(node == null)
            return null;
        Object obj = node.getUserObject();
        if(obj instanceof IconData)
            obj = ((IconData)obj).getObject();
        if(obj instanceof FileNode)
            return (FileNode)obj;
        else
            return null;
    }

    class DirExpansionListener implements TreeExpansionListener {
        public void treeExpanded(TreeExpansionEvent event) {
            final DefaultMutableTreeNode node = getTreeNode(event.getPath());
            final FileNode fnode = getFileNode(node);

            Thread runner = new Thread() {
                public void run() {
                    if (fnode != null && fnode.expand(node)) {
                        Runnable runnable = new Runnable() {
                            public void run() {
                                m_model.reload(node);
                            }
                        };
                        SwingUtilities.invokeLater(runnable);
                    }
                }
            };
            runner.start();
        }

        public void treeCollapsed(TreeExpansionEvent event) {}
    }

    class DirSelectionListener implements TreeSelectionListener {
        public void valueChanged(TreeSelectionEvent event) {
            DefaultMutableTreeNode node = getTreeNode(event.getPath());
            FileNode fnode = getFileNode(node);
            if (fnode != null) {
                m_display.setText(fnode.getFile().getAbsolutePath());
            } else {
                m_display.setText("");
            }
        }
    }

    public static void main(String argv[]) {
        new JExplorador();
    }
}
