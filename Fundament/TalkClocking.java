package Fundament;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class TalkClocking
{
    private boolean isBeep;
    private int interval;

    public TalkClocking(boolean isBeep, int interval)
    {
        this.interval = interval;
        this.isBeep = isBeep;
    }

    public void start()
    {
        TimerPrinter timerPrinter = new TimerPrinter();
        Timer timer = new Timer(interval, timerPrinter);
        timer.start();
    }

    public  class TimerPrinter implements ActionListener
    {
        private java.util.List<String> list = new ArrayList<>();
        @Override
        public void actionPerformed(ActionEvent event)
        {
            System.out.println("At the tone, the time is " + new Date());
            if (isBeep){
                Toolkit.getDefaultToolkit().beep();
            }
        }

    }

}