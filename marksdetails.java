public class marksdetails {

    static class Marks {
        int mark1;
        int mark2;
        int mark3;

        Marks(int mark1, int mark2, int mark3) {
            this.mark1 = mark1;
            this.mark2 = mark2;
            this.mark3 = mark3;
        }

        void display() {
            int total = mark1 + mark2 + mark3;
            double average = total / 3.0;

            System.out.println("Mark 1: " + mark1);
            System.out.println("Mark 2: " + mark2);
            System.out.println("Mark 3: " + mark3);
            System.out.println("Total Marks: " + total);
            System.out.println("Average Marks: " + average);
        }
    }

    public static void main(String[] args) {
        Marks m1 = new Marks(85, 90, 80);

        m1.display();
    }
}
