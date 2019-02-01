package JavaIO;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class StAXDemo {
    public static void main(String[] args) throws Exception {
        String urlString;
        if(args.length==0)
        {
            urlString = "http://www.w3c.org";
            System.out.println("Using:" + urlString);
        }else {
            urlString = args[0];
        }


            URL url = new URL(urlString);
            InputStream inputStream = url.openStream();
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(inputStream);
            while (reader.hasNext())
            {
                int event = reader.next();
                if(event == XMLStreamConstants.START_ELEMENT)
                {
                    if(reader.getLocalName().equals("a"))
                    {
                        String href = reader.getAttributeValue(null, "href");
                        if(href != null)
                        {
                            System.out.println(href);
                        }
                    }
                }
            }

        System.out.println(0xffffffff);

    }
}
