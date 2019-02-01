package JavaIO;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveBlobDemo {
    public static void main(String[] args) {

        String path = "D:\\java_project\\Test\\src\\javacore2\\";
        String querySQL = "SELECT ImageBlob from Cover";
        ResultSet resultSet = null;
        OutputStream out = null;
        String filename = null;

        try(Connection conn = SQLHelper.getConnection(); PreparedStatement statement = conn.prepareStatement(querySQL))
        {
            System.out.println(conn.getMetaData().supportsBatchUpdates());
            byte[] buffer = new byte[1024];
            resultSet = statement.executeQuery();
            InputStream input = null;
            int i = 0;
            while (resultSet.next())
            {
                input = resultSet.getBinaryStream(1);
                filename = path + i + ".jpg";
                System.out.println("Writing to file:" + filename);
                out = new FileOutputStream(filename);
                while (input.read(buffer)>0)
                {
                    out.write(buffer);
                }
                i++;
            }

        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Exception!");
            System.out.println(e.getMessage());
        }catch (IOException e)
        {
            System.out.printf(e.getMessage());
        }finally {
            try{
                if(resultSet !=null)
                {
                    resultSet.close();

                }
            }catch (SQLException e)
            {
                System.out.println("Close ResultSet Exception");
                System.out.println(e.getMessage());
            }

        }



    }
}
