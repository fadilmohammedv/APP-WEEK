public class Question7 {
    public static void main(String[] args) {
        String[][] slots = {
            {"S1", "Car", "Available"},
            {"S2", "Bike", "Occupied"},
            {"S3", "Car", "Available"},
            {"S4", "Bike", "Available"},
            {"S5", "Car", "Occupied"}
        };

        System.out.println("Available car parking slots:");
        for (String[] slot : slots) {
            if (slot[1].equals("Car") && slot[2].equals("Available")) {
                System.out.println(slot[0]);
            }
        }
    }
}
