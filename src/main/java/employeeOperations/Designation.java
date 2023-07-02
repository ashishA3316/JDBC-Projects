package employeeOperations;

import java.sql.*;
import java.util.Scanner;

public class Designation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Designation");
        String desg = sc.next();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String query = "select count(emp_id) from employee_info where emp_desg = ?";

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, desg);
            rs = pstmt.executeQuery();
//            System.out.println("COUNT\t\tNAME\t\tDESIGNATION\t\tSALARY");
//            System.out.println("========================================");
            while(rs.next())
            {
                int count = rs.getInt(1);
                System.out.println("Total Count = "+count);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
