import java.util.Scanner;

interface PaymentMethod {
    void makePayment(double amount);
}

class UPI implements PaymentMethod {
    public void makePayment(double amount) {
        System.out.println("Paid " + amount + " using UPI.");
    }
}

class CreditCard implements PaymentMethod {
    public void makePayment(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class NetBanking implements PaymentMethod {
    public void makePayment(double amount) {
        System.out.println("Paid " + amount + " using Net Banking.");
    }
}

public class PaymentProcessingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select payment method: 1-UPI  2-Credit Card  3-Net Banking");
        int choice = sc.nextInt();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        PaymentMethod payment;

        if (choice == 1) {
            payment = new UPI();
        } else if (choice == 2) {
            payment = new CreditCard();
        } else {
            payment = new NetBanking();
        }

        payment.makePayment(amount);

        sc.close();
    }
}