package CarOperation;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class MinMax_Price {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Your Minimum Price");
        double min = sc.nextDouble();
        System.out.println("Please Enter Your Maximum Price");
        double max = sc.nextDouble();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "select * from car_info where price between "+min+" and "+max+" ";

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("ID\tMODEL\tCOMPANY\tCATEGORY\tPRICE");
            System.out.println("========================================");
            while(rs.next())
            {
                int id = rs.getInt(1);
                String model = rs.getString(2);
                String company = rs.getString(3);
                String category = rs.getString(4);
                double price = rs.getDouble(5);
                System.out.println(id+"\t"+model+"\t"+company+"\t"+category+"\t"+price);
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
