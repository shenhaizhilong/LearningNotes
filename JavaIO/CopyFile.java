package JavaIO;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/1 14:14
 */
public class CopyFile {

    public static void copyFileBySteam(File source, File target)  throws IOException
    {
        InputStream in = null;
        OutputStream out = null;
        try
        {
            in = new FileInputStream(source);
            out = new FileOutputStream(target);
            byte[] buffer = new byte[50*1024];
            int length;
            while ((length = in.read(buffer)) > 0)
            {
                out.write(buffer, 0, length);

            }
            out.flush();
        }finally {
            in.close();
            out.close();
        }
    }


    public static void copyFileByChannel(File source, File target) throws IOException
    {
        FileChannel in = null;
        FileChannel out = null;
        try
        {
            in = new FileInputStream(source).getChannel();
            out = new FileOutputStream(target).getChannel();
            out.transferFrom(in, 0,  in.size());
        }finally {
            in.close();
            out.close();
        }
    }

    public static void copyFileByCommonsIo(File source, File target) throws IOException
    {
        FileUtils.copyFile(source, target);
    }


    public static void copyFileByFiles(File source, File target) throws IOException
    {
        Files.copy(source.toPath(), target.toPath());
    }

    public static void testCopy(File source, File target, String name) throws IOException
    {
        try
        {
            // get the copy file method
            Method method = CopyFile.class.getMethod(name, File.class,File.class);
            long t1 = System.nanoTime();
            // static method , so the obj is null
            method.invoke(null, source, target);
            long t2 = System.nanoTime();
            System.out.println(String.format("MethodName: {%20s} Cost time: {%s}", name, (t2 - t1)));
            target.delete();

        }catch (NoSuchMethodException ex)
        {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }catch (IllegalAccessException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }catch (InvocationTargetException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        File source = new File("D:\\haiwang.mp4");
        File target = new File("F:\\haiwang.mp4");

        testCopy(source, target, "copyFileBySteam");
        testCopy(source, target, "copyFileByChannel");
        testCopy(source, target, "copyFileByCommonsIo");
        testCopy(source, target, "copyFileByFiles");

    }
}
