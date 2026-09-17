import student.Student;
import course.Course;

public class Main {
    public static void main(String[] args) {

        Student s = new Student("Fadil", 101, "CSE");
        Course c = new Course("Java Programming", "21CSC201T", 4);

        System.out.println("Student Information");
        s.displayDetails();

        System.out.println();

        System.out.println("Course Information");
        c.displayDetails();
    }
}