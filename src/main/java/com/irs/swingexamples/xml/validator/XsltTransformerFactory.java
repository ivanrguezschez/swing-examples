package com.irs.swingexamples.xml.validator;

/**
 * Clase factoria de transformaciones XSLT.
 *
 * @author IRS
 * @version 1.0.0, 20/01/2005
 */
public class XsltTransformerFactory {

    public static final int TRANSFORMADOR_PDF = 0;
    public static final int TRANSFORMADOR_HTML = 1;

    public static XsltTransformer getXsltTransformer(int type) {
        switch (type) {
            case XsltTransformerFactory.TRANSFORMADOR_PDF:
                return new PdfTransformer();
            case XsltTransformerFactory.TRANSFORMADOR_HTML:
                return new HtmlTransformer();
            default:
                return null;
        }
    }
}
