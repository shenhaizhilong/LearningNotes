package javavm;

import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/21 23:09
 *
 * clean  the direct memory
 */
public class DirectByteBufferCleaner {
    public static void clean(final ByteBuffer byteBuffer)
    {
        if(byteBuffer == null)return;
        if(byteBuffer.isDirect())
        {
            ((DirectBuffer)byteBuffer).cleaner().clean();
        }
    }
}
