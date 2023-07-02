package employeeOperations;

import java.sql.*;
import java.util.Scanner;

public class login_Info {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the User Name");
        String name = sc.next();
        System.out.println("Please Enter the Password");
        String pass = sc.next();

        String query = "select * from emp_data";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            boolean status = false;
            while (rs.next()) {
                String dbuser = rs.getString("user_name");
                String dbpass = rs.getString("password");
                if (name.equals(dbuser) && pass.equals(dbpass))
                {
                    System.out.println("LOGIN SUCCESSFUL");
                    status = true;
                }
            }
            if(status==false)
            {
                System.out.println("INVALID LOGIN DETAILS");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
