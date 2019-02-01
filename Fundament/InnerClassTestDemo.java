package Fundament;
import javax.swing.*;

public class InnerClassTestDemo {

    public static void main(String[] args) {
        TalkClocking clocking = new TalkClocking(true, 100);
        clocking.start();
        JOptionPane.showMessageDialog(null, "Quit Program");
        System.exit(0);
    }
}


