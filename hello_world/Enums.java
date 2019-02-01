package hello_world;

import java.io.RandomAccessFile;
import java.util.Random;

/**
 * Created by shenhaizhilong on 4/30/2017.
 */
public class Enums
{
    private static Random random = new Random(47);
    public static <T> T random(T[] values)
    {
        return values[random.nextInt(values.length)];
    }
    public static <T extends Enum<T>> T random(Class<T> ec)
    {
        return random(ec.getEnumConstants());
    }

}
