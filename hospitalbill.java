import java.util.Scanner;

class Patient {
    String name;
    double fee;

    Patient(String name, double fee) {
        this.name = name;
        this.fee = fee;
    }

    double calculateFinalAmount(double fee) {
        double discount;

        if (fee >= 2000)
            discount = fee * 0.10;
        else
            discount = fee * 0.05;

        return fee - discount;
    }

    void display() {
        double finalAmount = calculateFinalAmount(fee);
        double discount = fee - finalAmount;

        System.out.println("Patient Name: " + name);
        System.out.println("Original Consultation Fee: Rs." + fee);
        System.out.println("Discount: Rs." + discount);
        System.out.println("Final Amount: Rs." + finalAmount);
        System.out.println();
    }
}

public class hospitalbill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Patient[] patients = new Patient[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Patient " + (i + 1));

            System.out.print("Patient Name: ");
            String name = sc.next();

            System.out.print("Consultation Fee: ");
            double fee = sc.nextDouble();

            patients[i] = new Patient(name, fee);
        }

        System.out.println("\n----- CONSULTATION BILL -----");

        for (int i = 0; i < 5; i++) {
            patients[i].display();
        }

        sc.close();
    }
}