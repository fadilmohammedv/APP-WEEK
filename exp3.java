
class ExamTask implements Runnable {
    public void run() {
        String activity = Thread.currentThread().getName();

        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(
                    Thread.currentThread().getName()
                    + " : " + activity
                );

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class exp3 {
    public static void main(String[] args) {

        ExamTask timer = new ExamTask();
        ExamTask save = new ExamTask();
        ExamTask network = new ExamTask();

        Thread t1 = new Thread(timer);
        Thread t2 = new Thread(save);
        Thread t3 = new Thread(network);

        t1.setName("Timer - Displaying remaining time");
        t2.setName("AutoSave - Saving answers");
        t3.setName("Network - Checking connection");

        t1.start();
        t2.start();
        t3.start();
    }
}