package JavaNetWorking;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.zip.GZIPOutputStream;

public class GZipRunnable implements Runnable {

    private final File input;
    private final String savePath;

    public GZipRunnable(File file, String savePath)
    {
        this.input = file;
        this.savePath = savePath;
    }
    @Override
    public void run() {

        if(!input.getName().endsWith(".gz") && input.getName().contains("."))
        {
            File output = new File(savePath + input.getName().split("\\.")[0] + ".gz") ;
            System.out.println("outPut" + output.toString());
            try(InputStream in = new BufferedInputStream(new FileInputStream(input));
                OutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(output)))
            )
            {

                byte[] bytes = new byte[1024];
                while (in.read(bytes) != -1)
                {
                    out.write(bytes);
                }
                out.flush();

            }catch (FileNotFoundException ex)
            {
                System.err.println(ex);
            }catch (IOException ex)
            {
                System.err.println(ex);
            }

        }
    }
}
