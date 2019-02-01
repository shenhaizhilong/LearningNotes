package hello_world;

/**
 * Created by shenhaizhilong on 4/27/2017.
 */
public class TestParam
{
    public final int size;
    public final int loops;
    public TestParam(int size, int loops)
    {
        this.size = size;
        this.loops = loops;
    }
    public static TestParam[] array(int ... values)
    {
        int size = values.length/2;
        TestParam[] results = new TestParam[size];
        int n=0;
        for(int i=0; i < size; i++)
        {
            results[i] = new TestParam(values[n++], values[n++]);

        }
        return results;
    }

    public static TestParam[] array(String[] values)
    {
        int[] vals = new int[values.length];
        for(int i=0; i< vals.length; i++)
        {
            vals[i] = Integer.decode(values[i]);
        }
        return array(vals);
    }
}
