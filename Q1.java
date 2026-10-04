class EmergencyAlert extends Thread {
    EmergencyAlert() { super("EmergencyAlert"); }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " | Priority: " + getPriority() + " | Critical patient alert #" + i);
            try { Thread.sleep(300); } catch (InterruptedException e) { }
        }
    }
}

class VitalMonitor extends Thread {
    VitalMonitor() { super("VitalMonitor"); }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " | Priority: " + getPriority() + " | Checking vital signs, round " + i);
            try { Thread.sleep(300); } catch (InterruptedException e) { }
        }
    }
}

class ReportGenerator extends Thread {
    ReportGenerator() { super("ReportGenerator"); }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " | Priority: " + getPriority() + " | Preparing routine report part " + i);
            try { Thread.sleep(300); } catch (InterruptedException e) { }
        }
    }
}

public class Q1_HospitalMonitor {
    public static void main(String[] args) {
        EmergencyAlert alert = new EmergencyAlert();
        VitalMonitor vital = new VitalMonitor();
        ReportGenerator report = new ReportGenerator();

        alert.setPriority(Thread.MAX_PRIORITY);   // 10
        vital.setPriority(Thread.NORM_PRIORITY);  // 5
        report.setPriority(Thread.MIN_PRIORITY);  // 1

        alert.start();
        vital.start();
        report.start();
    }
}
