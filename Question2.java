public class Question2 {
    public static void main(String[] args) {
        int[] salaries = {35000, 42000, 28000, 50000, 39000};
        double total = 0;

        for (int i = 0; i < salaries.length; i++) {
            if (salaries[i] < 40000) {
                salaries[i] = (int) (salaries[i] * 1.10);
            }
            total += salaries[i];
        }

        System.out.print("Revised salaries: ");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }

        System.out.println("\nTotal salary expenditure: " + total);
    }
}
