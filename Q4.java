import javax.swing.*;
import java.awt.*;

public class Q4_UserLogin extends JFrame {
    JTextField userField = new JTextField(15);
    JPasswordField passField = new JPasswordField(15);
    JCheckBox remember = new JCheckBox("Remember Me");
    JCheckBox notifications = new JCheckBox("Receive Notifications");
    JButton login = new JButton("Login");

    public Q4_UserLogin() {
        setTitle("User Login");
        setLayout(new GridLayout(5, 2, 8, 8));

        add(new JLabel("  Username:")); add(userField);
        add(new JLabel("  Password:")); add(passField);
        add(remember); add(notifications);
        add(new JLabel("")); add(login);

        login.addActionListener(e -> {
            String user = userField.getText().trim();
            String pass = new String(passField.getPassword());
            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username and password cannot be empty!", "Login Failed", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // demo credentials: admin / 1234
            if (user.equals("admin") && pass.equals("1234")) {
                String msg = "Login successful! Welcome, " + user + ".";
                msg += "\nRemember Me: " + (remember.isSelected() ? "Yes" : "No");
                msg += "\nNotifications: " + (notifications.isSelected() ? "On" : "Off");
                JOptionPane.showMessageDialog(this, msg, "Login Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });

        setSize(400, 260);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Q4_UserLogin::new);
    }
}
