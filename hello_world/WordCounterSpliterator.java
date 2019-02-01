package hello_world;

import com.sun.istack.internal.NotNull;
import com.sun.org.apache.xerces.internal.impl.dv.dtd.NOTATIONDatatypeValidator;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by shenhaizhilong on 7/8/2017.
 */
public class WordCounterSpliterator implements Spliterator<Character>
{
    public static void main(String[] args)
    {
        final String sentence = " Nel    mezzo  del  cammin di nostra   vita " +
                "mi    ritrovai in una selva oscura" +
                " che la dritta via era      smarrita";
        Spliterator<Character> spliterator = new WordCounterSpliterator(sentence);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        System.out.println("Found " + WordCounter.countWords(stream) + " words");
        System.out.println();
    }

    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String string)
    {
        this.string = string;
    }
    @Override
    public boolean tryAdvance(Consumer<? super Character> action)
    {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit()
    {
        int currentSize = string.length() - currentChar;
        if (currentSize< 10)
        {
            // 返回null 表示要解析的string 已经足够小，可以顺序处理
            return null;
        }
        for(int splitPos = currentSize/2 + currentChar; splitPos < string.length(); splitPos++)
        {
            if (Character.isWhitespace(string.charAt(splitPos)))
            {
                Spliterator<Character> spliterator = new WordCounterSpliterator(string.substring(currentChar, splitPos));
                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;

    }

    @Override
    public long estimateSize()
    {
        return string.length() -currentChar;
    }

    @Override
    public int characteristics()
    {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }


}
