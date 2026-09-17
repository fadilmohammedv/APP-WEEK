public class employeerecords {

    static class Employee {
        String name;
        int id;
        String department;

        Employee(String name, int id, String department) {
            this.name = name;
            this.id = id;
            this.department = department;
        }

        void display() {
            System.out.println("Name: " + name);
            System.out.println("Employee ID: " + id);
            System.out.println("Department: " + department);
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Akhil", 201, "IT");
        Employee e2 = new Employee("Nikhil", 202, "HR");

        System.out.println("Employee 1:");
        e1.display();

        System.out.println();

        System.out.println("Employee 2:");
        e2.display();
    }
}
