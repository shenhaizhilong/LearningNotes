package suggestions151;

import java.io.*;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/25 18:36
 */
public class SerializationUtils {

    public static void writeObject(Serializable obj, String filename) throws IOException
    {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            out.writeObject(obj);
        }
    }

    public static Object readObject(String filename) throws IOException, ClassNotFoundException
    {
        Object obj;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename)))
        {
            obj = inputStream.readObject();
        }

        return obj;
    }
}
