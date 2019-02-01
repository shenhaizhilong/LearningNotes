package JavaIO;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {

        String host = "www.baidu.com";
        try {
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress address :
                    addresses) {
                System.out.println(address);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            InetAddress localHostAddress = InetAddress.getLocalHost();
            System.out.println(localHostAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
