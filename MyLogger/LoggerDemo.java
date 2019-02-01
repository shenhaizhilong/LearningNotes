package MyLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();
        for (int i = 0; i < 10; i++) {
            logger.info("File ->Open item selected");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e)
            {
                logger.info(e.getMessage());
            }
        }

        logger.setLevel(Level.OFF);
    }
}
