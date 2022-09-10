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
    Parser parser = new Parser();
    Document doc;
    DocumentBuilder db;

    //Warning! Always add/remove new values into the list if any of value files was changed
    protected String[] listOfAllValues = {"main_menu", "converter_menu", "algebra_menu", "settings_menu",
            "choose_lan_menu", "enter_number_message", "enter_base_message", "result_message",
            "enter_first_number_message", "enter_second_number_message", "welcome_message"};

    //never run this one as a test. This method is created to call it inside of child classes
    void allValuesAreInTheXmlFile() {
        for (String s : listOfAllValues) {
            assertFalse(parser.parseString(doc, s).isBlank());
        }
    }

    static class ParseEnTest extends ParserTest implements TestTemplate{

        @Override
        @BeforeEach
        public void setUp() throws ParserConfigurationException, IOException, SAXException {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            db = factory.newDocumentBuilder();
            doc = db.parse(new File(Main.FILE_NAME));
        }


        @Override
        @Test
        public void parseForValue() {
            assertEquals("Enter a number to convert",
                    parser.parseString(doc, "enter_number_message"));
        }

        @Override
        @Test
        public void parseForWrongMessage() {
            assertEquals("" , parser.parseString(doc, "wrong_message"));
        }

        @Override
        @Test
        public void checkAllTagsExist() {
            super.allValuesAreInTheXmlFile();
        }

    }

    static class ParseRuTest extends ParserTest implements TestTemplate{

        @Override
        @BeforeEach
        public void setUp() throws ParserConfigurationException, IOException, SAXException {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            db = factory.newDocumentBuilder();
            doc = db.parse(new File(Main.FILE_NAME_RU));
        }

        @Override
        @Test
        public void parseForValue() {
            assertEquals("Введите второе число",
                    parser.parseString(doc, "enter_second_number_message"));
        }

        @Override
        @Test
        public void parseForWrongMessage() {
            assertEquals("" , parser.parseString(doc, "wrong_message"));
        }

        @Override
        @Test
        public void checkAllTagsExist() {
            super.allValuesAreInTheXmlFile();
        }
    }

    static class ParseDeTest extends ParserTest implements TestTemplate{

        @Override
        @BeforeEach
        public void setUp() throws ParserConfigurationException, IOException, SAXException {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            db = factory.newDocumentBuilder();
            doc = db.parse(new File(Main.FILE_NAME_DE));
        }

        @Override
        @Test
        public void parseForValue() {
            assertEquals("Geben Sie eine Basis der Zahl ein",
                    parser.parseString(doc, "enter_base_message"));
        }

        @Override
        @Test
        public void parseForWrongMessage() {
            assertEquals("" , parser.parseString(doc, "wrong_message"));
        }

        @Override
        @Test
        public void checkAllTagsExist() {
            super.allValuesAreInTheXmlFile();
        }
    }
}

