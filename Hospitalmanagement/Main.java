import doctor.Doctor;
import patient.Patient;

public class Main {
    public static void main(String[] args) {

        Doctor d1 = new Doctor(101, "Dr. Ravi", "Cardiology", 500);
        Doctor d2 = new Doctor(102, "Dr. Priya", "Dermatology", 400);

        Patient p1 = new Patient(1, "Arun", "Heart Disease", 25);
        Patient p2 = new Patient(2, "Rahul", "Skin Allergy", 30);
        Patient p3 = new Patient(3, "Anu", "Heart Disease", 22);

        double total1 = 0;
        double total2 = 0;

        System.out.println("Patient Details:");
        p1.displayPatient();
        d1.displayDoctor();
        total1 += d1.getConsultationFee();

        System.out.println();

        p2.displayPatient();
        d2.displayDoctor();
        total2 += d2.getConsultationFee();

        System.out.println();

        p3.displayPatient();
        d1.displayDoctor();
        total1 += d1.getConsultationFee();

        System.out.println("\nTotal Fees Collected:");
        System.out.println(d1.getName() + ": Rs." + total1);
        System.out.println(d2.getName() + ": Rs." + total2);
    }
}