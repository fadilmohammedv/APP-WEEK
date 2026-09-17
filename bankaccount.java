import java.util.Scanner;

class Account {
    private String accNo;
    private String name;
    private double balance;

    public Account(String accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
        display();
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
            display();
        }
    }

    public void display() {
        System.out.println("Account No: " + accNo);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
        System.out.println("------------------------");
    }
}

public class bankaccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accNo = sc.next();
        System.out.print("Enter account holder name: ");
        String name = sc.next();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        Account account = new Account(accNo, name, balance);
        account.display();

        System.out.print("Enter amount to deposit: ");
        double dep = sc.nextDouble();
        account.deposit(dep);

        System.out.print("Enter amount to withdraw: ");
        double wd = sc.nextDouble();
        account.withdraw(wd);

        sc.close();
    }
}