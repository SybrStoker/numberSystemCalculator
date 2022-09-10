import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface TestTemplate {

    void setUp() throws ParserConfigurationException, IOException, SAXException;

    void parseForValue();

    void parseForWrongMessage();

    void checkAllTagsExist();
}
