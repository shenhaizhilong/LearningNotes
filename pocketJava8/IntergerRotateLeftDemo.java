package pocketJava8;

import algorithom.BitUtil;

/**
 * @author: shenhaizhilong
 * @date: 2018/7/13 15:22
 */
public class IntergerRotateLeftDemo {
    public static int rotateLeft(int i, int distance)
    {
        return (i << distance | (i>>>(32-distance)));
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(Integer.rotateLeft(i, 2) == rotateLeft(i, 2));
        }

        System.out.println(Integer.MAX_VALUE +1);

        System.out.println(BitUtil.getBitsStr(2166136261L));
        int hash = (int) 2166136261L;
        System.out.println(BitUtil.getBitsStr(hash));
        System.out.println(hash);
//        System.out.println(BitUtil.getBitsStr(Long.MAX_VALUE));
//        System.out.println(BitUtil.getBitsStr(Long.MIN_VALUE));
//        System.out.println(BitUtil.getBitsStr(Integer.MAX_VALUE));
//        System.out.println(BitUtil.getBitsStr(Integer.MIN_VALUE));
//        System.out.println(BitUtil.getBitsStr(-1));
//        long hash2 = Double.doubleToLongBits(14695981039346656037D);
//        System.out.println(BitUtil.getBitsStr(hash2));
//        System.out.println(hash2);
//        hash2 = (long)14695981039346656037D;
//        System.out.println(hash2);

        hash = 5381;
        System.out.println("original: " + BitUtil.getBitsStr(hash));
        hash += hash << 13;
        System.out.println("Add and left shift 13: " + BitUtil.getBitsStr(hash));
        hash ^= hash >>> 7;
        System.out.println("Xor and right shift 7: "+ BitUtil.getBitsStr(hash));
        hash += hash << 3;
        System.out.println("Add and left shift 3: " + BitUtil.getBitsStr(hash));
        hash ^= hash >>> 17;
        System.out.println("Xor and right shift 17: " + BitUtil.getBitsStr(hash));
        hash += hash << 5;
        System.out.println("Add and left shift 5: " + BitUtil.getBitsStr(hash));

        System.out.println((Integer.MAX_VALUE -3 - Integer.MIN_VALUE )*(Integer.MAX_VALUE -3 - (Integer.MAX_VALUE)));
        System.out.println(Integer.MAX_VALUE -3 - Integer.MIN_VALUE );

        System.out.println(Integer.MIN_VALUE -1);
        System.out.println(Integer.MAX_VALUE +1);
        System.out.println(Integer.MIN_VALUE + Integer.MIN_VALUE -1);


    }
}
