package jdbc1;

import java.sql.*;
import java.util.Scanner;

public class UpdateDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the Book id to Update");
        int id = sc.nextInt();
        String query = "";
        System.out.println("Please Enter your Choice");
        System.out.println("1. Book Price");
        System.out.println("2. Book Name");
        int choice = sc.nextInt();

        if(choice==1)
        {
            System.out.println("Please Enter the new Price of Book"+id);
            double price = sc.nextDouble();
            query = "update Book_info set Book_Price="+price+"where Book_id="+id;
        }
        if(choice==2)
        {
            System.out.println("Please Enter the Name of Book"+id);
            String name = sc.next();
            query = "update Book_info set Book_Name='"+name+"' where Book_id="+id;
        }

        Connection con = null;
        Statement stmt = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            stmt =con.createStatement();
            int count = stmt.executeUpdate(query);
            System.out.println(count+" Details Updated Successfully");
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
