import java.sql.*;
import java.util.Scanner;

public class CourseSearch {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "1234567890");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Course Code: ");
        String code = sc.nextLine();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM CourseRegistration WHERE CourseCode = ?");
        ps.setString(1, code);
        ResultSet rs = ps.executeQuery();

        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getString(4) + " | " + rs.getString(5));
        }

        if (!found) {
            System.out.println("No students registered for this course");
        }
        con.close();
    }
}
