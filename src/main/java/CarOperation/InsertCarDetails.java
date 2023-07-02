package CarOperation;

import java.sql.*;
import java.util.Scanner;

public class InsertCarDetails {
    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the Model Name");
        String model = sc.next();
        System.out.println("Please Enter the Company Name");
        String company = sc.next();
        System.out.println("Please Enter the Category");
        String category = sc.next();
        System.out.println("Please Enter the Price");
        double price = sc.nextDouble();

        String query = "insert into car_info(model, company, category, price) values('"+model+"', '"+company+"', '"+category+"', "+price+")";

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            stmt = con.createStatement();
            int count = stmt.executeUpdate(query);
            System.out.println(count+" Car Information Inserted Successfully");
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
