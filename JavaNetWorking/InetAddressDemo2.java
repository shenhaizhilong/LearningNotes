package JavaNetWorking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo2 {
    public static void main(String[] args) {

        String[] urlArray = {"www.baidu.com", "www.qq.com", "www.azure.cn"};
        InetAddress[] inetAddresses;
        try
        {
            for (String url :
                    urlArray) {
                inetAddresses = InetAddress.getAllByName(url);
                for (InetAddress add :
                        inetAddresses) {
                    //System.out.println(add.getCanonicalHostName());
                    //System.out.println(add.getHostName());
                    System.out.println(add.getHostAddress());
                    System.out.println("Version:" + AddressTests.getVersion(add));
                }

            }
        }catch (UnknownHostException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
