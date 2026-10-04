import javax.swing.*;
import java.awt.*;

public class Q3_StudentRegistration extends JFrame {
    JTextField nameField = new JTextField(15);
    JTextField regField = new JTextField(15);
    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    JRadioButton other = new JRadioButton("Other");
    JComboBox<String> dept = new JComboBox<>(new String[]{"CSE", "ECE", "EEE", "MECH", "CIVIL", "IT"});
    JButton submit = new JButton("Submit");

    public Q3_StudentRegistration() {
        setTitle("Student Registration");
        setLayout(new GridLayout(5, 2, 8, 8));

        ButtonGroup g = new ButtonGroup();
        g.add(male); g.add(female); g.add(other);
        JPanel genderPanel = new JPanel();
        genderPanel.add(male); genderPanel.add(female); genderPanel.add(other);

        add(new JLabel("  Name:")); add(nameField);
        add(new JLabel("  Register No:")); add(regField);
        add(new JLabel("  Gender:")); add(genderPanel);
        add(new JLabel("  Department:")); add(dept);
        add(new JLabel("")); add(submit);

        submit.addActionListener(e -> {
            String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : other.isSelected() ? "Other" : "";
            if (nameField.getText().trim().isEmpty() || regField.getText().trim().isEmpty() || gender.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all the fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this,
                    "Name: " + nameField.getText() + "\nRegister No: " + regField.getText()
                            + "\nGender: " + gender + "\nDepartment: " + dept.getSelectedItem(),
                    "Registration Details", JOptionPane.INFORMATION_MESSAGE);
        });

        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Q3_StudentRegistration::new);
    }
}
