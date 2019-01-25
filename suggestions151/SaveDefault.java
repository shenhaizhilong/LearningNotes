package suggestions151;

import java.io.Serializable;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/25 17:37
 */
public class SaveDefault implements Serializable {


    private static final long serialVersionUID = -3280059887831333269L;

    public static void main(String[] args) {
        int fee = 200;
        saveDefault:save(fee);
        dd:save(fee);
    }

    static void saveDefault(){

    }
    static void save(int fee)
    {
        System.out.println(fee);
    }
}
