import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ServiceModel {
    int calculateCost(boolean general, boolean oil, boolean brake, boolean battery) {
        int cost = 0;
        if (general) cost += 1000;
        if (oil) cost += 800;
        if (brake) cost += 1200;
        if (battery) cost += 500;
        return cost;
    }
}

class ServiceView extends JFrame {
    JTextField regNo = new JTextField(12);
    JComboBox<String> type = new JComboBox<>(new String[] {"Two Wheeler", "Car"});
    JCheckBox general = new JCheckBox("General Service - Rs.1000");
    JCheckBox oil = new JCheckBox("Oil Change - Rs.800");
    JCheckBox brake = new JCheckBox("Brake Service - Rs.1200");
    JCheckBox battery = new JCheckBox("Battery Check - Rs.500");
    JButton calc = new JButton("Calculate Cost");
    JLabel result = new JLabel("");

    ServiceView() {
        setLayout(new FlowLayout());
        add(new JLabel("Registration No:"));
        add(regNo);
        add(new JLabel("Vehicle Type:"));
        add(type);
        add(general);
        add(oil);
        add(brake);
        add(battery);
        add(calc);
        add(result);

        setTitle("Vehicle Service Cost Estimator");
        setSize(300, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class ServiceController implements ActionListener {
    ServiceModel model;
    ServiceView view;

    ServiceController(ServiceModel model, ServiceView view) {
        this.model = model;
        this.view = view;
        view.calc.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        int cost = model.calculateCost(view.general.isSelected(), view.oil.isSelected(), view.brake.isSelected(), view.battery.isSelected());
        view.result.setText("<html>Vehicle: " + view.regNo.getText() + " (" + view.type.getSelectedItem() + ")<br>Total Cost: Rs." + cost + "</html>");
    }
}

public class ServiceCostEstimator {
    public static void main(String[] args) {
        ServiceModel model = new ServiceModel();
        ServiceView view = new ServiceView();
        new ServiceController(model, view);
    }
}
