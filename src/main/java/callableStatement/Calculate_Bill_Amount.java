package callableStatement;
import java.sql.*;
import java.util.Scanner;

public class Calculate_Bill_Amount {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Qty");
        int qty= sc.nextInt();
        System.out.println("Enter the Amount");
        double Amount=sc.nextDouble();

        Connection con=null;
        CallableStatement cstmt=null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            cstmt=con.prepareCall("{?=call CalculateBillAmount(?,?)}");
            cstmt.setInt(2,qty);
            cstmt.setDouble(3,Amount);
            cstmt.registerOutParameter(1, Types.DOUBLE);
            cstmt.execute();
            System.out.println("Total Bill Amount is With Discount ="+cstmt.getDouble(1));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
