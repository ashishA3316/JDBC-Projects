package callableStatement;

import java.sql.*;
import java.util.Scanner;

public class AreaofCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Radius of Circle");
        double rad = sc.nextDouble();

        Connection con = null;
        CallableStatement cstmt = null;

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            cstmt = con.prepareCall("{?=call areaofcircle(?)}");
            cstmt.setDouble(2, rad);
            cstmt.registerOutParameter(1, Types.DOUBLE);
            cstmt.execute();
            System.out.println("AREA OF CIRCLE IS "+cstmt.getDouble(1));
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
