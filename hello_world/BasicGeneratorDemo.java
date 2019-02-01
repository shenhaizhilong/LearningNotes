package hello_world;

/**
 * Created by shenhaizhilong on 4/17/2017.
 */
public class BasicGeneratorDemo
{
    public  static  void main(String[] args)
    {
        IGenerator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for(int i=0; i < 5000000; i++)
        {
            System.out.println(gen.next());
        }
    }

}
