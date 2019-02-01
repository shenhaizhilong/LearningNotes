package JavaIO;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class XPathDemo {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        File file = new File("configuration.xml");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(file);
        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();
        String userName = xPath.evaluate("/configuration/database/username", document);
        String password = xPath.evaluate("/configuration/database/password",document);
        System.out.println(userName + ", " + password);

        //NodeList nodes = (NodeList)xPath.evaluate("/gridbag/row[1]", document, XPathConstants.NODESET);
        int height = ((Number) xPath.evaluate("/configuration/window/height", document, XPathConstants.NUMBER)).intValue();
        int width = ((Number) xPath.evaluate("/configuration/window/width", document, XPathConstants.NUMBER)).intValue();
        NodeList list = (NodeList)xPath.evaluate("/configuration/menu/item", document, XPathConstants.NODESET);
        for (int i = 0; i < list.getLength(); i++) {
            System.out.println(list.item(i).getTextContent());
        }
        System.out.println("height:" + height +",width:" + width);
    }
}
