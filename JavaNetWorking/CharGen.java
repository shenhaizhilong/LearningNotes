package JavaNetWorking;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CharGen {

    public static final int PORT = 19;
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(100);
        try(ServerSocket serverSocket = new ServerSocket(PORT))
        {

            while (true)
            {
                try
                {
                    Socket socket = serverSocket.accept();
                    Callable<Void> task = new CharGenTask(socket);
                    pool.submit(task);

                }catch (IOException ex)
                {
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            }



        }catch (IOException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void generateCharacters(OutputStream out) throws IOException
    {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacter = 94;
        int numberofCharPerLine = 72;
        int start = firstPrintableCharacter;
        byte[] line = new byte[numberofCharPerLine + 2];
        int count = 10;
        while (count-- > 0)
        {
            for (int i = start; i < start + numberofCharPerLine; i++) {
                line[i-start] = (byte)((i-firstPrintableCharacter)%numberOfPrintableCharacter + firstPrintableCharacter);
            }
            line[72] = (byte)'\r';
            line[73] = (byte)'\n';
            out.write(line);
            start = ((start +1) -firstPrintableCharacter)%numberOfPrintableCharacter + firstPrintableCharacter;
        }

        out.write("Finished!\r\n".getBytes());

    }

    private static class CharGenTask implements Callable<Void>
    {
        private Socket socket;
        public CharGenTask(Socket socket)
        {
            this.socket = socket;
        }

        @Override
        public Void call() {
            try(OutputStream out = socket.getOutputStream())
            {
                generateCharacters(out);


            }catch (IOException ex)
            {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }finally {
                try{
                    socket.close();
                }catch (IOException ex)
                {
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            }
            return null;
        }
    }
}
