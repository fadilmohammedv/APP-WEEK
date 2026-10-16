public class Question5 {
    public static void main(String[] args) {
        String[][] students = {
            {"Arun", "Pass", "Pass"},
            {"Bala", "Pass", "Fail"},
            {"Charan", "Pass", "Pass"},
            {"Divya", "Fail", "Pass"}
        };

        System.out.println("Eligible students:");
        for (String[] student : students) {
            if (student[1].equals("Pass") && student[2].equals("Pass")) {
                System.out.println(student[0]);
            }
        }
    }
}
