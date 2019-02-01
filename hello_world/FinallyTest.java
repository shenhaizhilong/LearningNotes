package hello_world;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/18 18:18
 */
public class FinallyTest {

    public static int test()
    {
        int x = 10;
        try
        {
            return x;
        }finally {
            System.out.println("running finally");
            ++x;
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
