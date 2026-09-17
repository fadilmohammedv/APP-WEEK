import Student.Student;
import Course.Course;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Rahul", 101, "CSE");
        Course c = new Course("Java OOP", 501);

        s.displayDetails();
        System.out.println();
        c.displayDetails();
    }
}
