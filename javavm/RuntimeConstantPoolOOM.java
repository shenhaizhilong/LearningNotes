package javavm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/16 11:57
 * java -XX:MaxMetaspaceSize=18m -Xmx100M javavm.RuntimeConstantPoolOOM
 *  java -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -Xms20m -Xmx20m javavm.RuntimeConstantPoolOOM
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true)
        {
            list.add(String.valueOf(i).intern());
            i++;
        }

    }
}
