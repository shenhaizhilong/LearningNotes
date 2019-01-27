package DesignPattern.Iterator;

import java.util.Iterator;
import java.util.Random;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/27 15:44
 */
public class MySet implements Iterable<Integer> {
    private Integer[] vals;
    private Random random;
    public MySet(int size)
    {
        random = new Random();
        vals = new Integer[size];
        for (int i = 0; i < size; i++) {
            vals[i] = Integer.valueOf(random.nextInt(100));
        }
    }
    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator<>(this.vals);
    }

    public static class MyIterator<T> implements Iterator<T>
    {
        private T[] items;
        private int idx = 0;
        public MyIterator(T[] items)
        {
            this.items = items;
        }
        @Override
        public T next() {
            if(idx == items.length)throw new ArrayIndexOutOfBoundsException();
            return items[idx++];
        }

        @Override
        public boolean hasNext() {
            return idx < items.length;
        }
    }

    public static void main(String[] args) {
        MySet mySet = new MySet(20);
        Iterator<Integer> iterator = mySet.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

    }
}
