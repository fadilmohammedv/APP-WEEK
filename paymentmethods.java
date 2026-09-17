interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Credit Card Payment: Rs." + amount);
    }
}

class UPIPayment implements Payment {
    public void pay(double amount) {
        System.out.println("UPI Payment: Rs." + amount);
    }
}

class NetBankingPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Net Banking Payment: Rs." + amount);
    }
}

public class paymentmethods {
    public static void main(String[] args) {
        Payment p;

        p = new CreditCardPayment();
        p.pay(1000);

        p = new UPIPayment();
        p.pay(1500);

        p = new NetBankingPayment();
        p.pay(2000);
    }
}
