package com.irs.swingexamples.xml.validator;

import org.apache.xerces.parsers.SAXParser;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.*;
import java.util.Iterator;
import java.util.Stack;

public class XmlSchemaValidator extends DefaultHandler {
    static final String FEATURE_VALIDATION =
            "http://xml.org/sax/features/validation";

    static final String FEATURE_SCHEMA_VALIDATION =
            "http://apache.org/xml/features/validation/schema";

    static final String FEATURE_SCHEMA_CHECKING =
            "http://apache.org/xml/features/validation/schema-full-checking";

    static final String PROPERTY_SCHEMA_LOCAL =
            "http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation";

    static final String PROPERTY_SCHEMA_REMOTE =
            "http://apache.org/xml/properties/schema/external-schemaLocation";

    static final int SCHEMA_LOCAL = 0;
    static final int SCHEMA_REMOTE = 1;

    private int typeSchema;
    private boolean valid;
    private Stack errors = null;

    public XmlSchemaValidator() {
        super();
        // Por defecto consideramos el schema local
        typeSchema = XmlSchemaValidator.SCHEMA_LOCAL;
        // Por defecto consideramos valido el documento xml
        valid = true;
        errors = new Stack();
    }

    public XmlSchemaValidator(int type) {
        super();
        typeSchema = type;
        // Por defecto consideramos valido el documento xml
        valid = true;
        errors = new Stack();
    }


    public void validate(InputStream xml, String xsdFileName) {
        SAXParser parser = new SAXParser();

        try {
            parser.setFeature(XmlSchemaValidator.FEATURE_VALIDATION, true);
            parser.setFeature(XmlSchemaValidator.FEATURE_SCHEMA_VALIDATION, true);
            parser.setFeature(XmlSchemaValidator.FEATURE_SCHEMA_CHECKING, true);

            switch (typeSchema) {
                case XmlSchemaValidator.SCHEMA_LOCAL:
                    parser.setProperty(XmlSchemaValidator.PROPERTY_SCHEMA_LOCAL, xsdFileName);
                    break;
                case XmlSchemaValidator.SCHEMA_REMOTE:
                    parser.setProperty(XmlSchemaValidator.PROPERTY_SCHEMA_REMOTE, xsdFileName);
                    break;
                default:
                    break;
            }

            parser.setErrorHandler(this);
            parser.parse(new InputSource(xml));
            // Documento valido
        } catch (SAXNotSupportedException e) {
            errors.add(e.toString());
            valid = false;
        } catch (SAXNotRecognizedException e) {
            errors.add(e.toString());
            valid = false;
        } catch (SAXException e) {
            errors.add("No se puede crear el documento.");
            valid = false;
        } catch (IOException e) {
            errors.add("No se puede leer el fichero.");
            valid = false;
        }
    }


    public void validate(String xmlFileName, String xsdFileName) {
        try {
            validate(new FileInputStream(xmlFileName), xsdFileName);
        } catch(FileNotFoundException e) {
            errors.add("No se puede leer el fichero.");
            valid = false;
        }
		/*
		SAXParser parser = new SAXParser();

		try {
			parser.setFeature(XmlSchemaValidator.FEATURE_VALIDATION, true);
			parser.setFeature(XmlSchemaValidator.FEATURE_SCHEMA_VALIDATION, true);
			parser.setFeature(XmlSchemaValidator.FEATURE_SCHEMA_CHECKING, true);

			switch (typeSchema) {
				case XmlSchemaValidator.SCHEMA_LOCAL:
					parser.setProperty(XmlSchemaValidator.PROPERTY_SCHEMA_LOCAL, xsdFileName);
					break;
				case XmlSchemaValidator.SCHEMA_REMOTE:
					parser.setProperty(XmlSchemaValidator.PROPERTY_SCHEMA_REMOTE, xsdFileName);
					break;
				default:
					break;
			}

			parser.setErrorHandler(this);
			parser.parse(xmlFileName);
			// Documento valido
		} catch (SAXNotSupportedException e) {
			errors.add(e.toString());
			valid = false;
		} catch (SAXNotRecognizedException e) {
			errors.add(e.toString());
			valid = false;
		} catch (SAXException e) {
			errors.add("No se puede crear el documento.");
			valid = false;
		} catch (IOException e) {
			errors.add("No se puede leer el fichero.");
			valid = false;
		}
		*/
    }

    public void validate(File xmlFile, File xsdFile) {
        validate(xmlFile.getAbsolutePath(), xsdFile.getAbsolutePath());
    }

    public int getTypeSchema() {
        return typeSchema;
    }

    public void setTypeSchema(int type) {
        typeSchema = type;
    }

    public boolean isValid() {
        return valid;
    }

    // If this handler is used to parse more than one document,
    // its initial state needs to be reset between parses.
    public void reset() {
        // Por defecto consideramos el schema local
        typeSchema = XmlSchemaValidator.SCHEMA_LOCAL;
        // Por defecto consideramos valido el documento xml
        valid = true;
    }

    public Stack getErrors() { return errors; }

    public void showErrors() {
        for (Iterator it = errors.iterator(); it.hasNext(); ) {
            System.out.println((String)it.next());
        }
    }

    /* ********************************************************** */
    /* Implementacion de los metodos de la interface ErrorHandler */
    /* ********************************************************** */

    public void error(SAXParseException e) throws SAXException {
        valid = false;
        errors.add("Error en linea " + e.getLineNumber() + ", columna " + e.getColumnNumber() + ": " + e.getMessage());
    }

    public void fatalError(SAXParseException e) throws SAXException {
        valid = false;
        errors.add("Error en linea " + e.getLineNumber() + ", columna " + e.getColumnNumber() + ": " + e.getMessage());
    }

    public void warning(SAXParseException e) throws SAXException {
        valid = false;
        errors.add("Error en linea " + e.getLineNumber() + ", columna " + e.getColumnNumber() + ": " + e.getMessage());
    }
}
