public class shapearea {

    static class Area {

        // Area of square
        double calculate(double side) {
            return side * side;
        }

        // Area of rectangle
        double calculate(double length, double breadth) {
            return length * breadth;
        }

        // Area of circle
        double calculate(float radius) {
            return 3.14 * radius * radius;
        }
    }

    public static void main(String[] args) {
        Area a = new Area();

        double squareArea = a.calculate(5.0);
        double rectangleArea = a.calculate(10.0, 5.0);
        double circleArea = a.calculate(7.0f);

        System.out.println("Area of Square : " + squareArea);
        System.out.println("Area of Rectangle : " + rectangleArea);
        System.out.println("Area of Circle : " + circleArea);
    }
}
