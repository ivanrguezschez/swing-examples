package com.irs.swingexamples.xml.validator;

import java.util.Iterator;
import java.util.Stack;

/**
 * Clase padre abstracta de una transformación XSLT.
 *
 * @author IRS
 * @version 1.0.0, 20/01/2005
 */
public abstract class XsltTransformer {

    protected boolean valid;
    protected Stack errors = null;

    public abstract void transformar(String xml, String xsl, String out);

    public XsltTransformer() {
        super();
        valid = true;
        errors = new Stack();
    }

    public boolean isValid() {
        return valid;
    }

    // If this handler is used to parse more than one document,
    // its initial state needs to be reset between parses.
    public void reset() {
        // Por defecto consideramos valido el documento xml
        valid = true;
    }

    public Stack getErrors() { return errors; }

    public void showErrors() {
        for (Iterator it = errors.iterator(); it.hasNext(); ) {
            System.out.println((String)it.next());
        }
    }
}
