package CarOperation;
import java.sql.*;
import java.util.Scanner;

public class CarModels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter The Name of Company");
        String company = sc.next();
        System.out.println("Please Enter The Category");
        String category = sc.next();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "select model from car_info where company='" +company+ "' and category='" +category+ "' ";

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("CAR MODELS");
            System.out.println("============");
            while (rs.next())
            {
                String model = rs.getString(1);
                System.out.println(model);
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }
}
