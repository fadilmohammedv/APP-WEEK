import java.util.Scanner;

public class employeedetails {

    static class Employee {
        int employeeId;
        String employeeName;
        double salary;

        Employee(int employeeId, String employeeName, double salary) {
            this.employeeId = employeeId;
            this.employeeName = employeeName;
            this.salary = salary;
        }

        void display() {
            System.out.println("Employee ID : " + employeeId);
            System.out.println("Employee Name : " + employeeName);
            System.out.println("Salary : " + salary);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Employee ID : ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Employee Name : ");
        String name = sc.nextLine();

        System.out.print("Salary : ");
        double salary = sc.nextDouble();

        Employee e1 = new Employee(id, name, salary);

        e1.display();

        sc.close();
    }
}
