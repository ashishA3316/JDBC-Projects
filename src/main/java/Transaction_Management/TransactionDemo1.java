package Transaction_Management;

import java.sql.*;
import java.util.Scanner;

public class TransactionDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER BOOK ID");
        int id = sc.nextInt();

        Connection con = null;
        PreparedStatement pstmt = null;

        String query = "delete from book_info where Book_id = ?";

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            int count = pstmt.executeUpdate();
            System.out.println("Are You Sure?");
            System.out.println("1.YES\t\t2.NO");
            int choice = sc.nextInt();
            if (choice==1)
            {
                con.commit();
                System.out.println(count+" RECORD DELETED SUCCESSFULLY");
            }
            else
            {
                con.rollback();
                System.out.println("TRANSACTION CANCELLED");
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
