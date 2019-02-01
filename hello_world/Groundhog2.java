package hello_world;

/**
 * Created by shenhaizhilong on 4/25/2017.
 */
public class Groundhog2 extends Groundhog
{
    public Groundhog2(int n)
    {
        super(n);
    }
    public int hashCode(){return number;};
    public boolean equals(Object o)
    {
        return o instanceof Groundhog2 && number == ((Groundhog2)o).number;
    }

}
