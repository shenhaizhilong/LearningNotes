package javavm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/18 22:29
 */
public class ThreadTest {

    public static void testBusyThread()
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    ;
            }
        }, "testBusyThread");

        thread.start();
    }

    public static void testLockThread(final Object object)
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object)
                {
                    try
                    {
                        object.wait(1000*60);
                    }catch (InterruptedException ex)
                    {
                        ex.printStackTrace();
                    }
                }



            }
        }, "testLockThread");
        thread.start();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        testBusyThread();
        reader.readLine();
        Object object = new Object();
        testLockThread(object);


    }
}
