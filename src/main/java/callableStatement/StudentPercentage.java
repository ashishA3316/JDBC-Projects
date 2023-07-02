package callableStatement;

import java.sql.*;
import java.util.Collection;
import java.util.Scanner;

public class StudentPercentage {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Student Percentage");
        double per = sc.nextDouble();

        Connection con = null;
        CallableStatement cstmt = null;

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            cstmt = con.prepareCall("{?=call studentresult(?)}");
            cstmt.setDouble(2, per);
            cstmt.registerOutParameter(1, Types.VARCHAR);
            cstmt.execute();
            System.out.println("STUDENT RESULT IS "+cstmt.getString(1));
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
