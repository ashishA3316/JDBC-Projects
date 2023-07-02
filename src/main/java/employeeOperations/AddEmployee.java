package employeeOperations;

import java.sql.*;
public class AddEmployee {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String query = "insert into employee_info values(?, ?, ?, ?)";

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            pstmt = con.prepareStatement(query);
            //1st record
            pstmt.setInt(1, 0);
            pstmt.setString(2, "VISHAL");
            pstmt.setString(3, "HR");
            pstmt.setDouble(4, 25000.25);
            int count1 = pstmt.executeUpdate();
            //2nd record
            pstmt.setInt(1, 0);
            pstmt.setString(2, "PAVAN");
            pstmt.setString(3, "DEVELOPER");
            pstmt.setDouble(4, 35000.25);
            int count2 = pstmt.executeUpdate();
            //3rd record
            pstmt.setInt(1, 0);
            pstmt.setString(2, "AKHIL");
            pstmt.setString(3, "ADMIN");
            pstmt.setDouble(4, 45000.25);
            int count3 = pstmt.executeUpdate();

            System.out.println(count2+count3+" RECORD INSERTED SUCCESSFULLY");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

}
