package employeeOperations;

import java.util.Scanner;
import java.sql.*;

public class MainApp1 {
    public static void main(String[] args) {
        Employee_data e1 = new Employee_data();
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Mode of Operation");
        System.out.println("1: Enter with MAXIMUM salary");
        System.out.println("2: Enter with MINIMUM salary");
        int choice = sc.nextInt();
        if(choice == 1)
        {
            e1.maxsal();
        }
        else if (choice == 2)
        {
            e1.minsal();
        }

    }
}
