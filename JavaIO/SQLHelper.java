package JavaIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLHelper {

    /**
     * get sql connection
     * @return Connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException
    {


        Properties properties = new Properties();
        try(InputStream input = new FileInputStream("D:\\java_project\\Test\\src\\javacore2\\database.property"))
        {
            properties.load(input);

        }catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        String drivers = properties.getProperty("jdbc.driver");
        if(drivers !=null) System.setProperty("jdbc.drivers", drivers);
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        return DriverManager.getConnection(url, username, password);
    }
}
