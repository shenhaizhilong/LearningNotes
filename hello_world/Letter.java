package hello_world;

import java.util.function.Function;

/**
 * Created by shenhaizhilong on 7/2/2017.
 */
public class Letter
{
    public static String addHeader(String text)
    {
        return "From Raoul, Mario and Alan: " + text;
    }
    public static String addFooter(String text)
    {
        return text + " Kind regards";
    }
    public static String checkSpelling(String text)
    {
        return text.replaceAll("labda", "lambda");
    }


    public static void main(String[] args)
    {
        Function<String,String> addHeader = Letter::addHeader;
        Function<String,String> transformationPipeLine = addHeader.andThen(Letter::addFooter).andThen(Letter::checkSpelling);
        String text = transformationPipeLine.apply("tom labda labda");
        System.out.println(text);
    }
}
