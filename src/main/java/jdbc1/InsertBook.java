package jdbc1;

import java.sql.*;

public class InsertBook {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        String query = "insert into Book_info values(2, 'core java', 3000.25)";

        try {
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
           stmt= con.createStatement();
           int count=stmt.executeUpdate(query);
            System.out.println(count+" Book Inserted Successfully");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
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
