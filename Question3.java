import java.util.Arrays;

public class Question3 {
    static double discountedPrice(double price) {
        if (price > 1000) {
            return price * 0.80;
        }
        return price;
    }

    public static void main(String[] args) {
        double[] prices = {800, 1200, 1500, 950, 2000};
        double[] newPrices = new double[prices.length];

        System.out.print("Products above 1000: ");
        for (double price : prices) {
            if (price > 1000) {
                System.out.print(price + " ");
            }
        }

        for (int i = 0; i < prices.length; i++) {
            newPrices[i] = discountedPrice(prices[i]);
        }

        System.out.println("\nPrices after discount: " + Arrays.toString(newPrices));
        System.out.println("Original prices: " + Arrays.toString(prices));
    }
}
