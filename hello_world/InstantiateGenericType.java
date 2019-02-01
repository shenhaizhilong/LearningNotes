package hello_world;

/**
 * Created by shenhaizhilong on 4/17/2017.
 */

class ClassAsFactory<T>
{
    T x;
    public ClassAsFactory(Class<T> kind)
    {
        try
        {
            x = kind.newInstance();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}

class Employee2{}

public class InstantiateGenericType
{
    public static void main(String[] args)
    {
        ClassAsFactory<Employee2> fe = new ClassAsFactory<>(Employee2.class);
        System.out.println("Employee succeeded");
        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);

        }catch (Exception e)
        {
            System.out.println("ClassAsFactory<Integer> failed");
        }
    }
}
