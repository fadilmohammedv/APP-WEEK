class Vehicle {
    String vehicleNumber;
    String brand;
    int speed;

    Vehicle(String vehicleNumber, String brand, int speed) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.speed = speed;
    }

    void displayDetails() {
        System.out.println("Vehicle Details");
    }
}

class Car extends Vehicle {
    int numberOfDoors;

    Car(String vehicleNumber, String brand, int speed, int numberOfDoors) {
        super(vehicleNumber, brand, speed);
        this.numberOfDoors = numberOfDoors;
    }

    void displayDetails() {
        System.out.println("Car Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}

class Bike extends Vehicle {
    boolean hasGear;

    Bike(String vehicleNumber, String brand, int speed, boolean hasGear) {
        super(vehicleNumber, brand, speed);
        this.hasGear = hasGear;
    }

    void displayDetails() {
        System.out.println("Bike Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Has Gear: " + hasGear);
    }
}

public class vehiclepolymorphism {
    public static void main(String[] args) {
        Vehicle v;

        v = new Car("TN01AB1234", "Toyota", 120, 4);
        v.displayDetails();

        System.out.println();

        v = new Bike("TN02CD5678", "Yamaha", 100, true);
        v.displayDetails();
    }
}
