package callableStatement2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class addBooks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book ID");
        int id = sc.nextInt();
        System.out.println("Enter Book Name");
        String name = sc.next();
        System.out.println("Enter Book Price");
        double price = sc.nextDouble();

        Connection con = null;
        CallableStatement cstmt = null;

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            cstmt = con.prepareCall("{call addbooks(?, ?, ?)}");
            cstmt.setInt(1, id);
            cstmt.setString(2, name);
            cstmt.setDouble(3, price);
            cstmt.execute();
            System.out.println("Procedure Executed Successfully");
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
