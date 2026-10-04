import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Q5_CourseManagement extends JFrame {
    String[] courses = {"Java Programming", "Data Structures", "Operating Systems", "DBMS", "Computer Networks", "Machine Learning", "Web Technologies"};
    JList<String> courseList = new JList<>(courses);
    JTextField nameField = new JTextField(12);
    DefaultTableModel model = new DefaultTableModel(new String[]{"Student Name", "Selected Course", "Enrollment Status"}, 0);
    JTable table = new JTable(model);
    JButton add = new JButton("Add Registration");
    JButton remove = new JButton("Remove Registration");

    public Q5_CourseManagement() {
        setTitle("Student Course Management");
        setLayout(new BorderLayout(10, 10));

        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScroll = new JScrollPane(courseList);
        listScroll.setBorder(BorderFactory.createTitledBorder("Available Courses"));
        listScroll.setPreferredSize(new Dimension(180, 0));

        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setBorder(BorderFactory.createTitledBorder("Registrations"));

        JPanel bottom = new JPanel();
        bottom.add(new JLabel("Student Name:"));
        bottom.add(nameField);
        bottom.add(add);
        bottom.add(remove);

        add(listScroll, BorderLayout.WEST);
        add(tableScroll, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        add.addActionListener(e -> {
            String name = nameField.getText().trim();
            String course = courseList.getSelectedValue();
            if (name.isEmpty() || course == null) {
                JOptionPane.showMessageDialog(this, "Enter a student name and select a course!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            model.addRow(new Object[]{name, course, "Enrolled"});
            nameField.setText("");
        });

        remove.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a row to remove!", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            model.removeRow(row);
        });

        setSize(700, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Q5_CourseManagement::new);
    }
}
