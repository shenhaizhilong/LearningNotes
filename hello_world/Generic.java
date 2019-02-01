package hello_world;

/**
 * Created by shenhaizhilong on 4/17/2017.
 */
public class Generic
{
    public <T> void  f(T t)
    {
        System.out.println(t.getClass().getName());
    }
    public  static  void  main(String[] args)
    {
        Generic gm =  new Generic();
        gm.f("");
        gm.f(10);
        gm.f(100.0);
        gm.f('c');
        gm.f(gm);

    }
}
