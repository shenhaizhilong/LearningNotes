package suggestions151;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/26 16:32
 */
public class Person2 {
    private int age;
    private String name;
    private static int instanceNumber = 0;

    {
        ++instanceNumber;
    }
    public static void doSomething()
    {
        System.out.println(instanceNumber);
    }

     class Mobile
    {
        private String mobileTel;
        private String brand;

        private static final double cost = 13.0;
        //inner class can't have static declarations
        // private static double cost1 = 13.0;//error

        // inner class can't have static declarations
//        public static void doSomething()
//        {
//
//        }
    }
    public static class Home
    {
        private String address;
        private String homeTel;
        private static int homeInstanceNumber = 0;

        {
            homeInstanceNumber++;
        }

        public Home(String address, String homeTel)
        {
            this.address = address;
            this.homeTel = homeTel;
        }

        @Override
        public String toString() {
            return String.format("{address:%s, homeTel:%s}", address, homeTel);
        }

        public static int getInstanceNumber()
        {
            return homeInstanceNumber;
        }



    }



}
