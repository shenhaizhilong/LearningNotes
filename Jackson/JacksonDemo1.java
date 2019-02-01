package Jackson;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JacksonDemo1 {
    public static void main(String[] args) {

        Employee emp = new Employee();
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            String jsonStr = mapper.writeValueAsString(emp);
            System.out.println(jsonStr);
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }
}
