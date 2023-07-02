package callableStatement;
import java.sql.*;
import java.util.Scanner;

public class AddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no1");
        int no1 = sc.nextInt();
        System.out.println("Enter no2");
        int no2 = sc.nextInt();

        Connection con = null;
        CallableStatement cstmt = null;

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            cstmt = con.prepareCall("{?=call addnumbers(?, ?)}");
            cstmt.setInt(2,no1);
            cstmt.setInt(3, no2);
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.execute();
            System.out.println("ADDITION IS "+cstmt.getInt(1));
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
