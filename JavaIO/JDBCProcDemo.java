package JavaIO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCProcDemo {
    public static void main(String[] args) {
            getSkills(133);
    }

    public static void getSkills(int id)
    {
        String query = "{ call get_candidate_skill(?) }";
        ResultSet rs = null;

        try(Connection conn = SQLHelper.getConnection(); CallableStatement stmt = conn.prepareCall(query))
        {
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                System.out.println(String.format("%s - %s",
                        rs.getString("first_name") + " "
                        + rs.getString("last_name"),
                        rs.getString("skill")));
            }
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
