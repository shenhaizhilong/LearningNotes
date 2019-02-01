package hello_world; /**
 * Created by shenhaizhilong on 4/19/2017.
 */

import java.util.*;
class StringAddress
{
    private String s;
    public StringAddress(String s){this.s = s;}
    public String toString()
    {
        return super.toString() + " " + s;
    }
}
public class FillingLists
{
    public static void main(String[] args)
    {
        List<StringAddress> myList = new ArrayList<>(Collections.nCopies(4, new StringAddress("hello,world!")));
        System.out.println(myList);
        Collections.fill(myList, new StringAddress("world!"));
        System.out.println(myList);
    }
}
