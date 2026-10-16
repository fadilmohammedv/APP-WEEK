import java.util.Arrays;

public class Question1 {
    public static void main(String[] args) {
        int[] marks = {45, 67, 50, 32, 89, 76};

        System.out.println("Marks 50 or above:");
        for (int mark : marks) {
            if (mark >= 50) {
                System.out.print(mark + " ");
            }
        }

        int[] newMarks = new int[marks.length];
        int total = 0;

        for (int i = 0; i < marks.length; i++) {
            newMarks[i] = Math.min(marks[i] + 5, 100);
            total += newMarks[i];
        }

        System.out.println("\nMarks after grace marks: " + Arrays.toString(newMarks));
        System.out.println("Total marks: " + total);
    }
}
