package employeeOperations;

import java.sql.*;

public class Employee_data {
    static Connection con = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;


        static {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void maxsal()
        {

            String query = "select * from employee_info where emp_sal=(select max(emp_sal) from employee_info)";
            try
            {
                pstmt = con.prepareStatement(query);
                rs = pstmt.executeQuery();
                while (rs.next())
                {
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getDouble(4));
                }
            }
            catch (SQLException e)
            {
                throw new RuntimeException(e);
            }

        }

        public void minsal()
        {

            String query = "select * from employee_info where emp_sal=(select min(emp_sal) from employee_info)";
            try
            {
                pstmt = con.prepareStatement(query);
                rs = pstmt.executeQuery();
                while (rs.next())
                {
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getDouble(4));
                }
            }
            catch (SQLException e)
            {
                throw new RuntimeException(e);
            }
        }

}
