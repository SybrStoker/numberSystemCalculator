import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Parser {
    public String parseString(Document doc, String necessaryTagName){
        String body = "";
        String tagName;
        Element element;
        NodeList tags = doc.getElementsByTagName("string");

        for(int i = 0; i < tags.getLength(); i++){
            element = (Element) tags.item(i);
            tagName = element.getAttribute("name");

            if(tagName.equals(necessaryTagName)) {

                body = element.getTextContent();
                break;
            }
        }
        return body;
    }
}
