package JavaNetWorking;


import java.net.URI;
import java.net.URISyntaxException;

public class URIDemo {

    public static void main(String[] args) {

        try
        {
            URI u  = new URI("http://www.azure.cn/index.aspx?id=100");
            System.out.println(u.getPath());
            System.out.println(u.getAuthority());
            System.out.println(u.getHost());
            System.out.println(u.getPort());
            System.out.println(u.getScheme());
            System.out.println(u.getUserInfo());
            System.out.println(u.getQuery());
            System.out.println(u.getFragment());

        }catch (URISyntaxException ex)
        {
            ex.printStackTrace();
        }
    }
}
