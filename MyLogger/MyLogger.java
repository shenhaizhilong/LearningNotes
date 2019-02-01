package MyLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {
    private static final Logger myLogger = Logger.getLogger("MyLogger.MyLogger");
    public void run()
    {
        myLogger.setLevel(Level.ALL);

        for (int i = 0; i < 1; i++) {

            myLogger.severe("Test severe" + i);
            myLogger.warning("Test Warning");
            myLogger.info("Test logger info" + i);
            myLogger.config("Test config");
            myLogger.fine("Test fine");
            myLogger.finer("Test finer");
            myLogger.finest("Test finest");
            try
            {
                Thread.sleep(1000);
            }catch (InterruptedException e)
            {
                myLogger.severe(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        MyLogger logger = new MyLogger();
        logger.run();
    }
}
