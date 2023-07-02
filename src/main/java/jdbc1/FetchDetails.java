package jdbc1;

import java.sql.*;
import java.util.Scanner;

public class FetchDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book Id");
        int id = sc.nextInt();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "select * from Book_info where Book_id="+id;

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("BookID\tBookName\tBookPrice");
            System.out.println("===============================");

            while(rs.next())
            {
                int Id = rs.getInt(1);
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
