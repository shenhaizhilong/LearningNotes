package hello_world;

/**
 * Created by shenhaizhilong on 4/17/2017.
 */
import  java.util.*;
public class GenericVarargs
{
    public  static <T> List<T> makeList(T ... args)
    {
        List<T> list = new ArrayList<>();
        for (T item :
                args) {
            list.add(item);
        }
        return list;
    }

    public  static  void main(String[] args)
    {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
        ls = makeList("ABCDEFGHIJKLMN".split(""));
        System.out.println(ls);

    }
}
