import java.sql.*;
import java.util.Scanner;

public class BookDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "1234567890");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Insert Book");
            System.out.println("2. Search Book");
            System.out.println("3. Display Available Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Book ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Title: ");
                String title = sc.nextLine();
                System.out.print("Author: ");
                String author = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();

                PreparedStatement ps = con.prepareStatement("INSERT INTO Book VALUES (?, ?, ?, ?, ?)");
                ps.setInt(1, id);
                ps.setString(2, title);
                ps.setString(3, author);
                ps.setDouble(4, price);
                ps.setString(5, "Available");
                ps.executeUpdate();
                System.out.println("Book inserted");
            } else if (ch == 2) {
                System.out.print("Book ID: ");
                int id = sc.nextInt();

                PreparedStatement ps = con.prepareStatement("SELECT * FROM Book WHERE BookID = ?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getDouble(4) + " | " + rs.getString(5));
                } else {
                    System.out.println("Book not found");
                }
            } else if (ch == 3) {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM Book WHERE Availability = 'Available'");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getDouble(4) + " | " + rs.getString(5));
                }
            } else if (ch == 4) {
                System.out.print("Book ID to issue: ");
                int id = sc.nextInt();

                PreparedStatement ps = con.prepareStatement("UPDATE Book SET Availability = 'Issued' WHERE BookID = ?");
                ps.setInt(1, id);
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("Book issued");
                } else {
                    System.out.println("Book not found");
                }
            } else {
                break;
            }
        }
        con.close();
    }
}




//output 

   
1. Insert Book
2. Search Book
3. Display Available Books
4. Issue Book
5. Exit
Enter choice: 1
Book ID: 543
Title: booktest
Author: authortest
Price: 456
Book inserted

1. Insert Book
2. Search Book
3. Display Available Books
4. Issue Book
5. Exit
Enter choice: 2
Book ID: 543
543 | booktest | authortest | 456.0 | Available

1. Insert Book
2. Search Book
3. Display Available Books
4. Issue Book
5. Exit
Enter choice: 3
543 | booktest | authortest | 456.0 | Available

1. Insert Book
2. Search Book
3. Display Available Books
4. Issue Book
5. Exit
Enter choice: 4
Book ID to issue: 543
Book issued

1. Insert Book
2. Search Book
3. Display Available Books
4. Issue Book
5. Exit
Enter choice: 5