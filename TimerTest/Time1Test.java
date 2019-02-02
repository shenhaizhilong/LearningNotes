package TimerTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
public class Time1Test {
    private static Timer timer = new Timer(true);
    public static class MyTask extends TimerTask
    {
        @Override
        public void run()
        {
            System.out.println("运行了,时间是: " + new Date());
        }
    }

    public static void main(String[] args) {
        try
        {
            MyTask myTask = new MyTask();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            String dateString = "2017-7-20 23-08-00";
            Date date = simpleDateFormat.parse(dateString);
            System.out.println("时间字符串为:" + date + " 当前时间为:" + new Date());
            timer.schedule(myTask, date);

            System.out.println("Main end");
        }catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
}
