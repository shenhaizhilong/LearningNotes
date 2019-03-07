package javavm;

/**
 * @author: shenhaizhilong
 * @date: 2019/3/5 10:19
 */
public class GCTimes {

    private static final int One_MB = 1024*1024;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("create a " + (i +1) + " MB");
            byte[] b1 = new byte[One_MB];
        }


        for (int i = 0; i < 4; i++) {
            byte[] b2 = new byte[5*One_MB];
        }

        for (int i = 0; i < 8; i++) {
            System.out.println("created  " + (i +1) + " MB");
            byte[] b1 = new byte[One_MB];
        }

        for (int i = 0; i < 1; i++) {
            byte[] b2 = new byte[5*One_MB];
        }


    }
}
