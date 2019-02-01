package hello_world;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by shenhaizhilong on 7/8/2017.
 */
public class WordCounter
{
    private final int counter;
    private final boolean lastSpace;
    public WordCounter(int counter, boolean lastSpace)
    {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }
    public WordCounter accumulate(Character c)
    {
        if(Character.isWhitespace(c))
        {
            return lastSpace? this: new WordCounter(counter, true);
        }
        else {
            return lastSpace ? new WordCounter(counter+1, false): this;
        }

    }
    public WordCounter combine(WordCounter wordCounter)
    {
        return new WordCounter(counter+ wordCounter.counter, wordCounter.lastSpace);
    }
    public int getCounter()
    {
        return counter;
    }

    public static int countWords(Stream<Character> stream)
    {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
        return wordCounter.getCounter();
    }

    public static void main(String[] args)
    {
        final String sentence = " Nel    mezzo  del  cammin di nostra   vita " +
                "mi    ritrovai in una selva oscura" +
                " che la dritta via era      smarrita ";
        Stream<Character> stream = IntStream.range(0, sentence.length()).mapToObj(sentence::charAt);
        System.out.println("Found " + countWords(stream) + " words" );
    }
}
