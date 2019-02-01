package JavaIO;



import javax.swing.*;
import java.awt.*;

public class XMLWriteDemo1 {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new XMLWriteFrame();

                frame.setTitle("XMLWriteDemo1");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setVisible(true);
            }
        });
    }
}
