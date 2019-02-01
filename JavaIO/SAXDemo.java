package JavaIO;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.net.URL;

public class SAXDemo {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, Exception {

        String pageUrl =null;
        if(args.length ==0)
        {
            pageUrl = "http://www.w3c.org";
        }else {
            pageUrl = args[0];
        }
        System.out.println("Using:" + pageUrl);

        DefaultHandler handler = new DefaultHandler()
        {

            public void startElement(String nameSpaceUrl, String lName, String qName, Attributes attributes)
            {
                if(lName.equalsIgnoreCase("a") && attributes!=null)
                {
                    for (int i = 0; i < attributes.getLength(); i++) {
                        String name = attributes.getLocalName(i);
                        if(name.equalsIgnoreCase("href"))
                        {
                            String link = attributes.getValue(i);
                            if(link.startsWith("https://www"))
                            {
                                System.out.println(link);
                            }
                        }
                    }
                }
            }
        };

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        SAXParser parser = factory.newSAXParser();
        try (InputStream in = new URL(pageUrl).openStream()) {
            parser.parse(in, handler);
        }





    }
}
