package lection19.lesson19;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class StudentErrorHandler extends DefaultHandler {

    private Logger logger = (Logger) LogManager.getLogger("valid");

    public StudentErrorHandler(String log) {
        var fileAppender =
                FileAppender.newBuilder().setName("file")
                        .setLayout(PatternLayout.newBuilder()
                                .withPattern("[%d][%-5.-5p][%-14.-14c{1}:%4L] %-22.-22M - %m%n")
                                .build())
                        .withFileName(log)
                        .build();

        logger.addAppender(fileAppender);
    }

    @Override
    public void warning(SAXParseException e) {
        logger.warn(getLineAddress(e) + "-" + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) {
        logger.error(getLineAddress(e) + " - " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        logger.fatal(getLineAddress(e) + " - " + e.getMessage());
    }

    private String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}

