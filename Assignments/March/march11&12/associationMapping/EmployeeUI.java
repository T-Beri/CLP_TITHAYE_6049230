package cgDemo.associationMapping;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import cgDemo.associationMapping.EmployeeDAO;

public class EmployeeUI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        System.out.println("Starting App!");

        while (true) {

            System.out.println("\n---- EMPLOYEE MENU ----");
            System.out.println("1 Insert Employee");
            System.out.println("2 Fetch all records of Employee along with dept name and manager name");
            System.out.println("3 Fetch number of employees working under each dept");
            System.out.println("4 Fetch records of all employees working under given dept");
            System.out.println("5 Fetch dept details of emp along with empId, name, sal, mobile no");

            System.out.print("Enter choice : ");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                Employee e = new Employee();
                Department d = new Department();

                System.out.print("Enter Employee Name: ");
                e.setEmpname(sc.next());

                System.out.print("Enter Salary: ");
                e.setSalary(sc.nextInt());

                System.out.print("Enter Department ID: ");
                d.setDeptid(sc.nextInt());

                System.out.print("Enter Department Name: ");
                d.setName(sc.next());

                System.out.print("Enter Manager Name: ");
                d.setMgrname(sc.next());

                // mobile numbers
                Set<Long> mobiles = new HashSet<>();

                System.out.print("How many mobile numbers? ");
                int n = sc.nextInt();

                for (int i = 0; i < n; i++) {
                    System.out.print("Enter mobile number: ");
                    mobiles.add(sc.nextLong());
                }

                e.setMobilenos(mobiles);

                dao.insertEmployee(e, d);

                System.out.println("Employee inserted successfully");
                break;

            case 2:

                dao.fetchEmployeeDetails();;
                break;

            case 3:

                dao.countEmployeesPerDept();
                break;

            case 4:

                System.out.print("Enter department name: ");
                String deptName = sc.next();

                dao.fetchEmployeesByDept(deptName);
                break;

            case 5:

                System.out.print("Enter mobile number: ");
                long mobile = sc.nextInt();

                dao.fetchDeptUsingMobile(mobile);
                break;

            default:
                System.out.println("Invalid choice");

            }

        }

    }
}

