package JavaIO;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/1 16:36
 */
public class DownloadFile {

    public static void downloadFileBySteam(String urlStr, String fileName) throws IOException
    {
        URL url = new URL(urlStr);
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());
            FileOutputStream out = new FileOutputStream(fileName))
        {
            byte[] buffer = new byte[2*1024]; // 2kb
            int length = 0;
            while ((length = bufferedInputStream.read(buffer, 0, buffer.length)) > 0)
            {
                out.write(buffer,0, length);

            }
            out.flush();
        }
    }

    public static void downloadFileByNio(String urlStr, String fileName) throws IOException
    {
        URL url = new URL(urlStr);
        try(ReadableByteChannel rbc = Channels.newChannel(url.openStream()); FileOutputStream outputStream = new FileOutputStream(fileName))
        {
            outputStream.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }


    public static void main(String[] args) throws IOException {
        downloadFileByNio("https://video.sekindo.com/uploads/cn4/video/users/hls/20749/video_5bc44f65788ac403245622/vid5bc4554641393201637996.mp4/w_640_001.ts","a.ts");
        downloadFileBySteam("https://video.sekindo.com/uploads/cn4/video/users/hls/20749/video_5bc44f65788ac403245622/vid5bc4554641393201637996.mp4/w_640_001.ts","b.ts");
    }
}
