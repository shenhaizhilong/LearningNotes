package Fundament;

import javax.swing.*;
public class InnerClassTestDemo2 {
    public static void main(String[] args) {
        TalkClocking talkClocking = new TalkClocking(true, 100);
        talkClocking.start();
       // TalkClocking.TimerPrinter timerPrinter = new TalkClocking.TimerPrinter();

        JOptionPane.showMessageDialog(null, "Quiet Program ? ");
        System.exit(0);
    }
}
