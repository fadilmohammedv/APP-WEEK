import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class PortalModel {
    String password = "admin123";
    ArrayList<String> employees = new ArrayList<>();

    boolean checkLogin(String user, String pass) {
        return user.equals("admin") && pass.equals(password);
    }

    void addEmployee(String id, String name, String dept) {
        employees.add(id + " - " + name + " - " + dept);
    }
}

class PortalLoginView extends JFrame {
    JTextField user = new JTextField(15);
    JPasswordField pass = new JPasswordField(15);
    JButton login = new JButton("Login");

    PortalLoginView() {
        setLayout(new FlowLayout());
        add(new JLabel("Username:"));
        add(user);
        add(new JLabel("Password:"));
        add(pass);
        add(login);

        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class PortalMainView extends JFrame {
    JMenuItem addItem = new JMenuItem("Add Employee");
    JMenuItem viewItem = new JMenuItem("View Employee");
    JMenuItem changeItem = new JMenuItem("Change Password");
    JMenuItem logoutItem = new JMenuItem("Logout");
    JMenuItem exitItem = new JMenuItem("Exit Application");

    PortalMainView() {
        JMenu m1 = new JMenu("Employee");
        m1.add(addItem);
        m1.add(viewItem);
        JMenu m2 = new JMenu("Tools");
        m2.add(changeItem);
        JMenu m3 = new JMenu("Exit");
        m3.add(logoutItem);
        m3.add(exitItem);

        JMenuBar bar = new JMenuBar();
        bar.add(m1);
        bar.add(m2);
        bar.add(m3);
        setJMenuBar(bar);
        add(new JLabel("Welcome to Employee Management Portal", JLabel.CENTER));

        setTitle("Employee Management Portal");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    String[] askEmployee() {
        JTextField id = new JTextField();
        JTextField name = new JTextField();
        JTextField dept = new JTextField();
        Object[] fields = {"Employee ID:", id, "Employee Name:", name, "Department:", dept};
        int r = JOptionPane.showConfirmDialog(this, fields, "Add Employee", JOptionPane.OK_CANCEL_OPTION);
        if (r == JOptionPane.OK_OPTION) {
            return new String[] {id.getText(), name.getText(), dept.getText()};
        }
        return null;
    }

    String[] askPasswords() {
        JPasswordField oldP = new JPasswordField();
        JPasswordField newP = new JPasswordField();
        JPasswordField conP = new JPasswordField();
        Object[] fields = {"Old Password:", oldP, "New Password:", newP, "Confirm Password:", conP};
        int r = JOptionPane.showConfirmDialog(this, fields, "Change Password", JOptionPane.OK_CANCEL_OPTION);
        if (r == JOptionPane.OK_OPTION) {
            return new String[] {new String(oldP.getPassword()), new String(newP.getPassword()), new String(conP.getPassword())};
        }
        return null;
    }
}

class PortalController implements ActionListener {
    PortalModel model;
    PortalLoginView loginView;
    PortalMainView mainView;

    PortalController(PortalModel model, PortalLoginView loginView) {
        this.model = model;
        this.loginView = loginView;
        loginView.login.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if (s == loginView.login) {
            String p = new String(loginView.pass.getPassword());
            if (model.checkLogin(loginView.user.getText(), p)) {
                JOptionPane.showMessageDialog(loginView, "Login Successful");
                loginView.setVisible(false);
                mainView = new PortalMainView();
                mainView.addItem.addActionListener(this);
                mainView.viewItem.addActionListener(this);
                mainView.changeItem.addActionListener(this);
                mainView.logoutItem.addActionListener(this);
                mainView.exitItem.addActionListener(this);
            } else {
                JOptionPane.showMessageDialog(loginView, "Invalid username or password");
            }
        } else if (s == mainView.addItem) {
            String[] d = mainView.askEmployee();
            if (d != null) {
                model.addEmployee(d[0], d[1], d[2]);
                JOptionPane.showMessageDialog(mainView, "Employee added");
            }
        } else if (s == mainView.viewItem) {
            if (model.employees.isEmpty()) {
                JOptionPane.showMessageDialog(mainView, "No employees added");
            } else {
                String all = "";
                for (String emp : model.employees) {
                    all += emp + "\n";
                }
                JOptionPane.showMessageDialog(mainView, all);
            }
        } else if (s == mainView.changeItem) {
            String[] p = mainView.askPasswords();
            if (p != null) {
                if (!p[0].equals(model.password)) {
                    JOptionPane.showMessageDialog(mainView, "Old password is wrong");
                } else if (!p[1].equals(p[2])) {
                    JOptionPane.showMessageDialog(mainView, "New and confirm password do not match");
                } else {
                    model.password = p[1];
                    JOptionPane.showMessageDialog(mainView, "Password changed");
                }
            }
        } else if (s == mainView.logoutItem) {
            mainView.dispose();
            loginView.pass.setText("");
            loginView.setVisible(true);
        } else if (s == mainView.exitItem) {
            System.exit(0);
        }
    }
}

public class EmployeePortal {
    public static void main(String[] args) {
        PortalModel model = new PortalModel();
        PortalLoginView view = new PortalLoginView();
        new PortalController(model, view);
    }
}
