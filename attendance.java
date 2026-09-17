import java.util.Scanner;

public class attendance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] days = new int[7];
        int present = 0;

        System.out.println("Enter attendance for 7 days (1 for Present, 0 for Absent):");

        for (int i = 0; i < 7; i++) {
            days[i] = sc.nextInt();

            if (days[i] == 1) {
                present++;
            }
        }

        double percentage = (present * 100.0) / 7;

        System.out.println("Present Days : " + present);
        System.out.println("Attendance : " + percentage + "%");

        if (percentage >= 75) {
            System.out.println("Eligible for Exam");
        } else {
            System.out.println("Not Eligible");
        }

        sc.close();
    }
}
