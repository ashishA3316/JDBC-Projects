package employeeOperations;

import java.sql.*;
public class DeleteRecords {
    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pstmt = null;

        String query = "delete from employee_info where emp_id = ?";

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            pstmt = con.prepareStatement(query);
            //1st record
            pstmt.setInt(1, 3);
            int count1 = pstmt.executeUpdate();
            //2nd record
            pstmt.setInt(1, 2);
            int count2 = pstmt.executeUpdate();
            System.out.println(count1+count2+" RECORD DELETED SUCCESSFULLY");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
