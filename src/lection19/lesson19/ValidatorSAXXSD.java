package lection19.lesson19;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorSAXXSD {
    public static void main(String[] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "data/students.xml";
        String schemaName = "data/students.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);

            Validator validator = schema.newValidator();

            Source source = new StreamSource(fileName);
            StudentErrorHandler studentErrorHandler = new StudentErrorHandler("logs/log.txt");
            validator.setErrorHandler(studentErrorHandler);
            validator.validate(source);

            System.out.println(fileName + " is valid");
        } catch (SAXException e) {
            System.err.print("validation " + fileName + " is not valid because " + e.getMessage());
        } catch (IOException e) {
            System.err.print(fileName + " is not valid because " + e.getMessage());
        }
    }
}
