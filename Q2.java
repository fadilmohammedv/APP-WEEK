class TaskThread extends Thread {
    private final String activity;
    TaskThread(String name, String activity) {
        super(name);
        this.activity = activity;
    }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread: " + getName() + " | Priority: " + getPriority()
                    + " | Activity: " + activity + " (step " + i + ")");
            try { Thread.sleep(400); } catch (InterruptedException e) { }
        }
    }
}

public class Q2_FoodDelivery {
    public static void main(String[] args) {
        TaskThread order = new TaskThread("OrderProcessing", "Processing customer order");
        TaskThread track = new TaskThread("DeliveryTracking", "Tracking delivery location");
        TaskThread notify = new TaskThread("Notification", "Sending order-status notification");

        order.setPriority(10);
        track.setPriority(7);
        notify.setPriority(4);

        order.start();
        track.start();
        notify.start();
    }
}
