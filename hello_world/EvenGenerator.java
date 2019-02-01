package hello_world;

/**
 * Created by shenhaizhilong on 5/1/2017.
 */
public class EvenGenerator extends IntGenerator
{
    private int currentEvenValue =0;
    public int next()
    {
        ++currentEvenValue;// Danger point here!
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args)
    {
        EvenChecker.test(new EvenGenerator());
    }
}
