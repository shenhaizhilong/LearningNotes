package JavaIO;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLDemo1 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File("configuration.xml");
        Document document = builder.parse(file);
        Element root = document.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if(node instanceof Element)
            {
                Element entry = (Element)node;
                System.out.println(entry.getTagName());
                if(entry.getTagName().equals("menu"))
                {
                    NodeList items = entry.getChildNodes();
                    for (int j = 0; j < items.getLength(); j++) {
                        Node itemNode = items.item(j);
                        if(itemNode instanceof Element)
                        {
                            Element itemElement = (Element) itemNode;
                            String value = itemElement.getAttribute("id");
                            System.out.println(value);
//                            NamedNodeMap attributes = itemElement.getAttributes();
//                            for (int k = 0; k < attributes.getLength(); k++) {
//                                Node attribute = attributes.item(k);
//                                String name = attribute.getNodeName();
//                                String value = attribute.getNodeValue();
//                                System.out.println("name:" + name +",value:" + value);
//                            }
                        }
                    }
                }
            }
        }
    }
}
