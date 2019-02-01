package JavaNetWorking;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingDaytimeServer {
    public final static int PORT = 13;
    private final static Logger auditLogger = Logger.getLogger("requests");
    private final static Logger errorLogger = Logger.getLogger("errors");

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(50);
        try(ServerSocket serverSocket = new ServerSocket(PORT))
        {
            while (true)
            {
                try{
                    Socket connection = serverSocket.accept();
                    Callable<Void> task =  new DaytimeTask(connection);
                    pool.submit(task);
                }catch (IOException ex)
                {
                    errorLogger.log(Level.SEVERE, " accept error " + ex.getMessage(), ex );
                }catch (RuntimeException ex)
                {
                    errorLogger.log(Level.SEVERE, "unexpected error " + ex.getMessage(), ex );
                }
            }
        }catch (IOException ex)
        {
            errorLogger.log(Level.SEVERE, "Couldn't start server", ex);
        }catch (RuntimeException ex)
        {
            errorLogger.log(Level.SEVERE, "Couldn't start server " + ex.getMessage(), ex );
        }
    }




    private static final class DaytimeTask implements Callable<Void>
    {
        private Socket socket;
        DaytimeTask(Socket socket)
        {
            this.socket = socket;
        }

        @Override
        public Void call() {

            try
            {
                Date now = new Date();
                auditLogger.info(now + " " + socket.getRemoteSocketAddress());
                Writer out = new OutputStreamWriter(socket.getOutputStream());
                out.write(now.toString() + "\r\n");
                out.flush();
            }catch (IOException ex)
            {

            }finally {
                try{
                    socket.close();
                }catch (IOException e){}
            }

            return null;

        }
    }
}
