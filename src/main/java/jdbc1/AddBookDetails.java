package jdbc1;

import java.sql.*;
import java.util.Scanner;

public class AddBookDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book Id");
        int id = sc.nextInt();
        System.out.println("Enter Book Name");
        String name = sc.next();
        System.out.println("Enter Book Price");
        double price = sc.nextDouble();

        Connection con = null;
        Statement stmt = null;

        String query = "insert into Book_info values("+id+", '"+name+"', "+price+")";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            stmt =con.createStatement();
            int count = stmt.executeUpdate(query);
            System.out.println(count+" Book Details Inserted Successfully");
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
