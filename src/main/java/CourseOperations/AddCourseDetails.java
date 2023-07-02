package CourseOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCourseDetails {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        FileInputStream fin = null;

        String query = "insert into course_info values(?, ?, ?)";

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,0);
            pstmt.setString(2, "WEB TECH");
            fin = new FileInputStream("D:\\J2EE\\Advance java\\wt.png");
            pstmt.setBinaryStream(3, fin);
            int count = pstmt.executeUpdate();
            System.out.println(count+" Record Inserted Successfully");


        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}
