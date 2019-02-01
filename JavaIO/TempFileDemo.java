package JavaIO;


import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;

public class TempFileDemo {
    public static void main(String[] args) throws IOException {

        Path newPath = Files.createTempFile("tom", ".txt");
        System.out.println(newPath);

//        newPath = Files.createTempDirectory("tom");
//        System.out.println(newPath);

        Path path = Paths.get("D:\\");
        newPath = Files.createTempDirectory(path, "temp");
        System.out.println(newPath);
        path = Paths.get("D:\\temp2546055131268937195\\Mooncake_role_tenant_List-2016-05-11-10-36-57.csv");
        System.out.println(path);

        System.out.println(Files.size(path));
        UserPrincipal userPrincipal = Files.getOwner(path);
        System.out.println(userPrincipal.getName());
        File file = path.toFile();
        BasicFileAttributes basicFileAttributes =  Files.readAttributes(path, BasicFileAttributes.class);

        System.out.println(basicFileAttributes.creationTime());
        System.out.println(basicFileAttributes.fileKey());
        System.out.println(basicFileAttributes.lastAccessTime());
        System.out.println(basicFileAttributes.lastModifiedTime());
        System.out.println(basicFileAttributes.size());

        System.out.println("******************Directory Stream demo ***************************");
        
        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("D:\\pw_vip")))
        {
            for (Path entry :
                    directoryStream) {
                System.out.println(entry.getFileName());
            }
        }


        //glob

        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("D:\\pw_vip"), "*.csv"))
        {
            for (Path entry:
                 directoryStream) {

                System.out.println(entry.getFileName());

            }
        }

    }
}
