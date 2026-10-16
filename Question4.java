import java.util.Arrays;

public class Question4 {
    static double electricityBill(int[] units) {
        int totalUnits = 0;

        for (int unit : units) {
            totalUnits += unit;
        }

        return totalUnits * 6;
    }

    public static void main(String[] args) {
        int[] consumption = {8, 12, 9, 15, 7, 11};
        int totalUnits = 0;

        System.out.print("Consumption above 10 units: ");
        for (int unit : consumption) {
            if (unit > 10) {
                System.out.print(unit + " ");
            }
        }

        System.out.print("\nDaily electricity cost: ");
        for (int unit : consumption) {
            System.out.print((unit * 6) + " ");
            totalUnits += unit;
        }

        System.out.println("\nTotal consumption: " + totalUnits);
        System.out.println("Total electricity bill: " + electricityBill(consumption));
        System.out.println("Original consumption: " + Arrays.toString(consumption));
    }
}
