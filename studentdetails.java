public class studentdetails {

    static class Student {
        String name;
        int rollNumber;
        String department;

        Student(String name, int rollNumber, String department) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.department = department;
        }

        void display() {
            System.out.println("Student Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Department: " + department);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Fadil", 101, "CSE");

        s1.display();
    }
}
