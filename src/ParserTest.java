import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    private Parser parser = new Parser();
    private Document doc;

    @BeforeEach
    void setUp() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = factory.newDocumentBuilder();
        doc = db.parse(new File(Main.FILE_NAME));
    }

    @Test
    void parseForWelcome_message(){
        assertEquals("This program converts numbers from one number system to another." ,
                parser.parseString(doc, "welcome_message"));
    }

    @Test
    void parseForWrong_message(){
        assertEquals("" , parser.parseString(doc, "wrong_message"));
    }
}