package employeeOperations;

import java.sql.*;
import java.util.Scanner;

public class EmployeeManager {
    static Connection con = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;


    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //login info
    public boolean login(String user, String pass) {
        boolean status = false;
        String query = "select * from emp_data";

        try
        {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String dbuser = rs.getString("user_name");
                String dbpass = rs.getString("password");
                if (user.equals(dbuser) && pass.equals(dbpass))
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
            throw new RuntimeException(e);
        }
        return status;
    }


    //add employee
    public void addEmployee(String name, String desg, double sal) {
        String query = "insert into employee_info(emp_name, emp_desg, emp_sal) values('"+name+"', '"+desg+"', "+sal+")";
        try
        {
            pstmt= con.prepareStatement(query);
            int count = pstmt.executeUpdate(query);


            System.out.println(count+" Record Inserted Successfully");

        }
        catch (SQLException e)
        {
           e.printStackTrace();
        }
        finally
        {
            if (con != null)
            {
                try
                {
                    con.close();
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }

            if (pstmt != null)
            {
                try
                {
                    pstmt.close();
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    //view employee
    public void viewEmployee() {
        String query = "select * from employee_info";

        try
        {
            pstmt= con.prepareStatement(query);
            rs= pstmt.executeQuery();
            System.out.println("ID\t\tNAME\t\tDESIGNATION\t\tSALARY");
            while(rs.next())
            {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String desg = rs.getString(3);
                double sal = rs.getDouble(4);
                System.out.println("===================================================");
                System.out.println(id+ "\t" +name+ "\t" +desg+ "\t" +sal);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            if (con != null)
            {
                try
                {
                    con.close();
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }

            if (pstmt != null)
            {
                try
                {
                    pstmt.close();
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    //sign up
    public void signUp(String user, String pass) {


        String query = "insert into emp_data(user_name, password)  values('"+user+"', "+pass+")";

        try {

            pstmt = con.prepareStatement(query);
            int count1 = pstmt.executeUpdate();
            System.out.println(count1 + " Registration Successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

}

