package hello_world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by shenhaizhilong on 5/1/2017.
 */
public class IDETest
{
    public IDETest()
    {
    }

    @Override
    public String toString()
    {
        return "IDETest{}";
    }


    public static void main(String[] args)
    {
        ArrayList<String> arrayList = null;
        try {
            arrayList = new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        arrayList.addAll(Arrays.asList(" hi java, i am a programmer".split(" ")));
        for (int i = 0; i < arrayList.size(); i++) {
            String s =  arrayList.get(i);
            System.out.println(s);
        }

        if (true) {
            Pattern clear_stuff = Pattern.compile(("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{3,4}"));
        }

        StringBuffer buffer = new StringBuffer("hello,world!");
        int a = (int) 10.0;
        System.out.println(a);


    }
}
