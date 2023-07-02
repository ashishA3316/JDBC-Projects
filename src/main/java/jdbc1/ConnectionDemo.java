package jdbc1;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) {
        try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "Ashish@3316");
            System.out.println("Connection Successful");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
