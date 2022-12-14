package lection19.lesson19;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class ValidatorSAX {
    public static void main(String[] args) {
        String filename = "data/students.xml";
        String schemaName = "data/students.xsd";
        String logName = "logs/log.txt";
        Schema schema;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;

        SchemaFactory factory = SchemaFactory.newInstance(language);

        try {
            schema = factory.newSchema(new File(schemaName));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);

            SAXParser parser = spf.newSAXParser();
            parser.parse(filename, new StudentErrorHandler(logName));
            System.out.println(filename + " is valid: " + parser.isValidating());
            System.out.println(filename + " is valid");
        } catch (SAXException e) {
            System.err.println(filename + " SAX error: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.err.println(filename + " config error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
