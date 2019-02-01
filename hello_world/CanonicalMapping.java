package hello_world;
import java.lang.ref.WeakReference;
import java.util.*;
/**
 * Created by shenhaizhilong on 4/28/2017.
 */
class Element
{
    private String ident;
    public Element(String id){ident = id;}
    public String toString(){return ident;}
    public int hashCode(){return ident.hashCode();}
    public boolean equals(Object o)
    {
        return o instanceof  Element && ident.equals(((Element)o).ident);
    }
    protected void finalize()
    {
        System.out.println("Finalize " + getClass().getSimpleName() + " " + ident);
    }

}
class Key extends Element
{
    public Key(String id){ super(id);}
}
class Value extends Element
{
    public Value(String id){super(id);}

}


public class CanonicalMapping
{
    public static void main(String[] args)
    {
        int size = 10;
        if(args.length>0)
            size = new Integer(args[0]);
        Key[] keys = new Key[size];
        WeakHashMap<Key,Value> weakHashMap = new WeakHashMap<>();
        for(int i=0; i<size; i++)
        {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if(i%2==0)
            {
                keys[i] = k;
            }
            weakHashMap.put(k,v);
        }


        System.gc();
        System.out.println(weakHashMap.keySet());
    }
}
