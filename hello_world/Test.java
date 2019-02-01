package hello_world;

/**
 * Created by shenhaizhilong on 4/27/2017.
 */
public abstract class Test<C>
{
    String name;
    public Test(String name){this.name = name;}
    abstract int test(C container, TestParam tp);
}
