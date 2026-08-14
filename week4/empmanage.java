import java.util.Scanner;

class Employee {
    int id;
    String name;
    double monthlySalary;

    Employee(int id, String name, double monthlySalary) {
        this.id = id;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    double calculateAnnualSalary() {
        return monthlySalary * 12;
    }

    double calculateBonus() {
        if (monthlySalary >= 30000)
            return calculateAnnualSalary() * 0.10;
        else
            return 0;
    }

    void display() {
        double annualSalary = calculateAnnualSalary();
        double bonus = calculateBonus();

        String eligibility = monthlySalary >= 30000
                ? "Eligible" : "Not Eligible";

        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Monthly Salary: Rs." + monthlySalary);
        System.out.println("Annual Salary: Rs." + annualSalary);
        System.out.println("Bonus: Rs." + bonus);
        System.out.println("Bonus Eligibility: " + eligibility);
        System.out.println();
    }
}

public class empmanage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee[] employees = new Employee[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Employee " + (i + 1));

            System.out.print("Employee ID: ");
            int id = sc.nextInt();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Monthly Salary: ");
            double salary = sc.nextDouble();

            employees[i] = new Employee(id, name, salary);
            System.out.println();
        }

        System.out.println("----- EMPLOYEE DETAILS -----");

        for (int i = 0; i < 5; i++) {
            employees[i].display();
        }

        sc.close();
    }
}