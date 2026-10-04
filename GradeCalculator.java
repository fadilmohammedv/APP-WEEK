import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GradeModel {
    String name;
    int m1, m2, m3;

    void setData(String name, int m1, int m2, int m3) {
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    int getTotal() {
        return m1 + m2 + m3;
    }

    double getAverage() {
        return getTotal() / 3.0;
    }

    String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 50) return "D";
        else return "F";
    }
}

class GradeView extends JFrame {
    JTextField name = new JTextField(15);
    JTextField s1 = new JTextField(5);
    JTextField s2 = new JTextField(5);
    JTextField s3 = new JTextField(5);
    JButton calc = new JButton("Calculate Result");
    JLabel result = new JLabel("");

    GradeView() {
        setLayout(new FlowLayout());
        add(new JLabel("Student Name:"));
        add(name);
        add(new JLabel("Subject 1:"));
        add(s1);
        add(new JLabel("Subject 2:"));
        add(s2);
        add(new JLabel("Subject 3:"));
        add(s3);
        add(calc);
        add(result);

        setTitle("Student Grade Calculator");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class GradeController implements ActionListener {
    GradeModel model;
    GradeView view;

    GradeController(GradeModel model, GradeView view) {
        this.model = model;
        this.view = view;
        view.calc.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int a = Integer.parseInt(view.s1.getText());
            int b = Integer.parseInt(view.s2.getText());
            int c = Integer.parseInt(view.s3.getText());
            model.setData(view.name.getText(), a, b, c);
            view.result.setText("<html>Name: " + model.name + "<br>Total: " + model.getTotal() + "<br>Average: " + String.format("%.2f", model.getAverage()) + "<br>Grade: " + model.getGrade() + "</html>");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Enter valid marks");
        }
    }
}

public class GradeCalculator {
    public static void main(String[] args) {
        GradeModel model = new GradeModel();
        GradeView view = new GradeView();
        new GradeController(model, view);
    }
}
