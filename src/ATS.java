import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class ATS implements Runnable {
    private final int CALL_TIME = 100;
    private final int NUMBER_OF_CALLS = 200;
    private BlockingQueue<Call> queue;

    public ATS(BlockingQueue<Call> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < NUMBER_OF_CALLS; i++) {
                queue.put(new Call());
                Thread.sleep(CALL_TIME);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread.currentThread().interrupt();
    }

}

