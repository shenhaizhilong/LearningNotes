package javavm;

import java.util.Arrays;
import java.util.List;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/24 10:59
 */
public class InBox {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        int sum = 0;
        for (int i :
        list){
            sum +=i;
        }

        System.out.println(sum);

    }
}
