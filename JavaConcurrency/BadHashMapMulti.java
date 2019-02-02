package JavaConcurrency;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/7 15:16
 */
public class BadHashMapMulti {
    private static Map<Integer,Integer> map = new HashMap<>();
    private static class Counter extends Thread
    {
        private int s;
        public Counter(int start)
        {
            this.s = start;
        }

        @Override
        public void run() {
            for (int i = s; i < 1000; i +=2) {
                map.put(i,i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter(0);
        Counter counter2 = new Counter(1);
        counter1.start();
        counter2.start();
        counter1.join();
        counter2.join();
        System.out.println(map.size());
    }
}
