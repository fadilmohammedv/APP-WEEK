import java.sql.*;
import java.util.Scanner;

public class ProductDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "1234567890");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Insert Product");
            System.out.println("2. Search Product");
            System.out.println("3. Update Quantity");
            System.out.println("4. Display Products with Quantity below 10");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Product ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Product Name: ");
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                System.out.print("Quantity: ");
                int qty = sc.nextInt();

                PreparedStatement ps = con.prepareStatement("INSERT INTO Product VALUES (?, ?, ?, ?)");
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setDouble(3, price);
                ps.setInt(4, qty);
                ps.executeUpdate();
                System.out.println("Product inserted");
            } else if (ch == 2) {
                System.out.print("Product ID: ");
                int id = sc.nextInt();

                PreparedStatement ps = con.prepareStatement("SELECT * FROM Product WHERE ProductID = ?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getDouble(3) + " | " + rs.getInt(4));
                } else {
                    System.out.println("Product not found");
                }
            } else if (ch == 3) {
                System.out.print("Product ID: ");
                int id = sc.nextInt();
                System.out.print("New Quantity: ");
                int qty = sc.nextInt();

                PreparedStatement ps = con.prepareStatement("UPDATE Product SET Quantity = ? WHERE ProductID = ?");
                ps.setInt(1, qty);
                ps.setInt(2, id);
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("Quantity updated");
                } else {
                    System.out.println("Product not found");
                }
            } else if (ch == 4) {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM Product WHERE Quantity < 10");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getDouble(3) + " | " + rs.getInt(4));
                }
            } else {
                break;
            }
        }
        con.close();
    }
}

//output 


1. Insert Product
2. Search Product
3. Update Quantity
4. Display Products with Quantity below 10
5. Exit
Enter choice: 1
Product ID: 123
Product Name: soap
Price: 54
Quantity: 2
Product inserted

1. Insert Product
2. Search Product
3. Update Quantity
4. Display Products with Quantity below 10
5. Exit
Enter choice: 2
Product ID: 123
123 | soap | 54.0 | 2

1. Insert Product
2. Search Product
3. Update Quantity
4. Display Products with Quantity below 10
5. Exit
Enter choice: 3
Product ID: 123
New Quantity: 3
Quantity updated

1. Insert Product
2. Search Product
3. Update Quantity
4. Display Products with Quantity below 10
5. Exit
Enter choice: 4
123 | soap | 54.0 | 3

1. Insert Product
2. Search Product
3. Update Quantity
4. Display Products with Quantity below 10
5. Exit
Enter choice: 5
