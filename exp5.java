
class Traffic extends Thread {
    int delay;

    Traffic(int delay) {
        this.delay = delay;
    }

    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(
                    Thread.currentThread().getName()
                    + " - Traffic Status: "
                    + "Monitoring Junction - " + i
                );

                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class exp5 {
    public static void main(String[] args) {

        Traffic t1 = new Traffic(1000);
        Traffic t2 = new Traffic(2000);
        Traffic t3 = new Traffic(3000);

        t1.setName("Junction 1");
        t2.setName("Junction 2");
        t3.setName("Junction 3");

        t1.start();
        t2.start();
        t3.start();
    }
}