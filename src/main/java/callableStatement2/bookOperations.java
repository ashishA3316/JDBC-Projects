package callableStatement2;

import java.sql.*;
import java.util.Scanner;
public class bookOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================================================");
        System.out.println("Enter Following Details to Insert Record");
        System.out.println("=====================================================");
        System.out.println("Enter the Book ID");
        int id = sc.nextInt();
        System.out.println("Enter the Book Name");
        String name = sc.next();
        System.out.println("Enter the Book Price");
        double price = sc.nextDouble();

        System.out.println("=====================================================");

        System.out.println("Enter the Following Details to Delete Record");
        System.out.println("=====================================================");
        System.out.println("Enter the Book ID");
        int id1 = sc.nextInt();

        System.out.println("=====================================================");

        System.out.println("Enter the Following Details to Update the Record");
        System.out.println("=====================================================");
        System.out.println("Enter the Book Price");
        double price1 = sc.nextDouble();
        System.out.println("Enter the Book ID");
        int id2 = sc.nextInt();

        System.out.println("=====================================================");

        Connection con = null;
        CallableStatement cstmt = null;

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            cstmt = con.prepareCall("{call bookOperation(?, ?, ?, ?, ?, ?)}");
            cstmt.setInt(1, id);
            cstmt.setString(2, name);
            cstmt.setDouble(3, price);
            cstmt.setInt(4, id1);
            cstmt.setDouble(5, price1);
            cstmt.setInt(6, id2);
            cstmt.execute();

            System.out.println("PROCEDURE EXECUTED SUCCESSFULLY");
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
