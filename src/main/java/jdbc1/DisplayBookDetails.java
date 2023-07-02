package jdbc1;

import java.sql.*;

public class DisplayBookDetails {
    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "select * from Book_info";

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            stmt= con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("ID\t\tNAME\t\tPRICE");
            System.out.println("================================");
            while (rs.next())
            {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                System.out.println(id+"\t\t"+name+"\t\t"+price);
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
