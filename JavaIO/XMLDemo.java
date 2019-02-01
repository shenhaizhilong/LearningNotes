package JavaIO;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLDemo {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        File file = new File("font.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setIgnoringElementContentWhitespace(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        Element root = document.getDocumentElement();
        NodeList children = root.getChildNodes();

        Element nameElement = (Element)children.item(0);
        Element sizeElement = (Element)children.item(1);
        System.out.println("tagName:"+ nameElement.getTagName());
        System.out.println("sizeName:" + sizeElement.getTagName());

    }
}
