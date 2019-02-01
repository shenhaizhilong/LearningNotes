package hello_world;

/**
 * Created by shenhaizhilong on 4/26/2017.
 */
public class StringHashCode
{
    public static void main(String[] args)
    {
        String[] hellos = "hello hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());

    }
    @Override
    public String toString()
    {
        return super.toString();
    }
}
