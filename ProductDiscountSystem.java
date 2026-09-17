import java.util.Scanner;

abstract class Product {
    String id;
    String name;
    double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public double finalPrice() {
        return price - calculateDiscount();
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Final Price: " + finalPrice());
        System.out.println("------------------------");
    }
}

class Electronics extends Product {
    public Electronics(String id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return price * 0.10;
    }
}

class Clothing extends Product {
    public Clothing(String id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return price * 0.20;
    }
}

class Books extends Product {
    public Books(String id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return price * 0.05;
    }
}

public class ProductDiscountSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Electronics ID, name, price: ");
        Product p1 = new Electronics(sc.next(), sc.next(), sc.nextDouble());

        System.out.print("Enter Clothing ID, name, price: ");
        Product p2 = new Clothing(sc.next(), sc.next(), sc.nextDouble());

        System.out.print("Enter Books ID, name, price: ");
        Product p3 = new Books(sc.next(), sc.next(), sc.nextDouble());

        p1.display();
        p2.display();
        p3.display();

        sc.close();
    }
}

//INPUT OUTPUT

Enter Electronics ID, name, price: 23
headphone
450
Enter Clothing ID, name, price: 134
levis
600
Enter Books ID, name, price: 545
Harrypotter
230
ID: 23
Name: headphone
Price: 450.0
Discount: 45.0
Final Price: 405.0
------------------------
ID: 134
Name: levis
Price: 600.0
Discount: 120.0
Final Price: 480.0
------------------------
ID: 545
Name: Harrypotter
Price: 230.0
Discount: 11.5
Final Price: 218.5
------------------------