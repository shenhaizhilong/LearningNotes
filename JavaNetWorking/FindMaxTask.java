package JavaNetWorking;

import java.util.concurrent.Callable;

public class FindMaxTask implements Callable<Integer> {

    private int[] data;
    private int start;
    private int end;
    public FindMaxTask(int[] data, int start, int end)
    {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int Max = Integer.MIN_VALUE;
        for (int i= start; i < end; i++)
        {
            if(data[i] > Max)
            {
                Max = data[i];
            }
        }

        return Max;
    }
}
