package hello_world;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shenhaizhilong on 5/27/2017.
 */
public class TwoSum
{
    public static int[] twoSum(int[] numbers, int target)
    {
        int[] results = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i]))
            {
                results[1] = i;
                results[0] = map.get(target - numbers[i]);
                System.out.println(numbers[i] + ",," + (target -numbers[i]));
                return results;
            }
            map.put(numbers[i], i);
        }
        return results;
    }

    public static void main(String[] args)
    {
        int[] numbers = {2,5,10,1,9,6};
        int[] res = twoSum(numbers, 10);
        System.out.println(res[0] +"," + res[1]);

    }
}
