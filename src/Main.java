import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static LinkedBlockingQueue<Call> queue = new LinkedBlockingQueue<>();
    private static int REPLY_START_DELAY = 2000;

    public static void main(String[] args) throws InterruptedException {

        Thread ats = new Thread(new ATS(queue));
        ats.start();
        Thread.sleep(REPLY_START_DELAY);
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Callable<Object>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Executors.callable(new Specialist(queue)));
        }
        service.invokeAll(list);

        service.shutdown();

    }

}
