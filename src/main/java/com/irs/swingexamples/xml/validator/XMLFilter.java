package com.irs.swingexamples.xml.validator;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Filtro de archivos xml.
 *
 * @author IRS
 * @version 1.0.0, 20/01/2005
 */
public class XMLFilter extends FileFilter {

    public static final String XML = "xml";
    public static final String XSD = "xsd";
    public static final String XSLT = "xsl";
    public static final String HTM = "htm";
    public static final String HTML = "html";
    public static final String PDF = "pdf";

    private String type;

    public XMLFilter(String type) {
        super();
        this.type = type;
    }

    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = getExtension(f);
        if (extension != null) {
            if (type.equals(XMLFilter.XML)) {
                if (extension.equals(XMLFilter.XML)) {
                    return true;
                } else {
                    return false;
                }
            } else if (type.equals(XMLFilter.XSD)) {
                if (extension.equals(XMLFilter.XSD)) {
                    return true;
                } else {
                    return false;
                }
            } else if (type.equals(XMLFilter.XSLT)) {
                if (extension.equals(XMLFilter.XSLT)) {
                    return true;
                } else {
                    return false;
                }
            } else if (type.equals(XMLFilter.PDF)) {
                if (extension.equals(XMLFilter.PDF)) {
                    return true;
                } else {
                    return false;
                }
            } else if (type.equals(XMLFilter.HTM) || type.equals(XMLFilter.HTML)) {
                if (extension.equals(XMLFilter.HTM) || extension.equals(XMLFilter.HTML)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public String getDescription() {
        if(type.equals(XMLFilter.XML)) {
            return "Ficheros xml";
        } else if(type.equals(XMLFilter.XSD)) {
            return "Ficheros xsd";
        } else if(type.equals(XMLFilter.XSLT)) {
            return "Ficheros xslt";
        } else if(type.equals(XMLFilter.PDF)) {
            return "Ficheros pdf";
        } else if(type.equals(XMLFilter.HTM) || type.equals(XMLFilter.HTML)) {
            return "Ficheros html";
        }
        return "";
    }

    private String getExtension(File f) {
        String ext = null;
        String str = f.getName();
        int i = str.lastIndexOf('.');

        if (i > 0 && i < str.length() - 1) {
            ext = str.substring(i+1).toLowerCase();
        }

        return ext;
    }
}
