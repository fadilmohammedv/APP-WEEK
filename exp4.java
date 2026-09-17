
class BankTask implements Runnable {
    public void run() {
        String activity = Thread.currentThread().getName();

        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(
                    Thread.currentThread().getName()
                    + " - " + activity
                    + " - Execution: " + i
                );

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class exp4 {
    public static void main(String[] args) {

        BankTask t1 = new BankTask();
        BankTask t2 = new BankTask();
        BankTask t3 = new BankTask();

        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        Thread th3 = new Thread(t3);

        th1.setName("Transaction Processing");
        th2.setName("Balance Updating");
        th3.setName("SMS Notification");

        th1.start();
        th2.start();
        th3.start();
    }
}