package JavaNetWorking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ReverseTest {

    public static void main(String[] args) {

        String[] iparray = {
                "61.135.169.125",
                "61.135.169.121",
                "125.39.52.26",
                "121.18.230.202",
                "125.39.1.187",
                "42.176.192.154",
                "124.163.204.171",
                "218.21.175.113",
                "101.23.128.21",
                "221.193.246.159"};

        InetAddress address;
        try
        {
            for (String ip :
                    iparray) {
                address = InetAddress.getByName(ip);
                System.out.println(address.getHostName());
                //System.out.println(address.getCanonicalHostName());
            }
        }catch (UnknownHostException ex)
        {
            ex.printStackTrace();
        }

    }
}
