package javavm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/16 11:04
 */
public class HeapOverflow {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true)
        {
            list.add(new OOMObject());
        }
    }
}
