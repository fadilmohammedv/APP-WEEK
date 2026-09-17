interface Payment {
    void pay(double amount);
}

interface SecurePayment extends Payment {
    void verifyPayment();
}

interface OnlineTransaction {
}

class Account {
    int accountNumber;
    String name;
    double balance;

    Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    void displayDetails() {
        System.out.println("Account Details");
    }
}

class SavingsAccount extends Account {
    SavingsAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
    }

    void displayDetails() {
        System.out.println("Savings Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: Rs." + balance);
    }
}

class CurrentAccount extends Account {
    CurrentAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
    }

    void displayDetails() {
        System.out.println("Current Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: Rs." + balance);
    }
}

class UPIPayment implements SecurePayment, OnlineTransaction {
    public void pay(double amount) {
        System.out.println("UPI Payment: Rs." + amount);
    }

    public void verifyPayment() {
        System.out.println("UPI Payment Verified");
    }
}

class CardPayment implements Payment, OnlineTransaction {
    public void pay(double amount) {
        System.out.println("Card Payment: Rs." + amount);
    }
}

public class onlinebanking {
    public static void main(String[] args) {
        Account a;

        a = new SavingsAccount(1001, "Rahul", 25000);
        a.displayDetails();

        System.out.println();

        a = new CurrentAccount(1002, "Arun", 40000);
        a.displayDetails();

        System.out.println();

        Payment p;

        p = new UPIPayment();
        p.pay(1500);

        UPIPayment upi = new UPIPayment();
        upi.verifyPayment();

        p = new CardPayment();
        p.pay(2000);

        System.out.println("UPI and Card payments are online transactions.");
    }
}
