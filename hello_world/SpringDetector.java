package hello_world;
import com.sun.scenario.effect.impl.prism.PrDrawable;

import java.lang.reflect.*;
import java.util.*;
/**
 * Created by shenhaizhilong on 4/25/2017.
 */
public class SpringDetector
{
    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception
    {
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog,Prediction> map = new HashMap<>();
        for (int i=0; i< 10; i++)
        {
            map.put(ghog.newInstance(i), new Prediction());
        }
        System.out.println("map = " + map);
        Groundhog gh = ghog.newInstance(3);
        System.out.println("Looking up prediction for " + gh);
        if(map.containsKey(gh))
        {
            System.out.println(map.get(gh));
        }
        else
        {
            System.out.println("Key not found:" + gh);
        }

    }
    public static void main(String[] args) throws Exception
    {
        detectSpring(Groundhog.class);
    }
}
