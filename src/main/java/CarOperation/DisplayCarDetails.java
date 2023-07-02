package CarOperation;

import java.sql.*;
import java.util.Scanner;
public class DisplayCarDetails {
    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Category");
        String category = sc.next();

        String query = "select * from car_info where category='"+category+"'";

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("ID\t\tMODEL\t\tCOMPANY\t\tCATEGORY\t\tPRICE");
            System.out.println("==========================================================");
            while (rs.next())
            {
                int id = rs.getInt(1);
                String model = rs.getString(2);
                String company = rs.getString(3);
                double price = rs.getDouble(5);
                System.out.println(id+"\t\t"+model+"\t\t"+company+"\t\t"+category+"\t\t"+price);
            }
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
