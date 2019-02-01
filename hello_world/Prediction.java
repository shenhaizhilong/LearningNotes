package hello_world;
import java.util.*;
/**
 * Created by shenhaizhilong on 4/25/2017.
 */
public class Prediction
{
    private static Random random = new Random(47);
    private boolean shadow = random.nextDouble() > 0.5;
    public String toString()
    {
        if(shadow)
        {
            return "Six more weeks of Winter!";
        }
        else return "Early Spring";
    }

}
