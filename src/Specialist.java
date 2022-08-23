import java.util.concurrent.LinkedBlockingQueue;

public class Specialist implements Runnable {
    private final int RESPONSE_DELAY = 2000;
    private LinkedBlockingQueue<Call> queue;

    public Specialist(LinkedBlockingQueue<Call> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Call call;

        while ((call = queue.poll()) != null) {

            System.out.println(call + " answer");
            try {
                Thread.sleep(RESPONSE_DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Thread.currentThread().interrupt();
    }
}
