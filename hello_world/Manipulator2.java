package hello_world;

/**
 * Created by shenhaizhilong on 4/17/2017.
 */
public class Manipulator2<T extends HasF>
{
    private T obj;
    public Manipulator2(T x){this.obj = x;}
    public void manipulator() {
        obj.f();

    }

}
