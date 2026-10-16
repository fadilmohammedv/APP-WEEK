public class Question6 {
    public static void main(String[] args) {
        String[][] employees = {
            {"Ravi", "6", "Completed", "5"},
            {"Priya", "3", "Completed", "4"},
            {"Kumar", "8", "Not Completed", "5"},
            {"Meena", "7", "Completed", "4"}
        };

        System.out.println("Employees eligible for promotion:");
        for (String[] employee : employees) {
            int experience = Integer.parseInt(employee[1]);
            int rating = Integer.parseInt(employee[3]);

            if (experience >= 5 && employee[2].equals("Completed") && rating >= 4) {
                System.out.println(employee[0]);
            }
        }
    }
}
