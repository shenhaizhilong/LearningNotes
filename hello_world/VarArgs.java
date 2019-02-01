package hello_world;

public class VarArgs {

    public static void Test(int ...myArgs)
    {
        for (int i = 0; i < myArgs.length; i++) {
            System.out.println(myArgs[i]);
        }
    }

    public static void main(String[] args) {
        Test(1);
        Test(1,2,3,4);
        Test(1,2);
    }
}
