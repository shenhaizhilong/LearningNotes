package hello_world;

/**
 * Created by shenhaizhilong on 5/8/2017.
 */
public class User
{
    private int id;
    private String name;
    public User(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "(" + id + ","+name+")";
    }
}
