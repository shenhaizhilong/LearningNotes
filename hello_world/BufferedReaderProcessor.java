package hello_world;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by shenhaizhilong on 5/5/2017.
 */
public interface BufferedReaderProcessor
{
    String process(BufferedReader bufferedReader) throws IOException;
}
