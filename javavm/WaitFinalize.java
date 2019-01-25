package javavm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/18 20:51
 */
public class WaitFinalize {
    private int[] value = new int[64*1024];
    private String name;

    public WaitFinalize(String name)
    {
        this.name = name;
        value[0] = 0;
        System.out.println("Created instance " + name);
    }
    @Override
    protected void finalize() throws Throwable {
        try
        {
            Thread.sleep(100);
        }catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        super.finalize();
    }

    public static void main(String[] args) {
        List<WaitFinalize> list = new ArrayList<>();
        int count = 0;
        try
        {
            while (count < 1000)
            {
                list.add(new WaitFinalize(new Integer(count).toString()));
                Thread.sleep(100);
                count++;
            }


        }catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }

        list = null;
        System.gc();
        try {
            Thread.sleep(1000*60);
        }catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }

    }
}
