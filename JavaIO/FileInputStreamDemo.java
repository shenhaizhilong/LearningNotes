package JavaIO;

import java.io.*;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {

        String filename = "employee.dat";
        System.out.println(System.getProperty("user.dir"));
        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filename)))
        {
            for (int i = 0; i < 2000; i++) {
                dataOutputStream.writeInt(i);
            }
            dataOutputStream.writeUTF("电脑");
        }

       try(DataInputStream dataInputStream = new DataInputStream( new FileInputStream(filename)))
       {
           for (int i = 0; i < 2000; i++) {
               System.out.println(dataInputStream.readInt());

           }
           System.out.println(dataInputStream.readUTF());
       }

       //use the cache

        try(DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream(filename))))
        {
            for (int i = 0; i < 2000; i++) {
                System.out.println(din.readInt());
            }
            System.out.println(din.readUTF());
        }

    }
}
