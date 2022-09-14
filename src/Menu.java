import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Menu implements Runnable {
    ArrayList<String> history = new ArrayList<>();
    File historyFile = new File(Main.HISTORY_FILE_PATH);

    Menu(){
        run();
    }

    @Override
    public void run() {
        System.out.println("Womp! Womp!");
    }
}
