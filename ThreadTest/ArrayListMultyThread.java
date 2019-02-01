package ThreadTest;

import java.util.ArrayList;


public class ArrayListMultyThread {
    public static ArrayList<Integer>  arrayList = new ArrayList<>(100);
    public static class AddThread implements Runnable
    {
        public synchronized void FillElement()
        {
            for (int i = 0; i < 10000; i++) {
                arrayList.add(i);
            }
        }
        @Override
        public void run()
        {
            FillElement();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        AddThread addThread = new AddThread();
        Thread t1 = new Thread(addThread);
        Thread t2 = new Thread(addThread);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(arrayList.size());
    }
}
