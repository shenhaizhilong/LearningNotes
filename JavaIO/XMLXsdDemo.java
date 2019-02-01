package JavaIO;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLXsdDemo {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/shcemalanguage";
        final String W3C_XML_SCHEMA = "http://www.w3c.org/2001/XMLSchema";
        File file = new File("XSDDemo.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
        factory.setIgnoringElementContentWhitespace(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document  document = builder.parse(file);

        NodeList children = document.getChildNodes();
    }
}
