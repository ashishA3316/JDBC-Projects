package CarOperation;

import java.sql.*;

public class CountModels {
    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "select company, count(model) from car_info group by company";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","Ashish@3316");
            stmt=con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("COUNT\t\tMODEL");
            System.out.println("====================");
            while (rs.next())
            {
                String model = rs.getString(1);
                int count = rs.getInt(2);

                System.out.println(count+ "\t\t" +model);
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            if (con != null)
            {
                try
                {
                    con.close();
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }

            if (stmt != null)
            {
                try
                {
                    stmt.close();
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }



    }
}
