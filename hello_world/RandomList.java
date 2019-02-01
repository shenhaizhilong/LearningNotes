package hello_world;

import java.util.*;

public class RandomList<T> {
    private ArrayList<T> array = new ArrayList<T>();
    private Random rand = new Random(47);

    public void add(T item) {
        array.add(item);
    }

    public void clear() {
        array.clear();
    }

    public T select() {
        return array.size() == 0 ? null : array.get(rand.nextInt(array.size()));

    }

    public static void main(String[] args) {
        RandomList<String> randomString = new RandomList<String>();
        for (String myStr : "just a test hello java!".split(" ")) {
            randomString.add(myStr);
        }
         //randomString.clear();
        for (int i = 0; i < 5; i++) {
            System.out.print(randomString.select() + ",");
        }
    }
}
