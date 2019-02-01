package JavaIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class NioFile {

    /**
     * https://blog.csdn.net/10km/article/details/54409044
     * judge whether sub in parent or the same file.
     * @param parent
     * @param sub
     * @return
     * @throws IOException
     */
    public static boolean sameOrSub(Path parent, Path sub) throws IOException
    {
        if(null ==parent)
        {
            throw new NullPointerException("parent directory is null");
        }

        if(!Files.exists(parent) || !Files.isDirectory(parent))
        {
            throw new IllegalArgumentException(String.format("the parent directory is not exists or not a directory"));

        }

        while (null !=sub){
            if(Files.exists(sub) && Files.isSameFile(parent, sub))
                return true;
            sub = sub.getParent();
        }

        return false;
    }

    /**
     * 判断sub是否在parent之下的文件或子文件夹
     * parent必须存在，且必须是directory,否则抛出{@link IllegalArgumentException}
     * @param parent
     * @param sub
     * @return
     * @throws IOException
     */

    public static boolean isSub(Path parent, Path sub) throws IOException
    {
        return (null==sub)?false:sameOrSub(parent, sub);
    }

    /**
     * 复制/移动文件夹
     * @param move 操作标记，为true时移动文件夹,否则为复制
     * @param source 要复制/移动的源文件夹
     * @param target 源文件夹要复制/移动到的目标文件夹
     * @param copyOptions 文件复制选项
     * @throws IOException
     * @see Files#move(Path, Path, CopyOption...)
     * @see Files#copy(Path, Path, CopyOption...)
     * @see Files#walkFileTree(Path, java.nio.file.FileVisitor)
     */
    public static void operateDir(boolean move, Path source, Path target, CopyOption ...copyOptions) throws IOException
    {
        if(null == source || !Files.isDirectory(source))
            throw new IllegalArgumentException("source must be a directory");

        Path dest = target.resolve(source.getFileName());
        if(Files.exists(dest) && Files.isSameFile(source, dest)) return;
        if(isSub(source, dest))
            throw new IllegalArgumentException("dest directory must not be sub directory of source directory");
        
        boolean clear = true;
        for (CopyOption option :
                copyOptions) {
            if(StandardCopyOption.REPLACE_EXISTING == option)
            {
                clear = false;
                break;
            }
        }

        if(clear)
            deleteIfExists(dest);

        Files.walkFileTree(source, new SimpleFileVisitor<Path>(){

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path subDir = 0==dir.compareTo(source)?dest:dest.resolve(dir.subpath(source.getNameCount(), dir.getNameCount()));
                Files.createDirectories(subDir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if(move)
                    Files.move(file, dest.resolve(file.subpath(source.getNameCount(), file.getNameCount())), copyOptions);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                if(move)
                    Files.deleteIfExists(dir);
                return super.postVisitDirectory(dir, exc);
            }
        });


    }

    public static void copyDir(Path source, Path target, CopyOption... options) throws IOException
    {
        operateDir(false, source, target, options);
    }

    public static void moveDir(Path source, Path target, CopyOption ... options) throws IOException
    {
        operateDir(true, source, target, options);
    }
    /**
     * force to delete the directory, even this directory contain the
     * @param dir
     * @throws IOException
     */
    public static void deleteIfExists(Path dir) throws IOException
    {
        try {
            Files.deleteIfExists(dir);
        }catch (DirectoryNotEmptyException e)
        {
            Files.walkFileTree(dir, new SimpleFileVisitor<Path>()
            {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.deleteIfExists(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.deleteIfExists(dir);
                    return super.postVisitDirectory(dir, exc);
                }
            });
        }
    }
}
