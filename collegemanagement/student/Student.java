package student;

public class Student{
    String name;
    int rollno;
    String department;

    public Student(String name, int rollno, String department){
        this.name = name;
        this.rollno = rollno;
        this.department = department;
    }

    public void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollno);
        System.out.println("Department: " + department);
        
    }
}