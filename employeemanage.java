import java.util.Scanner;

abstract class Employee {
    String name;
    String id;
    double basicSalary;

    public Employee(String name, String id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
    }

    public abstract double calculateSalary();

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
        System.out.println("------------------------");
    }
}

class Professor extends Employee {
    public Professor(String name, String id, double basicSalary) {
        super(name, id, basicSalary);
    }

    public double calculateSalary() {
        return basicSalary + 15000; // research allowance
    }
}

class LabAssistant extends Employee {
    public LabAssistant(String name, String id, double basicSalary) {
        super(name, id, basicSalary);
    }

    public double calculateSalary() {
        return basicSalary + 5000; // lab allowance
    }
}

class AdministrativeStaff extends Employee {
    public AdministrativeStaff(String name, String id, double basicSalary) {
        super(name, id, basicSalary);
    }

    public double calculateSalary() {
        return basicSalary + 3000; // office allowance
    }
}

public class employeemanage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Professor name, ID, basic salary: ");
        Employee e1 = new Professor(sc.next(), sc.next(), sc.nextDouble());

        System.out.print("Enter Lab Assistant name, ID, basic salary: ");
        Employee e2 = new LabAssistant(sc.next(), sc.next(), sc.nextDouble());

        System.out.print("Enter Admin Staff name, ID, basic salary: ");
        Employee e3 = new AdministrativeStaff(sc.next(), sc.next(), sc.nextDouble());

        e1.display();
        e2.display();
        e3.display();

        sc.close();
    }
}

//INPUT OUTPUT

Enter Professor name, ID, basic salary: drsreekumar     
4354
50000
Enter Lab Assistant name, ID, basic salary: akul
564
15000
Enter Admin Staff name, ID, basic salary: joseph
124
30000

ID: 4354
Name: drsreekumar
Salary: 65000.0
------------------------
ID: 564
Name: akul
Salary: 20000.0
------------------------
ID: 124
Name: joseph
Salary: 33000.0
------------------------