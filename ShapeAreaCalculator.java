import java.util.Scanner;

abstract class Shape {
    public abstract double calculateArea();
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }
}

class Triangle extends Shape {
    double base, height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius of circle: ");
        double radius = sc.nextDouble();

        System.out.print("Enter length and width of rectangle: ");
        double length = sc.nextDouble();
        double width = sc.nextDouble();

        System.out.print("Enter base and height of triangle: ");
        double base = sc.nextDouble();
        double height = sc.nextDouble();

        Shape c = new Circle(radius);
        Shape r = new Rectangle(length, width);
        Shape t = new Triangle(base, height);

        System.out.println("Area of Circle: " + c.calculateArea());
        System.out.println("Area of Rectangle: " + r.calculateArea());
        System.out.println("Area of Triangle: " + t.calculateArea());

        sc.close();
    }
}

//INPUT OUTPUT

Enter radius of circle: 12
Enter length and width of rectangle: 20
15
Enter base and height of triangle: 10
30 
Area of Circle: 452.3893421169302
Area of Rectangle: 300.0
Area of Triangle: 150.0