public class carregistration {

    static class Car {
        String model;
        double price;

        // No details
        Car() {
            model = "Not Given";
            price = 0;
        }

        // Only model
        Car(String model) {
            this.model = model;
            price = 0;
        }

        // Model and price
        Car(String model, double price) {
            this.model = model;
            this.price = price;
        }

        void display() {
            System.out.println("Model Name : " + model);
            System.out.println("Price : " + price);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Car c1 = new Car();
        Car c2 = new Car("Toyota");
        Car c3 = new Car("Honda City", 1200000);

        System.out.println("Car 1:");
        c1.display();

        System.out.println("Car 2:");
        c2.display();

        System.out.println("Car 3:");
        c3.display();
    }
}
