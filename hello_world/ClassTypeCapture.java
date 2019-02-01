package hello_world;

/**
 * Created by shenhaizhilong on 4/17/2017.
 */

class Building{}
class House extends Building{}

public class ClassTypeCapture<T>
{
    Class<T> kind;
    public  ClassTypeCapture(Class<T> kind)
    {
        this.kind = kind;
    }

    public boolean f(Object obj)
    {
        return this.kind.isInstance(obj);
    }
    public static void main(String[] args)
    {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        System.out.println(Integer.class.isInstance(10));
        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
}
