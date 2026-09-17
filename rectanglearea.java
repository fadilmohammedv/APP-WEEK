public class rectanglearea {

    static class Rectangle {
        double length;
        double breadth;

        Rectangle(double length, double breadth) {
            this.length = length;
            this.breadth = breadth;
        }

        void displayArea() {
            double area = length * breadth;
            System.out.println("Area of Rectangle: " + area);
        }
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 5);

        r1.displayArea();
    }
}
