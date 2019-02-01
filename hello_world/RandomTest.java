package hello_world;

/**
 * Created by shenhaizhilong on 4/30/2017.
 */
enum Activity {SITTING, LYING, STANDING, HOPPING }
public class RandomTest
{
    public static void main(String[] args)
    {
        for (int i = 0; i < 20; i++) {
            System.out.println(Enums.random(Activity.class));
        }
    }
}
