package employeeOperations;

import java.util.Scanner;

public class Employee_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManager em = new EmployeeManager();

        System.out.println("1: LOGIN");
        System.out.println("2: SIGN UP");
        int choice = sc.nextInt();
        if(choice==1)
        {
            System.out.println("Enter the User Name");
            String user = sc.next();
            System.out.println("Enter the Password");
            String pass = sc.next();
            boolean status = em.login(user, pass);
            if (status==true)
            {
                System.out.println("Select Mode of Operation");
                System.out.println("1: Add Employee");
                System.out.println("2: View Employee");
                int type = sc.nextInt();
                if(type==1)
                {
                    System.out.println("Enter Employee Name");
                    String name = sc.next();
                    System.out.println("Enter Employee Designation");
                    String desg = sc.next();
                    System.out.println("Enter Employee Salary");
                    double sal = sc.nextDouble();
                    em.addEmployee(name, desg, sal);
                }
                else if (type==2)
                {
                    em.viewEmployee();
                }
                else
                {
                    System.out.println("Invalid Operation");
                }
            }
            else
            {
                System.out.println("Invalid Login Credentials");
            }

        }
        else if (choice==2)
        {
            System.out.println("Enter User Name");
            String user = sc.next();
            System.out.println("Enter Password");
            String pass = sc.next();
            em.signUp(user, pass);
        }
        else
        {
            System.out.println("Invalid Choice");
        }
    }
}
